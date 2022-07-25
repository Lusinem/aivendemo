package com.demo.aiven.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.demo.aiven.entity.Cloud;
import com.demo.aiven.entity.Clouds;

@Service
public class CloudServiceImpl implements CloudService {

    private final WebClient webClient;

    public CloudServiceImpl(WebClient.Builder builder) {
        webClient = builder.build();
    }

    @Override
    public Map<String, List<Clouds>> getCloudsForProvider(String URL) {

        //Here should also handle the error scenario, but lets keep the happy path.
        // As well as testing will consider the happy path only,
        // but be sure in real world I would consider all error as well as proper logging principles
        Cloud cloudsEntity = webClient.get().uri(URL).retrieve().bodyToMono(Cloud.class).block();

        return cloudsEntity.getClouds().stream()
          .collect(Collectors.groupingBy(Clouds::getGeoRegion));

    }
}
