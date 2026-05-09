package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.VertxPluginPage;
@NgComponent("jwebmp-pcomp-jweb-mpcssservlet")
@NgRoutable(path = "plugins/vertx/jweb-mpcssservlet")
public class JWebMPCSSServletPluginCompPage extends PluginComponentPage<JWebMPCSSServletPluginCompPage>
{
    public JWebMPCSSServletPluginCompPage()
    {
        super("vertx", "Vert.x", VertxPluginPage.COMPONENTS.get(3));
    }
}
