package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.VertxPluginPage;
@NgComponent("jwebmp-pcomp-jweb-mpdata-servlet")
@NgRoutable(path = "plugins/vertx/jweb-mpdata-servlet")
public class JWebMPDataServletPluginCompPage extends PluginComponentPage<JWebMPDataServletPluginCompPage>
{
    public JWebMPDataServletPluginCompPage()
    {
        super("vertx", "Vert.x", VertxPluginPage.COMPONENTS.get(2));
    }
}
