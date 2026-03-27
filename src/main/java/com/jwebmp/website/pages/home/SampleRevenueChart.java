package com.jwebmp.website.pages.home;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.plugins.agcharts.AgBarChart;

import java.util.List;
import java.util.Map;

/**
 * Sample AG Bar Chart used on the home page to demonstrate real rendered HTML output.
 * Not an Angular component — only used to produce a toString(true) preview.
 */
@NgComponent("sample-revenue-chart")
public class SampleRevenueChart extends AgBarChart<SampleRevenueChart> implements INgComponent<SampleRevenueChart> {
    public SampleRevenueChart() {
        super("revenueChart", "region", "revenue");
        setXName("Region");
        setYName("Revenue ($)");
        setData(List.of(
                Map.of("region", "North America", "revenue", 105500),
                Map.of("region", "Europe", "revenue", 103000),
                Map.of("region", "Asia Pacific", "revenue", 110500),
                Map.of("region", "Latin America", "revenue", 36500)
        ));
    }
}

