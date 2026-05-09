package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.AgChartsEnterprisePluginPage;
@NgComponent("jwebmp-pcomp-ag-radial-bar-series-options")
@NgRoutable(path = "plugins/agcharts-enterprise/ag-radial-bar-series-options")
public class AgRadialBarSeriesPluginCompPage extends PluginComponentPage<AgRadialBarSeriesPluginCompPage>
{
    public AgRadialBarSeriesPluginCompPage()
    {
        super("agcharts-enterprise", "AG Charts Enterprise", AgChartsEnterprisePluginPage.COMPONENTS.get(8));
    }
}

