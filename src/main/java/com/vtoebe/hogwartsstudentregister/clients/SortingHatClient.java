package com.vtoebe.hogwartsstudentregister.clients;

import com.vtoebe.hogwartsstudentregister.payloads.clients.HouseInfo;
import com.vtoebe.hogwartsstudentregister.payloads.clients.HouseToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
@Slf4j
public class SortingHatClient {

    @Value("${example.client.sort}")
    private String sortURL;

    @Value("${example.client.house}")
    private String houseURL;

    private final RestTemplate restTemplate = new RestTemplate();
    private final HttpHeaders headers = new HttpHeaders();

    public HouseToken sort(){
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<HouseToken> houseTokenResponse = restTemplate.exchange(
                sortURL,
                HttpMethod.GET,
                entity,
                HouseToken.class
        );

        if(houseTokenResponse.getStatusCode().isError()) { return null; }
        return houseTokenResponse.getBody();
    }

    @Cacheable(cacheNames = "house", key = "#houseToken")
    public HouseInfo getHouseInfo(UUID houseToken) {
        log.info("searching for house with toke: " + houseToken.toString());
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<HouseInfo> houseInfoResponse = restTemplate.exchange(
                houseURL,
                HttpMethod.GET,
                entity,
                HouseInfo.class,
                houseToken
        );

        if (houseInfoResponse.getStatusCode().isError()) { return null; }
        return houseInfoResponse.getBody();
    }
}
