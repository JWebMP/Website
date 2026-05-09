package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.BootstrapPluginPage;
@NgComponent("jwebmp-pcomp-bspop-over")
@NgRoutable(path = "plugins/bootstrap/bspop-over")
public class BSPopOverPluginCompPage extends PluginComponentPage<BSPopOverPluginCompPage>
{
    public BSPopOverPluginCompPage()
    {
        super("bootstrap", "Bootstrap", BootstrapPluginPage.COMPONENTS.get(27));
    }
}
