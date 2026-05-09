package com.jwebmp.website.pages.frameworks.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.frameworks.FrameworkComponentPage;
import com.jwebmp.website.pages.frameworks.WebAwesomeFrameworkPage;
@NgComponent("jwebmp-comp-wa-resize-observer")
@NgRoutable(path = "frameworks/web-awesome/wa-resize-observer")
public class WaResizeObserverPage extends FrameworkComponentPage<WaResizeObserverPage>
{
    public WaResizeObserverPage()
    {
        super("web-awesome", "Web Awesome", WebAwesomeFrameworkPage.COMPONENTS.get(90));
    }
}

