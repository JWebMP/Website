package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.AgChartsEnterprisePluginPage;
@NgComponent("jwebmp-pcomp-ag-radar-line-series-options")
@NgRoutable(path = "plugins/agcharts-enterprise/ag-radar-line-series-options")
public class AgRadarLineSeriesPluginCompPage extends PluginComponentPage<AgRadarLineSeriesPluginCompPage>
{
    public AgRadarLineSeriesPluginCompPage()
    {
        super("agcharts-enterprise", "AG Charts Enterprise", AgChartsEnterprisePluginPage.COMPONENTS.get(9));
    }
}

