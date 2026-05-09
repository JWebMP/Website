package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.BootstrapPluginPage;
@NgComponent("jwebmp-pcomp-bspagination")
@NgRoutable(path = "plugins/bootstrap/bspagination")
public class BSPaginationPluginCompPage extends PluginComponentPage<BSPaginationPluginCompPage>
{
    public BSPaginationPluginCompPage()
    {
        super("bootstrap", "Bootstrap", BootstrapPluginPage.COMPONENTS.get(26));
    }
}
