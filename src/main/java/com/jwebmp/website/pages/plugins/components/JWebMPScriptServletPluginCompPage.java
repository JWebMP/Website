package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.VertxPluginPage;
@NgComponent("jwebmp-pcomp-jweb-mpscript-servlet")
@NgRoutable(path = "plugins/vertx/jweb-mpscript-servlet")
public class JWebMPScriptServletPluginCompPage extends PluginComponentPage<JWebMPScriptServletPluginCompPage>
{
    public JWebMPScriptServletPluginCompPage()
    {
        super("vertx", "Vert.x", VertxPluginPage.COMPONENTS.get(4));
    }
}
