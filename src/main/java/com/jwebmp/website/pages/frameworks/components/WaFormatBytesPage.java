package com.jwebmp.website.pages.frameworks.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.frameworks.FrameworkComponentPage;
import com.jwebmp.website.pages.frameworks.WebAwesomeFrameworkPage;
@NgComponent("jwebmp-comp-wa-format-bytes")
@NgRoutable(path = "frameworks/web-awesome/wa-format-bytes")
public class WaFormatBytesPage extends FrameworkComponentPage<WaFormatBytesPage>
{
    public WaFormatBytesPage()
    {
        super("web-awesome", "Web Awesome", WebAwesomeFrameworkPage.COMPONENTS.get(82));
    }
}

