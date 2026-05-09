package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.FontAwesomeProPluginPage;
@NgComponent("jwebmp-pcomp-font-awesome5-pro-page-configurator")
@NgRoutable(path = "plugins/fontawesome-pro/font-awesome5-pro-page-configurator")
public class FontAwesome5ProPageConfiguratorPluginCompPage extends PluginComponentPage<FontAwesome5ProPageConfiguratorPluginCompPage>
{
    public FontAwesome5ProPageConfiguratorPluginCompPage()
    {
        super("fontawesome-pro", "Font Awesome Pro", FontAwesomeProPluginPage.COMPONENTS.get(5));
    }
}

