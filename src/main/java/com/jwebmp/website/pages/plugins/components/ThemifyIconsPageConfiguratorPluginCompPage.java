package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.ThemifyIconsPluginPage;
@NgComponent("jwebmp-pcomp-themify-icons-page-configurator")
@NgRoutable(path = "plugins/themify-icons/themify-icons-page-configurator")
public class ThemifyIconsPageConfiguratorPluginCompPage extends PluginComponentPage<ThemifyIconsPageConfiguratorPluginCompPage>
{
    public ThemifyIconsPageConfiguratorPluginCompPage() { super("themify-icons", "Themify Icons", ThemifyIconsPluginPage.COMPONENTS.get(2)); }
}

