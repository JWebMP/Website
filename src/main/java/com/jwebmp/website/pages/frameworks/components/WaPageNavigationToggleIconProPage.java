package com.jwebmp.website.pages.frameworks.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.frameworks.FrameworkComponentPage;
import com.jwebmp.website.pages.frameworks.WebAwesomeFrameworkPage;
@NgComponent("jwebmp-comp-pro-wa-page-navigation-toggle-icon")
@NgRoutable(path = "frameworks/web-awesome/wa-page-navigation-toggle-icon")
public class WaPageNavigationToggleIconProPage extends FrameworkComponentPage<WaPageNavigationToggleIconProPage>
{
    public WaPageNavigationToggleIconProPage()
    {
        super("web-awesome", "Web Awesome", WebAwesomeFrameworkPage.COMPONENTS.get(13));
    }
}

