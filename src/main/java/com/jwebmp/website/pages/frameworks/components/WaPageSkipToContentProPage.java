package com.jwebmp.website.pages.frameworks.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.frameworks.FrameworkComponentPage;
import com.jwebmp.website.pages.frameworks.WebAwesomeFrameworkPage;
@NgComponent("jwebmp-comp-pro-wa-page-skip-to-content")
@NgRoutable(path = "frameworks/web-awesome/wa-page-skip-to-content")
public class WaPageSkipToContentProPage extends FrameworkComponentPage<WaPageSkipToContentProPage>
{
    public WaPageSkipToContentProPage()
    {
        super("web-awesome", "Web Awesome", WebAwesomeFrameworkPage.COMPONENTS.get(16));
    }
}

