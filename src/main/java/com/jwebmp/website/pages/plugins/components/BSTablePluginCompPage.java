package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.BootstrapPluginPage;
@NgComponent("jwebmp-pcomp-bstable")
@NgRoutable(path = "plugins/bootstrap/bstable")
public class BSTablePluginCompPage extends PluginComponentPage<BSTablePluginCompPage>
{
    public BSTablePluginCompPage()
    {
        super("bootstrap", "Bootstrap", BootstrapPluginPage.COMPONENTS.get(31));
    }
}
