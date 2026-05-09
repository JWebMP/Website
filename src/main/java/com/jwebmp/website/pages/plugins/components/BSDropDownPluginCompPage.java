package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.BootstrapPluginPage;
@NgComponent("jwebmp-pcomp-bsdrop-down")
@NgRoutable(path = "plugins/bootstrap/bsdrop-down")
public class BSDropDownPluginCompPage extends PluginComponentPage<BSDropDownPluginCompPage>
{
    public BSDropDownPluginCompPage()
    {
        super("bootstrap", "Bootstrap", BootstrapPluginPage.COMPONENTS.get(15));
    }
}
