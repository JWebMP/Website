package com.jwebmp.website.pages.home;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.plugins.aggrid.AgGrid;
import com.jwebmp.plugins.aggrid.options.AgGridColumnDef;

import java.util.*;

/**
 * Sample AG Grid used on the home page to demonstrate real rendered HTML output.
 * Not an Angular component — only used to produce a toString(true) preview.
 */
@NgComponent("sample-sales-grid")
public class SampleSalesGrid extends AgGrid<SampleSalesGrid> implements INgComponent<SampleSalesGrid> {
    public SampleSalesGrid() {
        setID("salesGrid");
        addColumnDef(new AgGridColumnDef<>()
                .setField("region").setHeaderName("Region").setFilter(true).setSortable(true));
        addColumnDef(new AgGridColumnDef<>()
                .setField("product").setHeaderName("Product").setFilter(true).setSortable(true));
        addColumnDef(new AgGridColumnDef<>()
                .setField("units").setHeaderName("Units Sold").setSortable(true));
        addColumnDef(new AgGridColumnDef<>()
                .setField("revenue").setHeaderName("Revenue").setSortable(true));
        addColumnDef(new AgGridColumnDef<>()
                .setField("profit").setHeaderName("Profit").setSortable(true));
    }

    @Override
    public Collection fetchData() {
        return List.of(
                Map.of("region", "North America", "product", "Widget A", "units", 1240, "revenue", 62000, "profit", 18600),
                Map.of("region", "North America", "product", "Widget B", "units", 870, "revenue", 43500, "profit", 13050),
                Map.of("region", "Europe", "product", "Widget A", "units", 960, "revenue", 48000, "profit", 14400),
                Map.of("region", "Europe", "product", "Widget B", "units", 1100, "revenue", 55000, "profit", 16500),
                Map.of("region", "Asia Pacific", "product", "Widget A", "units", 1530, "revenue", 76500, "profit", 22950),
                Map.of("region", "Asia Pacific", "product", "Widget B", "units", 680, "revenue", 34000, "profit", 10200),
                Map.of("region", "Latin America", "product", "Widget A", "units", 420, "revenue", 21000, "profit", 6300),
                Map.of("region", "Latin America", "product", "Widget B", "units", 310, "revenue", 15500, "profit", 4650)
        );
    }

    @Override
    public String getRowIdFieldName() {
        return "region";
    }
}
