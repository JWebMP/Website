package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.BootstrapPluginPage;
@NgComponent("jwebmp-pcomp-bsswitch")
@NgRoutable(path = "plugins/bootstrap/bsswitch")
public class BSSwitchPluginCompPage extends PluginComponentPage<BSSwitchPluginCompPage>
{
    public BSSwitchPluginCompPage()
    {
        super("bootstrap", "Bootstrap", BootstrapPluginPage.COMPONENTS.get(8));
    }
}
