package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.FontAwesomeProPluginPage;
@NgComponent("jwebmp-pcomp-font-awesome5-pro-icons")
@NgRoutable(path = "plugins/fontawesome-pro/font-awesome5-pro-icons")
public class FontAwesome5ProIconsPluginCompPage extends PluginComponentPage<FontAwesome5ProIconsPluginCompPage>
{
    public FontAwesome5ProIconsPluginCompPage()
    {
        super("fontawesome-pro", "Font Awesome Pro", FontAwesomeProPluginPage.COMPONENTS.get(4));
    }
}

