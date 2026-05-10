package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.GlyphiconsPluginPage;
@NgComponent("jwebmp-pcomp-glyphicons-page-configurator")
@NgRoutable(path = "plugins/glyphicons/glyphicons-page-configurator")
public class GlyphiconsPageConfiguratorPluginCompPage extends PluginComponentPage<GlyphiconsPageConfiguratorPluginCompPage>
{
    public GlyphiconsPageConfiguratorPluginCompPage() { super("glyphicons", "Glyphicons", GlyphiconsPluginPage.COMPONENTS.get(2)); }
}

