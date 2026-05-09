package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.AgChartsPluginPage;
@NgComponent("jwebmp-pcomp-ag-combination-chart")
@NgRoutable(path = "plugins/agcharts/ag-combination-chart")
public class AgCombinationChartPluginCompPage extends PluginComponentPage<AgCombinationChartPluginCompPage>
{
    public AgCombinationChartPluginCompPage()
    {
        super("agcharts", "AG Charts", AgChartsPluginPage.COMPONENTS.get(8));
    }
}

