package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.DataTablesPluginPage;
@NgComponent("jwebmp-pcomp-data-table-column-options")
@NgRoutable(path = "plugins/datatables/data-table-column-options")
public class DataTableColumnOptionsPluginCompPage extends PluginComponentPage<DataTableColumnOptionsPluginCompPage>
{
    public DataTableColumnOptionsPluginCompPage()
    {
        super("datatables", "DataTables", DataTablesPluginPage.COMPONENTS.get(3));
    }
}

