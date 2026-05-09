package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.AgChartsEnterprisePluginPage;
@NgComponent("jwebmp-pcomp-ag-radar-area-series-options")
@NgRoutable(path = "plugins/agcharts-enterprise/ag-radar-area-series-options")
public class AgRadarAreaSeriesPluginCompPage extends PluginComponentPage<AgRadarAreaSeriesPluginCompPage>
{
    public AgRadarAreaSeriesPluginCompPage()
    {
        super("agcharts-enterprise", "AG Charts Enterprise", AgChartsEnterprisePluginPage.COMPONENTS.get(10));
    }
}

