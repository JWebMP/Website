package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.MaterialDesignIconsPluginPage;
@NgComponent("jwebmp-pcomp-material-design-icon")
@NgRoutable(path = "plugins/material-design-icons/material-design-icon")
public class MaterialDesignIconPluginCompPage extends PluginComponentPage<MaterialDesignIconPluginCompPage>
{
    public MaterialDesignIconPluginCompPage() { super("material-design-icons", "Material Design Icons", MaterialDesignIconsPluginPage.COMPONENTS.get(0)); }
}

