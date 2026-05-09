package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.BootstrapPluginPage;
@NgComponent("jwebmp-pcomp-bsnav-bar")
@NgRoutable(path = "plugins/bootstrap/bsnav-bar")
public class BSNavBarPluginCompPage extends PluginComponentPage<BSNavBarPluginCompPage>
{
    public BSNavBarPluginCompPage()
    {
        super("bootstrap", "Bootstrap", BootstrapPluginPage.COMPONENTS.get(24));
    }
}
