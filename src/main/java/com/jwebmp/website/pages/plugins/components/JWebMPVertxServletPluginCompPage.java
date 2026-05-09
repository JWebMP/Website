package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.VertxPluginPage;
@NgComponent("jwebmp-pcomp-jweb-mpvertx-servlet")
@NgRoutable(path = "plugins/vertx/jweb-mpvertx-servlet")
public class JWebMPVertxServletPluginCompPage extends PluginComponentPage<JWebMPVertxServletPluginCompPage>
{
    public JWebMPVertxServletPluginCompPage()
    {
        super("vertx", "Vert.x", VertxPluginPage.COMPONENTS.get(0));
    }
}
