package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.ClientPluginPage;
@NgComponent("jwebmp-pcomp-ipage")
@NgRoutable(path = "plugins/client/ipage")
public class IPagePluginCompPage extends PluginComponentPage<IPagePluginCompPage>
{
    public IPagePluginCompPage()
    {
        super("client", "Client", ClientPluginPage.COMPONENTS.get(3));
    }
}
