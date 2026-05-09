package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.BootstrapPluginPage;
@NgComponent("jwebmp-pcomp-bsprogress-bar")
@NgRoutable(path = "plugins/bootstrap/bsprogress-bar")
public class BSProgressBarPluginCompPage extends PluginComponentPage<BSProgressBarPluginCompPage>
{
    public BSProgressBarPluginCompPage()
    {
        super("bootstrap", "Bootstrap", BootstrapPluginPage.COMPONENTS.get(28));
    }
}
