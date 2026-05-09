package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.BootstrapPluginPage;
@NgComponent("jwebmp-pcomp-bsclose-icon")
@NgRoutable(path = "plugins/bootstrap/bsclose-icon")
public class BSCloseIconPluginCompPage extends PluginComponentPage<BSCloseIconPluginCompPage>
{
    public BSCloseIconPluginCompPage()
    {
        super("bootstrap", "Bootstrap", BootstrapPluginPage.COMPONENTS.get(11));
    }
}
