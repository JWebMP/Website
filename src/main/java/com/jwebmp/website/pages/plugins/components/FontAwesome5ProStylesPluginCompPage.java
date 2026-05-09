package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.FontAwesomeProPluginPage;
@NgComponent("jwebmp-pcomp-font-awesome5-pro-styles")
@NgRoutable(path = "plugins/fontawesome-pro/font-awesome5-pro-styles")
public class FontAwesome5ProStylesPluginCompPage extends PluginComponentPage<FontAwesome5ProStylesPluginCompPage>
{
    public FontAwesome5ProStylesPluginCompPage()
    {
        super("fontawesome-pro", "Font Awesome Pro", FontAwesomeProPluginPage.COMPONENTS.get(1));
    }
}

