package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.BootstrapPluginPage;
@NgComponent("jwebmp-pcomp-bsfigure")
@NgRoutable(path = "plugins/bootstrap/bsfigure")
public class BSFigurePluginCompPage extends PluginComponentPage<BSFigurePluginCompPage>
{
    public BSFigurePluginCompPage()
    {
        super("bootstrap", "Bootstrap", BootstrapPluginPage.COMPONENTS.get(16));
    }
}
