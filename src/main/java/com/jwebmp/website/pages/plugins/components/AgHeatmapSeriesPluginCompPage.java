package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.AgChartsEnterprisePluginPage;
@NgComponent("jwebmp-pcomp-ag-heatmap-series-options")
@NgRoutable(path = "plugins/agcharts-enterprise/ag-heatmap-series-options")
public class AgHeatmapSeriesPluginCompPage extends PluginComponentPage<AgHeatmapSeriesPluginCompPage>
{
    public AgHeatmapSeriesPluginCompPage()
    {
        super("agcharts-enterprise", "AG Charts Enterprise", AgChartsEnterprisePluginPage.COMPONENTS.get(13));
    }
}

