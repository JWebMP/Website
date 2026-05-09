package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.BootstrapPluginPage;
@NgComponent("jwebmp-pcomp-bscarousel")
@NgRoutable(path = "plugins/bootstrap/bscarousel")
public class BSCarouselPluginCompPage extends PluginComponentPage<BSCarouselPluginCompPage>
{
    public BSCarouselPluginCompPage()
    {
        super("bootstrap", "Bootstrap", BootstrapPluginPage.COMPONENTS.get(10));
    }
}
