package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.ThemifyIconsPluginPage;
@NgComponent("jwebmp-pcomp-themify-icon")
@NgRoutable(path = "plugins/themify-icons/themify-icon")
public class ThemifyIconPluginCompPage extends PluginComponentPage<ThemifyIconPluginCompPage>
{
    public ThemifyIconPluginCompPage() { super("themify-icons", "Themify Icons", ThemifyIconsPluginPage.COMPONENTS.get(0)); }
}

