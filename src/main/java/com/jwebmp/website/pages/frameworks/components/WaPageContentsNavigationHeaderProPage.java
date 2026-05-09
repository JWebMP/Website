package com.jwebmp.website.pages.frameworks.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.frameworks.FrameworkComponentPage;
import com.jwebmp.website.pages.frameworks.WebAwesomeFrameworkPage;
@NgComponent("jwebmp-comp-pro-wa-page-contents-navigation-header")
@NgRoutable(path = "frameworks/web-awesome/wa-page-contents-navigation-header")
public class WaPageContentsNavigationHeaderProPage extends FrameworkComponentPage<WaPageContentsNavigationHeaderProPage>
{
    public WaPageContentsNavigationHeaderProPage()
    {
        super("web-awesome", "Web Awesome", WebAwesomeFrameworkPage.COMPONENTS.get(10));
    }
}

