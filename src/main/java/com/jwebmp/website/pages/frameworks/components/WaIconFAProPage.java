package com.jwebmp.website.pages.frameworks.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.frameworks.FrameworkComponentPage;
import com.jwebmp.website.pages.frameworks.WebAwesomeProFrameworkPage;
@NgComponent("jwebmp-comp-pro-wa-icon-fa")
@NgRoutable(path = "frameworks/web-awesome-pro/wa-icon-fa")
public class WaIconFAProPage extends FrameworkComponentPage<WaIconFAProPage>
{
    public WaIconFAProPage()
    {
        super("web-awesome-pro", "Web Awesome Pro", WebAwesomeProFrameworkPage.COMPONENTS.get(12));
    }
}

