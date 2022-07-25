package com.demo.aiven.service;

import java.util.List;
import java.util.Map;
import com.demo.aiven.entity.Clouds;

/**
 * Note: Nowadays many application skip interfaces when it is not being exposed.
 * In this case lets keep it, open for exposing.
 */
public interface CloudService {

    Map<String, List<Clouds>> getCloudsForProvider(String URL);
}
