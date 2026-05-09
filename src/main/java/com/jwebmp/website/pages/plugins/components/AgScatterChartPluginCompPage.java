package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.AgChartsPluginPage;
@NgComponent("jwebmp-pcomp-ag-scatter-chart")
@NgRoutable(path = "plugins/agcharts/ag-scatter-chart")
public class AgScatterChartPluginCompPage extends PluginComponentPage<AgScatterChartPluginCompPage>
{
    public AgScatterChartPluginCompPage()
    {
        super("agcharts", "AG Charts", AgChartsPluginPage.COMPONENTS.get(6));
    }
}

