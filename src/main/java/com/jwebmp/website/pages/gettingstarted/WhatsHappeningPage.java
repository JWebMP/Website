package com.jwebmp.website.pages.gettingstarted;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-gs-whats-happening")
@NgRoutable(path = "getting-started/whats-happening")
public class WhatsHappeningPage extends WebsitePage<WhatsHappeningPage> implements INgComponent<WhatsHappeningPage> {
    public WhatsHappeningPage() {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        var content = new WaStack();
        content.setGap(PageSize.Medium);

        content.add(bodyText("Under the hood, what happened depends on your mode:", "m"));

        var grid = grid(2);

        grid.add(featureCard("Angular Mode — TypeScript Generated",
                "The Angular Maven Plugin scanned your @NgApp and @NgComponent classes and generated "
                        + ".ts files, angular.json, package.json, tsconfig.json, and routing modules.",
                null));

        grid.add(featureCard("Angular Mode — Angular Built",
                "npm install and ng build --configuration production ran automatically during mvn install. "
                        + "The output is a static SPA ready to deploy anywhere.",
                null));

        grid.add(featureCard("SSR Mode — Vert.x Serving",
                "IGuiceContext.inject() discovered JWebMPVertx via SPI, started a non-blocking HTTP server, "
                        + "and registered routes for pages, AJAX events, WebSockets, CSS, and scripts.",
                null));

        grid.add(featureCard("Both Modes — SPI Wired",
                "Every IPageConfigurator, IEventConfigurator, and render-ordering hook was discovered "
                        + "and applied — WebAwesome CSS/JS injected, theme classes added. "
                        + "Guice bindings resolved via ServiceLoader and module-info.java.",
                null));

        content.add(grid);

        layout.add(buildSection("UNDER THE HOOD",
                "What Just Happened?",
                "Same Java code — different runtime behaviour depending on your mode.",
                false, content));
        getMain().add(layout);
    }
}

