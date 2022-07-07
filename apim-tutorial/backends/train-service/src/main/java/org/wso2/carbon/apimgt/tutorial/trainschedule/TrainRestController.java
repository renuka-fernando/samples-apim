package org.wso2.carbon.apimgt.tutorial.trainschedule;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = { "*" })
@RequestMapping({ "/" }) // this is done since, consul service discovery feature do not support
// base paths in endpoints, hence enable to `curl http://127.0.0.1:8080/schedules/1` instead of
// `curl http://127.0.0.1:8080/train-schedule-info/v1/schedules/1` to make openAPI cleaner.
public class TrainRestController {
	TrainManager manager = TrainManager.getManager();

	@RequestMapping(method = { org.springframework.web.bind.annotation.RequestMethod.HEAD })
	public void handleHead() {
	}

	@GetMapping({ "/trains" })
	public List<TrainEntry> getSchedules() {
		return this.manager.getAllTrains();
	}

	@PostMapping({ "/trains" })
	public void addTrain(@RequestBody TrainEntry entry) {
		this.manager.addTrain(entry);
	}

	@GetMapping({ "/trains/{id}" })
	public TrainEntry getTrain(@PathVariable String id) {
		return this.manager.getTrain(id);
	}

	@PutMapping({ "/trains/{id}" })
	public void updateTrain(@RequestBody TrainEntry entry, @PathVariable String id) {
		this.manager.updateTrain(entry, id);
	}

	@DeleteMapping({ "/trains/{id}" })
	public void deleteTrain(@PathVariable String id) {
		this.manager.deleteTrain(id);
	}
}
