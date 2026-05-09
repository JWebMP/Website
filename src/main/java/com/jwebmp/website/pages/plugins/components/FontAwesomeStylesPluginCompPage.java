package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.FontAwesomePluginPage;
@NgComponent("jwebmp-pcomp-font-awesome-styles")
@NgRoutable(path = "plugins/fontawesome/font-awesome-styles")
public class FontAwesomeStylesPluginCompPage extends PluginComponentPage<FontAwesomeStylesPluginCompPage>
{
    public FontAwesomeStylesPluginCompPage()
    {
        super("fontawesome", "Font Awesome", FontAwesomePluginPage.COMPONENTS.get(7));
    }
}

