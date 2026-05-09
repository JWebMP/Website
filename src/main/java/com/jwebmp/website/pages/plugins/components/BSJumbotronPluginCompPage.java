package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.BootstrapPluginPage;
@NgComponent("jwebmp-pcomp-bsjumbotron")
@NgRoutable(path = "plugins/bootstrap/bsjumbotron")
public class BSJumbotronPluginCompPage extends PluginComponentPage<BSJumbotronPluginCompPage>
{
    public BSJumbotronPluginCompPage()
    {
        super("bootstrap", "Bootstrap", BootstrapPluginPage.COMPONENTS.get(20));
    }
}
