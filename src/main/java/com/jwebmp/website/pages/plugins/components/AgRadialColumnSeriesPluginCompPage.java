package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.AgChartsEnterprisePluginPage;
@NgComponent("jwebmp-pcomp-ag-radial-column-series-options")
@NgRoutable(path = "plugins/agcharts-enterprise/ag-radial-column-series-options")
public class AgRadialColumnSeriesPluginCompPage extends PluginComponentPage<AgRadialColumnSeriesPluginCompPage>
{
    public AgRadialColumnSeriesPluginCompPage()
    {
        super("agcharts-enterprise", "AG Charts Enterprise", AgChartsEnterprisePluginPage.COMPONENTS.get(7));
    }
}

