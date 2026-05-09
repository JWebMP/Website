package com.jwebmp.website.pages.frameworks.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.frameworks.FrameworkComponentPage;
import com.jwebmp.website.pages.frameworks.WebAwesomeProFrameworkPage;
@NgComponent("jwebmp-comp-pro-wa-scatter-chart")
@NgRoutable(path = "frameworks/web-awesome-pro/wa-scatter-chart")
public class WaScatterChartProPage extends FrameworkComponentPage<WaScatterChartProPage>
{
    public WaScatterChartProPage()
    {
        super("web-awesome-pro", "Web Awesome Pro", WebAwesomeProFrameworkPage.COMPONENTS.get(8));
    }
}

