package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.references.NgComponentReference;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.components.modules.RouterModuleConfig;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-web-awesome")
@NgRoutable(path = "plugins/web-awesome")
@NgComponentReference(RouterModuleConfig.class)
public class WebAwesomePluginPage extends PluginDetailPage<WebAwesomePluginPage>
{
    public static final List<PluginEntry.ComponentInfo> COMPONENTS = List.of(
            new PluginEntry.ComponentInfo("WaButton",
                    "Button with variant (Brand, Success, Warning, Danger) and appearance options",
                    "com.jwebmp.webawesome.components.button",
                    List.of(
                            new PluginEntry.PropertyInfo("variant", "Variant", "Brand", "Color variant: Brand, Success, Warning, Danger, Neutral"),
                            new PluginEntry.PropertyInfo("appearance", "Appearance", "Filled", "Visual style: Filled, Outlined, Plain"),
                            new PluginEntry.PropertyInfo("size", "PageSize", "Medium", "Button size: Small, Medium, Large"),
                            new PluginEntry.PropertyInfo("disabled", "boolean", "false", "Disables the button"),
                            new PluginEntry.PropertyInfo("pill", "boolean", "false", "Renders fully rounded corners"),
                            new PluginEntry.PropertyInfo("loading", "boolean", "false", "Shows a loading spinner")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Basic Button",
                                    "Create a brand-coloured button.",
                                    "var btn = new WaButton<>(\"Click Me\", Variant.Brand);",
                                    "java"),
                            new PluginEntry.ExampleSnippet("Outlined Danger Button",
                                    "Outlined appearance with danger variant.",
                                    "var btn = new WaButton<>(\"Delete\", Variant.Danger);\nbtn.setAppearance(Appearance.Outlined);",
                                    "java"),
                            new PluginEntry.ExampleSnippet("Router Link Button",
                                    "Navigate to another route on click.",
                                    "var btn = new WaButton<>(\"Go Home\", Variant.Neutral);\nbtn.addAttribute(\"[routerLink]\", \"['/home']\");",
                                    "java")
                    ),
                    List.of(new PluginEntry.ConstructorInfo("new WaButton&lt;&gt;(String text, Variant variant)", "Creates a button with text and variant")),
                    List.of(
                            new PluginEntry.MethodInfo("setAppearance", "J", "setAppearance(Appearance appearance)", "Sets the visual appearance"),
                            new PluginEntry.MethodInfo("setVariant", "J", "setVariant(Variant variant)", "Sets the colour variant"),
                            new PluginEntry.MethodInfo("setPill", "J", "setPill(boolean pill)", "Enables fully rounded corners"),
                            new PluginEntry.MethodInfo("setLoading", "J", "setLoading(boolean loading)", "Shows a loading spinner")
                    ),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaCard",
                    "Card container with outlined/filled/plain appearance variants",
                    "com.jwebmp.webawesome.components.card",
                    List.of(
                            new PluginEntry.PropertyInfo("appearance", "Appearance", "Filled", "Visual style: Filled, Outlined, Plain"),
                            new PluginEntry.PropertyInfo("image", "String", null, "URL for a card header image")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Outlined Card with Content",
                                    "A simple outlined card with a heading and body text.",
                                    "var card = new WaCard<>();\ncard.setAppearance(Appearance.Outlined);\nvar stack = new WaStack<>();\nstack.add(new WaText<>().setText(\"Card Title\"));\nstack.add(new WaText<>().setText(\"Card body content\"));\ncard.add(stack);",
                                    "java")
                    ),
                    List.of(new PluginEntry.ConstructorInfo("new WaCard&lt;&gt;()", "Creates a card container")),
                    List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaStack", "Vertical stack layout with configurable gap", "com.jwebmp.webawesome.components",
                    List.of(), List.of(), List.of(new PluginEntry.ConstructorInfo("new WaStack&lt;&gt;()", "Creates a vertical stack")),
                    List.of(new PluginEntry.MethodInfo("setGap", "J", "setGap(PageSize gap)", "Sets the gap between children")),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaCluster", "Horizontal cluster layout with wrapping", "com.jwebmp.webawesome.components",
                    List.of(), List.of(), List.of(new PluginEntry.ConstructorInfo("new WaCluster&lt;&gt;()", "Creates a horizontal cluster")),
                    List.of(new PluginEntry.MethodInfo("setGap", "J", "setGap(PageSize gap)", "Sets the gap between children")),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaGrid", "CSS Grid layout with configurable min column size", "com.jwebmp.webawesome.components",
                    List.of(), List.of(), List.of(new PluginEntry.ConstructorInfo("new WaGrid&lt;&gt;()", "Creates a CSS grid")),
                    List.of(new PluginEntry.MethodInfo("setMinColumnSize", "J", "setMinColumnSize(String size)", "Sets the minimum column width")),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaTag", "Tag/badge component with variant styling", "com.jwebmp.webawesome.components.tag",
                    List.of(), List.of(), List.of(new PluginEntry.ConstructorInfo("new WaTag&lt;&gt;()", "Creates a tag")),
                    List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaDivider", "Horizontal divider line", "com.jwebmp.webawesome.components.divider",
                    List.of(), List.of(), List.of(new PluginEntry.ConstructorInfo("new WaDivider&lt;&gt;()", "Creates a divider")),
                    List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaTabs", "Tab container with tab/panel pairs", "com.jwebmp.webawesome.components.tab",
                    List.of(), List.of(), List.of(new PluginEntry.ConstructorInfo("new WaTabs&lt;&gt;()", "Creates a tab container")),
                    List.of(), List.of(), List.of(), List.of())
    );

    public WebAwesomePluginPage()
    {
        super(PluginCatalog.getById("web-awesome").orElseThrow());
    }

    @Override
    protected List<PluginEntry.ComponentInfo> pluginComponents()
    {
        return COMPONENTS;
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
