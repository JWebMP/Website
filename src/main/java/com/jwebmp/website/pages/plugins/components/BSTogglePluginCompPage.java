package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.BootstrapPluginPage;
@NgComponent("jwebmp-pcomp-bstoggle")
@NgRoutable(path = "plugins/bootstrap/bstoggle")
public class BSTogglePluginCompPage extends PluginComponentPage<BSTogglePluginCompPage>
{
    public BSTogglePluginCompPage()
    {
        super("bootstrap", "Bootstrap", BootstrapPluginPage.COMPONENTS.get(34));
    }
}
