package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.FontAwesomePluginPage;
@NgComponent("jwebmp-pcomp-font-awesome-transforms")
@NgRoutable(path = "plugins/fontawesome/font-awesome-transforms")
public class FontAwesomeTransformsPluginCompPage extends PluginComponentPage<FontAwesomeTransformsPluginCompPage>
{
    public FontAwesomeTransformsPluginCompPage()
    {
        super("fontawesome", "Font Awesome", FontAwesomePluginPage.COMPONENTS.get(9));
    }
}

