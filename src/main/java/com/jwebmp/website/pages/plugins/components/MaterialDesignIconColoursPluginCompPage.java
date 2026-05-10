package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.MaterialDesignIconsPluginPage;
@NgComponent("jwebmp-pcomp-material-design-icon-colours")
@NgRoutable(path = "plugins/material-design-icons/material-design-icon-colours")
public class MaterialDesignIconColoursPluginCompPage extends PluginComponentPage<MaterialDesignIconColoursPluginCompPage>
{
    public MaterialDesignIconColoursPluginCompPage() { super("material-design-icons", "Material Design Icons", MaterialDesignIconsPluginPage.COMPONENTS.get(4)); }
}

