package com.jwebmp.website.pages.home;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.plugins.agcharts.AgBarChart;

/**
 * Sample AG Bar Chart used on the home page to demonstrate real rendered HTML output.
 * Not an Angular component — only used to produce a toString(true) preview.
 */
@NgComponent("sample-revenue-chart")
public class SampleRevenueChart extends AgBarChart<SampleRevenueChart> implements INgComponent<SampleRevenueChart> {
    public SampleRevenueChart() {
        super("revenueChart", "region", "revenue");
    }
}

