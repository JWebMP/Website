package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.DataTablesPluginPage;
@NgComponent("jwebmp-pcomp-data-table")
@NgRoutable(path = "plugins/datatables/data-table")
public class DataTablePluginCompPage extends PluginComponentPage<DataTablePluginCompPage>
{
    public DataTablePluginCompPage()
    {
        super("datatables", "DataTables", DataTablesPluginPage.COMPONENTS.get(0));
    }
}

