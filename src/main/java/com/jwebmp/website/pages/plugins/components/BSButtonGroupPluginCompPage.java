package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.BootstrapPluginPage;
@NgComponent("jwebmp-pcomp-bsbutton-group")
@NgRoutable(path = "plugins/bootstrap/bsbutton-group")
public class BSButtonGroupPluginCompPage extends PluginComponentPage<BSButtonGroupPluginCompPage>
{
    public BSButtonGroupPluginCompPage()
    {
        super("bootstrap", "Bootstrap", BootstrapPluginPage.COMPONENTS.get(5));
    }
}
