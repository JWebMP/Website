package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.AgChartsEnterprisePluginPage;
@NgComponent("jwebmp-pcomp-ag-sunburst-series-options")
@NgRoutable(path = "plugins/agcharts-enterprise/ag-sunburst-series-options")
public class AgSunburstSeriesPluginCompPage extends PluginComponentPage<AgSunburstSeriesPluginCompPage>
{
    public AgSunburstSeriesPluginCompPage()
    {
        super("agcharts-enterprise", "AG Charts Enterprise", AgChartsEnterprisePluginPage.COMPONENTS.get(3));
    }
}

