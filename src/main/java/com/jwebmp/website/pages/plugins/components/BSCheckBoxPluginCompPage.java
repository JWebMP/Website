package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.BootstrapPluginPage;
@NgComponent("jwebmp-pcomp-bscheck-box")
@NgRoutable(path = "plugins/bootstrap/bscheck-box")
public class BSCheckBoxPluginCompPage extends PluginComponentPage<BSCheckBoxPluginCompPage>
{
    public BSCheckBoxPluginCompPage()
    {
        super("bootstrap", "Bootstrap", BootstrapPluginPage.COMPONENTS.get(6));
    }
}
