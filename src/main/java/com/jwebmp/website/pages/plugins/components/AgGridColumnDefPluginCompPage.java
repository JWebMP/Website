package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.AgGridPluginPage;
@NgComponent("jwebmp-pcomp-ag-grid-column-def")
@NgRoutable(path = "plugins/aggrid/ag-grid-column-def")
public class AgGridColumnDefPluginCompPage extends PluginComponentPage<AgGridColumnDefPluginCompPage>
{
    public AgGridColumnDefPluginCompPage()
    {
        super("aggrid", "AG Grid", AgGridPluginPage.COMPONENTS.get(1));
    }
}
