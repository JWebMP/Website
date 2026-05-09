package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.AgGridPluginPage;
@NgComponent("jwebmp-pcomp-ag-grid")
@NgRoutable(path = "plugins/aggrid/ag-grid")
public class AgGridPluginCompPage extends PluginComponentPage<AgGridPluginCompPage>
{
    public AgGridPluginCompPage()
    {
        super("aggrid", "AG Grid", AgGridPluginPage.COMPONENTS.get(0));
    }
}
