package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.AgChartsPluginPage;
@NgComponent("jwebmp-pcomp-ag-chart-options")
@NgRoutable(path = "plugins/agcharts/ag-chart-options")
public class AgChartOptionsPluginCompPage extends PluginComponentPage<AgChartOptionsPluginCompPage>
{
    public AgChartOptionsPluginCompPage()
    {
        super("agcharts", "AG Charts", AgChartsPluginPage.COMPONENTS.get(9));
    }
}

