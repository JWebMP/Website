package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.WebAwesomeProPluginPage;
@NgComponent("jwebmp-pcomp-wa-banner")
@NgRoutable(path = "plugins/web-awesome-pro/wa-banner")
public class WaBannerPluginCompPage extends PluginComponentPage<WaBannerPluginCompPage>
{
    public WaBannerPluginCompPage()
    {
        super("web-awesome-pro", "Web Awesome Pro", WebAwesomeProPluginPage.COMPONENTS.get(1));
    }
}
