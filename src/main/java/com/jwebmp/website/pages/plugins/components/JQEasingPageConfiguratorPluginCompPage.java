package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.EasingPluginPage;
@NgComponent("jwebmp-pcomp-jqeasing-page-configurator")
@NgRoutable(path = "plugins/easing/jqeasing-page-configurator")
public class JQEasingPageConfiguratorPluginCompPage extends PluginComponentPage<JQEasingPageConfiguratorPluginCompPage>
{
    public JQEasingPageConfiguratorPluginCompPage()
    {
        super("easing", "Easing", EasingPluginPage.COMPONENTS.get(1));
    }
}

