package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.JQueryPluginPage;
@NgComponent("jwebmp-pcomp-jquery-page-configurator")
@NgRoutable(path = "plugins/jquery/jquery-page-configurator")
public class JQueryPageConfiguratorPluginCompPage extends PluginComponentPage<JQueryPageConfiguratorPluginCompPage>
{
    public JQueryPageConfiguratorPluginCompPage()
    {
        super("jquery", "jQuery", JQueryPluginPage.COMPONENTS.get(0));
    }
}
