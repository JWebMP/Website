package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.ClientPluginPage;
@NgComponent("jwebmp-pcomp-ipage-configurator")
@NgRoutable(path = "plugins/client/ipage-configurator")
public class IPageConfiguratorPluginCompPage extends PluginComponentPage<IPageConfiguratorPluginCompPage>
{
    public IPageConfiguratorPluginCompPage()
    {
        super("client", "Client", ClientPluginPage.COMPONENTS.get(2));
    }
}
