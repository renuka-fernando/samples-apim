package org.wso2.carbon.apimgt.tutorial.trainschedule;

import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class ScheduleManager {
	private final AtomicLong counter = new AtomicLong();
	private final Map<String, ScheduleEntry> map = new ConcurrentHashMap<>();
	private final TrainsClient trainsClient = new TrainsClient();

	private static ScheduleManager manager = null;
	
	public static ScheduleManager getManager() {
		if (manager == null) {
			manager = new ScheduleManager();
		}
		return manager;
	}

	private ScheduleManager() {
		String id = Long.toString(this.counter.incrementAndGet());
		this.map.put(id, new ScheduleEntry(id, "14:50", "19:59", "London", "Glasgow", "1"));
		id = Long.toString(this.counter.incrementAndGet());
		this.map.put(id, new ScheduleEntry(id, "14:30", "19:20", "London", "Edinburgh", "2"));
		id = Long.toString(this.counter.incrementAndGet());
		this.map.put(id, new ScheduleEntry(id, "11:10", "12:59", "London", "Cardiff", "1"));
		id = Long.toString(this.counter.incrementAndGet());
		this.map.put(id, new ScheduleEntry(id, "08:30", "10:50", "London", "Manchester", "4"));
	}

	public List<ScheduleEntry> getAllSchedules() {
		return (List<ScheduleEntry>) this.map.values();
	}

	public List<ScheduleEntry> getAllScheduleInfo() {
		ResponseEntity<TrainEntry[]> trains = trainsClient.getTrains();
		return this.map.values().stream().peek(s -> {
			TrainEntry trainEntry = Arrays.stream(Objects.requireNonNull(trains.getBody()))
					.filter(t -> t.getTrainId().equals(s.getTrainId())).findFirst().orElse(new TrainEntry());
			s.setFacilities(trainEntry.getFacilities());
			s.setImageURL(trainEntry.getImageURL());
		}).collect(Collectors.toList());
	}

	public ScheduleEntry getSchedule(String id) {
		ScheduleEntry scheduleEntry = this.map.get(id);
		TrainEntry trainEntry = trainsClient.getTrain(scheduleEntry.getTrainId()).getBody();
		scheduleEntry.setFacilities(trainEntry.getFacilities());
		scheduleEntry.setImageURL(trainEntry.getImageURL());
		return scheduleEntry;
	}

	public void addScheduleEntry(ScheduleEntry entry) {
		String id = Long.toString(this.counter.incrementAndGet());
		entry.setEntryId(id);
		this.map.put(id, entry);
	}

	public void updateScheduleEntry(ScheduleEntry entry, String id) {
		entry.setEntryId(id);
		this.map.put(id, entry);
	}

	public void deleteScheduleEntry(String id) {
		this.map.remove(id);
	}
}
