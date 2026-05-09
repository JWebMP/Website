package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.AgChartsPluginPage;
@NgComponent("jwebmp-pcomp-ag-bubble-chart")
@NgRoutable(path = "plugins/agcharts/ag-bubble-chart")
public class AgBubbleChartPluginCompPage extends PluginComponentPage<AgBubbleChartPluginCompPage>
{
    public AgBubbleChartPluginCompPage()
    {
        super("agcharts", "AG Charts", AgChartsPluginPage.COMPONENTS.get(7));
    }
}

