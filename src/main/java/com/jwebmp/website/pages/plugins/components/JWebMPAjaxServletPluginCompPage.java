package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.VertxPluginPage;
@NgComponent("jwebmp-pcomp-jweb-mpajax-servlet")
@NgRoutable(path = "plugins/vertx/jweb-mpajax-servlet")
public class JWebMPAjaxServletPluginCompPage extends PluginComponentPage<JWebMPAjaxServletPluginCompPage>
{
    public JWebMPAjaxServletPluginCompPage()
    {
        super("vertx", "Vert.x", VertxPluginPage.COMPONENTS.get(1));
    }
}
