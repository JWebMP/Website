package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.AgGridEnterprisePluginPage;
@NgComponent("jwebmp-pcomp-ag-grid-enterprise-options")
@NgRoutable(path = "plugins/aggrid-enterprise/ag-grid-enterprise-options")
public class AgGridEnterpriseOptionsPluginCompPage extends PluginComponentPage<AgGridEnterpriseOptionsPluginCompPage>
{
    public AgGridEnterpriseOptionsPluginCompPage()
    {
        super("aggrid-enterprise", "AG Grid Enterprise", AgGridEnterprisePluginPage.COMPONENTS.get(0));
    }
}

