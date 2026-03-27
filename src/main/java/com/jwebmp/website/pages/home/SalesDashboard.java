package com.jwebmp.website.pages.home;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.references.NgComponentReference;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.html.DivSimple;

/**
 * A sample Sales Dashboard page that demonstrates composing an AG Grid
 * data table with an AG Bar Chart — all defined in Java.
 * <p>
 * The annotation processor turns this into a routable Angular component with
 * the grid and chart wired automatically.
 */
@NgComponent("sales-dashboard")
@NgRoutable(path = "dashboard")
@NgComponentReference(SampleSalesGrid.class)
@NgComponentReference(SampleRevenueChart.class)
public class SalesDashboard extends DivSimple<SalesDashboard>
        implements INgComponent<SalesDashboard> {

    public SalesDashboard() {
        // ── AG Grid: regional sales data ──
        var grid = new SampleSalesGrid();
        add(grid);

        // ── AG Bar Chart: revenue by region ──
        var chart = new SampleRevenueChart();
        add(chart);
    }
}


