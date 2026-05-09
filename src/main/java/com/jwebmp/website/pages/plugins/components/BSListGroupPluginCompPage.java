package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.BootstrapPluginPage;
@NgComponent("jwebmp-pcomp-bslist-group")
@NgRoutable(path = "plugins/bootstrap/bslist-group")
public class BSListGroupPluginCompPage extends PluginComponentPage<BSListGroupPluginCompPage>
{
    public BSListGroupPluginCompPage()
    {
        super("bootstrap", "Bootstrap", BootstrapPluginPage.COMPONENTS.get(21));
    }
}
