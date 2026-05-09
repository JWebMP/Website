package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.BootstrapPluginPage;
@NgComponent("jwebmp-pcomp-bscollapse")
@NgRoutable(path = "plugins/bootstrap/bscollapse")
public class BSCollapsePluginCompPage extends PluginComponentPage<BSCollapsePluginCompPage>
{
    public BSCollapsePluginCompPage()
    {
        super("bootstrap", "Bootstrap", BootstrapPluginPage.COMPONENTS.get(12));
    }
}
