package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.AgChartsEnterprisePluginPage;
@NgComponent("jwebmp-pcomp-ag-range-bar-series-options")
@NgRoutable(path = "plugins/agcharts-enterprise/ag-range-bar-series-options")
public class AgRangeBarSeriesPluginCompPage extends PluginComponentPage<AgRangeBarSeriesPluginCompPage>
{
    public AgRangeBarSeriesPluginCompPage()
    {
        super("agcharts-enterprise", "AG Charts Enterprise", AgChartsEnterprisePluginPage.COMPONENTS.get(5));
    }
}

