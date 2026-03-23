package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-fontawesome-pro")
@NgRoutable(path = "plugins/fontawesome-pro")
public class FontAwesomeProPluginPage extends PluginDetailPage<FontAwesomeProPluginPage>
{
    public FontAwesomeProPluginPage()
    {
        super(PluginCatalog.getById("fontawesome-pro").orElseThrow());
    }

    @Override
    protected List<PluginEntry.ExampleSnippet> pluginExamples()
    {
        return List.of(
                new PluginEntry.ExampleSnippet("Pro Icon Styles",
                        "Use the extended Pro icon styles — Regular, Light, Duotone, and Thin.",
                        "// Pro Regular icon\nFontAwesome icon = IFontAwesome.createIcon(\n    FontAwesomeIcons.user,\n    FontAwesomeStyles.Regular);\n\n// Pro Light icon\nFontAwesome light = IFontAwesome.createIcon(\n    FontAwesomeIcons.heart,\n    FontAwesomeStyles.Light);\n\n// Pro Duotone icon\nFontAwesome duo = IFontAwesome.createIcon(\n    FontAwesomeIcons.bell,\n    FontAwesomeStyles.Duotone);",
                        "java")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "provides", "FontAwesomeProPageConfigurator registers Pro icon packs — Regular, Light, Duotone, Thin SVG icons")
        );
    }
}
