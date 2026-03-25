package com.jwebmp.website.pages.home;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.plugins.aggrid.AgGrid;
import com.jwebmp.plugins.aggrid.options.AgGridColumnDef;

import java.util.Collection;
import java.util.List;

/**
 * Sample AG Grid used on the home page to demonstrate real rendered HTML output.
 * Not an Angular component — only used to produce a toString(true) preview.
 */
@NgComponent("sample-sales-grid")
public class SampleSalesGrid extends AgGrid<SampleSalesGrid> implements INgComponent<SampleSalesGrid> {
    public SampleSalesGrid() {
        setID("salesGrid");
        addColumnDef(new AgGridColumnDef<>()
                .setField("region").setHeaderName("Region"));
        addColumnDef(new AgGridColumnDef<>()
                .setField("revenue").setHeaderName("Revenue"));
    }

    @Override
    public Collection fetchData() {
        return List.of();
    }

    @Override
    public String getRowIdFieldName() {
        return "Region";
    }
}

