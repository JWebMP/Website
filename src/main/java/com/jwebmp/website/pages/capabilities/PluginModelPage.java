package com.jwebmp.website.pages.capabilities;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-cap-plugins")
@NgRoutable(path = "capabilities/plugin-model")
public class PluginModelPage extends WebsitePage<PluginModelPage> implements INgComponent<PluginModelPage> {
    public PluginModelPage() {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        var content = new WaStack();
        content.setGap(PageSize.Medium);
        var grid = grid(2);
        grid.add(featureCard("JPMS Modules", "Every plugin ships a module-info.java with explicit exports, requires, provides, and uses. Clean dependency boundaries. JLink-ready for minimal Docker images.", null));
        grid.add(featureCard("SPI Discovery", "Plugins register via ServiceLoader (JPMS provides...with or META-INF/services). The framework discovers them at startup — no manual wiring.", null));
        grid.add(featureCard("Annotation-Driven Integration", "Plugins use the TypeScript Client annotation library (@NgComponent, @NgDirective, etc.) to describe their Angular integration. The build generates all TypeScript code.", null));
        grid.add(featureCard("Page Configurators", "IPageConfigurator implementations inject CSS, JS, meta tags, and transform the component tree before rendering. Plugins hook in via SPI.", null));
        content.add(grid);
        layout.add(buildSection("PLUGIN MODEL", "Modular, Discoverable, Composable", "Add a Maven dependency. The plugin integrates itself.", true, content));
        getMain().add(layout);
    }
}

