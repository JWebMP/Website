package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.BootstrapPluginPage;
@NgComponent("jwebmp-pcomp-bsbreadcrumb-container")
@NgRoutable(path = "plugins/bootstrap/bsbreadcrumb-container")
public class BSBreadcrumbContainerPluginCompPage extends PluginComponentPage<BSBreadcrumbContainerPluginCompPage>
{
    public BSBreadcrumbContainerPluginCompPage()
    {
        super("bootstrap", "Bootstrap", BootstrapPluginPage.COMPONENTS.get(3));
    }
}
