package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.MaterialDesignIconsPluginPage;
@NgComponent("jwebmp-pcomp-material-design-icon-themes")
@NgRoutable(path = "plugins/material-design-icons/material-design-icon-themes")
public class MaterialDesignIconThemesPluginCompPage extends PluginComponentPage<MaterialDesignIconThemesPluginCompPage>
{
    public MaterialDesignIconThemesPluginCompPage() { super("material-design-icons", "Material Design Icons", MaterialDesignIconsPluginPage.COMPONENTS.get(2)); }
}

