package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-web-awesome")
@NgRoutable(path = "plugins/web-awesome")
public class WebAwesomePluginPage extends PluginDetailPage<WebAwesomePluginPage>
{
    public WebAwesomePluginPage()
    {
        super(PluginCatalog.getById("web-awesome").orElseThrow());
    }

    @Override
    protected List<PluginEntry.ComponentInfo> pluginComponents()
    {
        return List.of(
                new PluginEntry.ComponentInfo("WaCard", "Card container with outlined/filled/plain appearance variants", "com.jwebmp.webawesome.components.card"),
                new PluginEntry.ComponentInfo("WaButton", "Button with variant (Brand, Success, Warning, Danger) and appearance options", "com.jwebmp.webawesome.components.button"),
                new PluginEntry.ComponentInfo("WaStack", "Vertical stack layout with configurable gap", "com.jwebmp.webawesome.components"),
                new PluginEntry.ComponentInfo("WaCluster", "Horizontal cluster layout with wrapping", "com.jwebmp.webawesome.components"),
                new PluginEntry.ComponentInfo("WaGrid", "CSS Grid layout with configurable min column size", "com.jwebmp.webawesome.components"),
                new PluginEntry.ComponentInfo("WaTag", "Tag/badge component with variant styling", "com.jwebmp.webawesome.components.tag"),
                new PluginEntry.ComponentInfo("WaDivider", "Horizontal divider line", "com.jwebmp.webawesome.components.divider"),
                new PluginEntry.ComponentInfo("WaTabs", "Tab container with tab/panel pairs", "com.jwebmp.webawesome.components.tab")
        );
    }

    @Override
    protected List<PluginEntry.ExampleSnippet> pluginExamples()
    {
        return List.of(
                new PluginEntry.ExampleSnippet("Card with Tabs",
                        "Create a card containing tabbed content.",
                        "var card = new WaCard<>();\ncard.setAppearance(Appearance.Outlined);\n\nvar tabs = new WaTabs<>();\nvar tab1 = new WaTab<>(\"Overview\");\nvar panel1 = new WaTabPanel<>();\npanel1.add(new WaText<>().setText(\"Tab content here\"));\ntabs.add(tab1);\ntabs.add(panel1);",
                        "java")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "provides", "WebAwesomePageConfigurator injects CSS/JS bundles and body theme classes"),
                new PluginEntry.SpiDetail("TypescriptIndexPageConfigurator", "provides", "Exported for cross-plugin asset reuse")
        );
    }
}
