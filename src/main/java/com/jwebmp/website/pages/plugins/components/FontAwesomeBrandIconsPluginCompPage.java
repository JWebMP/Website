package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.FontAwesomePluginPage;
@NgComponent("jwebmp-pcomp-font-awesome-brand-icons")
@NgRoutable(path = "plugins/fontawesome/font-awesome-brand-icons")
public class FontAwesomeBrandIconsPluginCompPage extends PluginComponentPage<FontAwesomeBrandIconsPluginCompPage>
{
    public FontAwesomeBrandIconsPluginCompPage()
    {
        super("fontawesome", "Font Awesome", FontAwesomePluginPage.COMPONENTS.get(6));
    }
}
