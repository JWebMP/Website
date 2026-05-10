package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.MaterialIconsPluginPage;
@NgComponent("jwebmp-pcomp-mdiicon")
@NgRoutable(path = "plugins/material-icons/mdiicon")
public class MDIIconPluginCompPage extends PluginComponentPage<MDIIconPluginCompPage>
{
    public MDIIconPluginCompPage() { super("material-icons", "Material Icons", MaterialIconsPluginPage.COMPONENTS.get(0)); }
}

