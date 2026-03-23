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
    public WebAwesomeProPluginPage()
    {
        super(PluginCatalog.getById("web-awesome-pro").orElseThrow());
    }

    @Override
    protected List<PluginEntry.ComponentInfo> pluginComponents()
    {
        return List.of(
                new PluginEntry.ComponentInfo("WaPage", "Application shell with 18 sub-components", "com.jwebmp.webawesomepro"),
                new PluginEntry.ComponentInfo("WaBanner", "Top banner area for announcements", "com.jwebmp.webawesomepro"),
                new PluginEntry.ComponentInfo("WaHeader", "Application header with branding", "com.jwebmp.webawesomepro"),
                new PluginEntry.ComponentInfo("WaNavigation", "Primary navigation container", "com.jwebmp.webawesomepro"),
                new PluginEntry.ComponentInfo("WaMain", "Main content area with page size support", "com.jwebmp.webawesomepro"),
                new PluginEntry.ComponentInfo("WaAside", "Side panel for secondary content", "com.jwebmp.webawesomepro"),
                new PluginEntry.ComponentInfo("WaFooter", "Application footer", "com.jwebmp.webawesomepro")
        );
    }

    @Override
    protected List<PluginEntry.ExampleSnippet> pluginExamples()
    {
        return List.of(
                new PluginEntry.ExampleSnippet("Full Application Shell",
                        "Build a complete application shell with header, navigation, main content, and footer.",
                        "var page = new WaPage();\npage.getHeader().add(new WaText<>().setText(\"My Application\"));\npage.getNavigation().add(buildMenuItems());\npage.getMain().add(new RouterOutlet());\npage.getFooter().add(new WaText<>().setText(\"2026 My Corp\"));",
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
