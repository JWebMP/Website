package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-web-awesome-pro")
@NgRoutable(path = "plugins/web-awesome-pro")
public class WebAwesomeProPluginPage extends PluginDetailPage<WebAwesomeProPluginPage>
{
    public static final List<PluginEntry.ComponentInfo> COMPONENTS = List.of(
            new PluginEntry.ComponentInfo("WaPage", "Application shell with 18 sub-components", "com.jwebmp.webawesomepro",
                    List.of(), List.of(), List.of(new PluginEntry.ConstructorInfo("new WaPage&lt;&gt;()", "Creates an application shell")), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaBanner", "Top banner area for announcements", "com.jwebmp.webawesomepro",
                    List.of(), List.of(), List.of(new PluginEntry.ConstructorInfo("new WaBanner&lt;&gt;()", "Creates a banner")), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaHeader", "Application header with branding", "com.jwebmp.webawesomepro",
                    List.of(), List.of(), List.of(new PluginEntry.ConstructorInfo("new WaHeader&lt;&gt;()", "Creates a header")), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaNavigation", "Primary navigation container", "com.jwebmp.webawesomepro",
                    List.of(), List.of(), List.of(new PluginEntry.ConstructorInfo("new WaNavigation&lt;&gt;()", "Creates a navigation container")), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaMain", "Main content area with page size support", "com.jwebmp.webawesomepro",
                    List.of(), List.of(), List.of(new PluginEntry.ConstructorInfo("new WaMain&lt;&gt;()", "Creates a main content area")), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaAside", "Side panel for secondary content", "com.jwebmp.webawesomepro",
                    List.of(), List.of(), List.of(new PluginEntry.ConstructorInfo("new WaAside&lt;&gt;()", "Creates a side panel")), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaFooter", "Application footer", "com.jwebmp.webawesomepro",
                    List.of(), List.of(), List.of(new PluginEntry.ConstructorInfo("new WaFooter&lt;&gt;()", "Creates a footer")), List.of(), List.of(), List.of(), List.of())
    );

    public WebAwesomeProPluginPage()
    {
        super(PluginCatalog.getById("web-awesome-pro").orElseThrow());
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
                new PluginEntry.ExampleSnippet("Full Application Shell",
                        "Build a complete application shell with header, navigation, main content, and footer.",
                        "var page = new WaPage();\npage.getHeader().add(new WaText<>().setText(\"My Application\"));\npage.getNavigation().add(buildMenuItems());\npage.getMain().add(new RouterOutlet<>());\npage.getFooter().add(new WaText<>().setText(\"2026 My Corp\"));",
                        "java")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "provides", "Registers WaPage CSS/JS and angular-awesome directives")
        );
    }
}
