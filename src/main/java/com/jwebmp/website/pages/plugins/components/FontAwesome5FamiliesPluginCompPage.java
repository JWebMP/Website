package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.FontAwesomeProPluginPage;
@NgComponent("jwebmp-pcomp-font-awesome5-families")
@NgRoutable(path = "plugins/fontawesome-pro/font-awesome5-families")
public class FontAwesome5FamiliesPluginCompPage extends PluginComponentPage<FontAwesome5FamiliesPluginCompPage>
{
    public FontAwesome5FamiliesPluginCompPage()
    {
        super("fontawesome-pro", "Font Awesome Pro", FontAwesomeProPluginPage.COMPONENTS.get(2));
    }
}

