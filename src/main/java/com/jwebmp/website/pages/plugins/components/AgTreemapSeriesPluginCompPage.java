package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.AgChartsEnterprisePluginPage;
@NgComponent("jwebmp-pcomp-ag-treemap-series-options")
@NgRoutable(path = "plugins/agcharts-enterprise/ag-treemap-series-options")
public class AgTreemapSeriesPluginCompPage extends PluginComponentPage<AgTreemapSeriesPluginCompPage>
{
    public AgTreemapSeriesPluginCompPage()
    {
        super("agcharts-enterprise", "AG Charts Enterprise", AgChartsEnterprisePluginPage.COMPONENTS.get(2));
    }
}

