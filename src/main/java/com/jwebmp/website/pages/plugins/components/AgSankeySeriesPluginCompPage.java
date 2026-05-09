package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.AgChartsEnterprisePluginPage;
@NgComponent("jwebmp-pcomp-ag-sankey-series-options")
@NgRoutable(path = "plugins/agcharts-enterprise/ag-sankey-series-options")
public class AgSankeySeriesPluginCompPage extends PluginComponentPage<AgSankeySeriesPluginCompPage>
{
    public AgSankeySeriesPluginCompPage()
    {
        super("agcharts-enterprise", "AG Charts Enterprise", AgChartsEnterprisePluginPage.COMPONENTS.get(4));
    }
}

