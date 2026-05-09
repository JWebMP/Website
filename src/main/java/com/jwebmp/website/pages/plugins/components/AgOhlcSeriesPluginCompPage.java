package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.AgChartsEnterprisePluginPage;
@NgComponent("jwebmp-pcomp-ag-ohlc-series-options")
@NgRoutable(path = "plugins/agcharts-enterprise/ag-ohlc-series-options")
public class AgOhlcSeriesPluginCompPage extends PluginComponentPage<AgOhlcSeriesPluginCompPage>
{
    public AgOhlcSeriesPluginCompPage()
    {
        super("agcharts-enterprise", "AG Charts Enterprise", AgChartsEnterprisePluginPage.COMPONENTS.get(16));
    }
}

