package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.MaterialIconsPluginPage;
@NgComponent("jwebmp-pcomp-material-icons-page-configurator")
@NgRoutable(path = "plugins/material-icons/material-icons-page-configurator")
public class MaterialIconsPageConfiguratorPluginCompPage extends PluginComponentPage<MaterialIconsPageConfiguratorPluginCompPage>
{
    public MaterialIconsPageConfiguratorPluginCompPage() { super("material-icons", "Material Icons", MaterialIconsPluginPage.COMPONENTS.get(2)); }
}

