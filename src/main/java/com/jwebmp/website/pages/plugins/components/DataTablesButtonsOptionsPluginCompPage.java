package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.DataTablesPluginPage;
@NgComponent("jwebmp-pcomp-data-tables-buttons-options")
@NgRoutable(path = "plugins/datatables/data-tables-buttons-options")
public class DataTablesButtonsOptionsPluginCompPage extends PluginComponentPage<DataTablesButtonsOptionsPluginCompPage>
{
    public DataTablesButtonsOptionsPluginCompPage()
    {
        super("datatables", "DataTables", DataTablesPluginPage.COMPONENTS.get(5));
    }
}

