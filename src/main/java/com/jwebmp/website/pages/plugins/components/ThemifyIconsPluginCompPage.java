package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.ThemifyIconsPluginPage;
@NgComponent("jwebmp-pcomp-themify-icons")
@NgRoutable(path = "plugins/themify-icons/themify-icons")
public class ThemifyIconsPluginCompPage extends PluginComponentPage<ThemifyIconsPluginCompPage>
{
    public ThemifyIconsPluginCompPage() { super("themify-icons", "Themify Icons", ThemifyIconsPluginPage.COMPONENTS.get(1)); }
}

