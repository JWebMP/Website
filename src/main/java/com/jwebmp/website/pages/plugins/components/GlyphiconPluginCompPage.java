package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.GlyphiconsPluginPage;
@NgComponent("jwebmp-pcomp-glyphicon")
@NgRoutable(path = "plugins/glyphicons/glyphicon")
public class GlyphiconPluginCompPage extends PluginComponentPage<GlyphiconPluginCompPage>
{
    public GlyphiconPluginCompPage() { super("glyphicons", "Glyphicons", GlyphiconsPluginPage.COMPONENTS.get(0)); }
}

