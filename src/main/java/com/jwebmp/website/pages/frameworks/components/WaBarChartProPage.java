package com.jwebmp.website.pages.frameworks.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.frameworks.FrameworkComponentPage;
import com.jwebmp.website.pages.frameworks.WebAwesomeProFrameworkPage;
@NgComponent("jwebmp-comp-pro-wa-bar-chart")
@NgRoutable(path = "frameworks/web-awesome-pro/wa-bar-chart")
public class WaBarChartProPage extends FrameworkComponentPage<WaBarChartProPage>
{
    public WaBarChartProPage()
    {
        super("web-awesome-pro", "Web Awesome Pro", WebAwesomeProFrameworkPage.COMPONENTS.get(3));
    }
}

