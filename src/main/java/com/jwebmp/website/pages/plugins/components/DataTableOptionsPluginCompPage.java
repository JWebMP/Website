package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.DataTablesPluginPage;
@NgComponent("jwebmp-pcomp-data-table-options")
@NgRoutable(path = "plugins/datatables/data-table-options")
public class DataTableOptionsPluginCompPage extends PluginComponentPage<DataTableOptionsPluginCompPage>
{
    public DataTableOptionsPluginCompPage()
    {
        super("datatables", "DataTables", DataTablesPluginPage.COMPONENTS.get(2));
    }
}

