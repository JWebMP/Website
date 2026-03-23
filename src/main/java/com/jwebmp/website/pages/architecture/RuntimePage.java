package com.jwebmp.website.pages.architecture;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-arch-runtime")
@NgRoutable(path = "architecture/runtime")
public class RuntimePage extends WebsitePage<RuntimePage> implements INgComponent<RuntimePage> {
    public RuntimePage() {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        var content = new WaStack();
        content.setGap(PageSize.Medium);
        var grid = grid(2);

        grid.add(featureCard("Boot → Inject → Serve",
                "Boot.main() sets system properties and calls IGuiceContext.inject(). Guice scans modules, discovers SPI implementations, binds services, and starts the Vert.x HTTP server — all from a single line.", null));
        grid.add(featureCard("Vert.x Routes",
                "JWebMPVertx registers routes automatically: GET / for pages, POST /jwajax for AJAX events, GET /jwdata for data components, GET /jwcss for CSS, and /eventbus for STOMP WebSocket.", null));
        grid.add(featureCard("Call Scopes",
                "Every HTTP request enters a Guice CallScope. RoutingContext, request, response, and session data are available via injection anywhere in the call chain.", null));
        grid.add(featureCard("SPA Fallback",
                "Static assets are served from the Angular dist/ directory. Unmatched routes fall back to index.html for Angular Router client-side navigation.", null));

        content.add(grid);
        layout.add(buildSection("RUNTIME", "Reactive Server Architecture", "Vert.x event loop, Guice DI, call scopes, and SPA hosting.", true, content));
        getMain().add(layout);
    }
}

