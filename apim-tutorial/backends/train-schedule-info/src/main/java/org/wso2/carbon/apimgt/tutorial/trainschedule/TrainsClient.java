package org.wso2.carbon.apimgt.tutorial.trainschedule;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class TrainsClient {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String trainsServiceURL = StringUtils.stripEnd(System.getenv("TRAIN_SERVICE_URL"),"/");
    private final String trainsServiceApiKey = System.getenv("TRAIN_SERVICE_API_KEY");
    private final String gatewayHost = System.getenv("GATEWAY_HOST");

    public ResponseEntity<TrainEntry> getTrain(String trainId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("apikey", trainsServiceApiKey);
        headers.add("host", gatewayHost);

        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        return restTemplate.exchange(trainsServiceURL + "/trains/" + trainId, HttpMethod.GET, entity, TrainEntry.class);
    }

    public ResponseEntity<TrainEntry[]> getTrains() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("apikey", trainsServiceApiKey);
        headers.add("host", gatewayHost);

        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        return restTemplate.exchange(trainsServiceURL + "/trains", HttpMethod.GET, entity, TrainEntry[].class);
    }
}
