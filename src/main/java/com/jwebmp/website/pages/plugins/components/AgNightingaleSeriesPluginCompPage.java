package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.AgChartsEnterprisePluginPage;
@NgComponent("jwebmp-pcomp-ag-nightingale-series-options")
@NgRoutable(path = "plugins/agcharts-enterprise/ag-nightingale-series-options")
public class AgNightingaleSeriesPluginCompPage extends PluginComponentPage<AgNightingaleSeriesPluginCompPage>
{
    public AgNightingaleSeriesPluginCompPage()
    {
        super("agcharts-enterprise", "AG Charts Enterprise", AgChartsEnterprisePluginPage.COMPONENTS.get(11));
    }
}

