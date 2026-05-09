package com.jwebmp.website.pages.frameworks.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.frameworks.FrameworkComponentPage;
import com.jwebmp.website.pages.frameworks.WebAwesomeFrameworkPage;
@NgComponent("jwebmp-comp-wa-intersection-observer")
@NgRoutable(path = "frameworks/web-awesome/wa-intersection-observer")
public class WaIntersectionObserverPage extends FrameworkComponentPage<WaIntersectionObserverPage>
{
    public WaIntersectionObserverPage()
    {
        super("web-awesome", "Web Awesome", WebAwesomeFrameworkPage.COMPONENTS.get(88));
    }
}

