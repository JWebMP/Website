package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.AgGridEnterprisePluginPage;
@NgComponent("jwebmp-pcomp-ag-grid-enterprise-column-def")
@NgRoutable(path = "plugins/aggrid-enterprise/ag-grid-enterprise-column-def")
public class AgGridEnterpriseColumnDefPluginCompPage extends PluginComponentPage<AgGridEnterpriseColumnDefPluginCompPage>
{
    public AgGridEnterpriseColumnDefPluginCompPage()
    {
        super("aggrid-enterprise", "AG Grid Enterprise", AgGridEnterprisePluginPage.COMPONENTS.get(1));
    }
}

