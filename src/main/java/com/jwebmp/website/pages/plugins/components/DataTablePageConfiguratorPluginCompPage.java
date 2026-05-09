package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.DataTablesPluginPage;
@NgComponent("jwebmp-pcomp-data-table-page-configurator")
@NgRoutable(path = "plugins/datatables/data-table-page-configurator")
public class DataTablePageConfiguratorPluginCompPage extends PluginComponentPage<DataTablePageConfiguratorPluginCompPage>
{
    public DataTablePageConfiguratorPluginCompPage()
    {
        super("datatables", "DataTables", DataTablesPluginPage.COMPONENTS.get(1));
    }
}

