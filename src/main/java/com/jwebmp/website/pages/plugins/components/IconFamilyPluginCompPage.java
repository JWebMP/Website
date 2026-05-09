package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.FontAwesomeProPluginPage;
@NgComponent("jwebmp-pcomp-icon-family")
@NgRoutable(path = "plugins/fontawesome-pro/icon-family")
public class IconFamilyPluginCompPage extends PluginComponentPage<IconFamilyPluginCompPage>
{
    public IconFamilyPluginCompPage()
    {
        super("fontawesome-pro", "Font Awesome Pro", FontAwesomeProPluginPage.COMPONENTS.get(3));
    }
}

