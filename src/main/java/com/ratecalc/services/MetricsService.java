package com.ratecalc.services;

import com.codahale.metrics.MetricRegistry;

/**
 * This service holds all operations for gathering metrics
 *
 * @Author Brian DeSimone
 * @Date 07/16/2018
 */
public class MetricsService {

    // VARIABLES FOR METRICS
    private static MetricRegistry metricRegistry = new MetricRegistry();

    /**
     * GETTER for gathering the metrics
     */
    public static MetricRegistry getMetricRegistry() {
        return metricRegistry;
    }
}
