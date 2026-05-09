package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.AgChartsEnterprisePluginPage;
@NgComponent("jwebmp-pcomp-ag-waterfall-series-options")
@NgRoutable(path = "plugins/agcharts-enterprise/ag-waterfall-series-options")
public class AgWaterfallSeriesPluginCompPage extends PluginComponentPage<AgWaterfallSeriesPluginCompPage>
{
    public AgWaterfallSeriesPluginCompPage()
    {
        super("agcharts-enterprise", "AG Charts Enterprise", AgChartsEnterprisePluginPage.COMPONENTS.get(1));
    }
}

