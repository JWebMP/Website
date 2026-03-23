package com.jwebmp.website.pages.home;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-reactive-stack")
@NgRoutable(path = "home/reactive-stack")
public class ReactiveStackPage extends WebsitePage<ReactiveStackPage> implements INgComponent<ReactiveStackPage> {
    public ReactiveStackPage() {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);

        var content = new WaStack();
        content.setGap(PageSize.Medium);

        var grid = grid(2);

        grid.add(featureCard("Vert.x 5 Server",
                "Non-blocking, event-loop HTTP server. Pages, AJAX events, CSS, and scripts are served "
                        + "reactively. WebSocket broadcasting rides the Vert.x event bus.",
                null));

        grid.add(featureCard("GuicedEE Runtime",
                "Google Guice dependency injection, SPI-driven service discovery, call-scoped request handling, "
                        + "and JPMS module isolation — the same foundation as GuicedEE.",
                null));

        grid.add(featureCard("AJAX Event Pipeline",
                "Browser events fire Java handlers on the server. AjaxCall carries the payload; AjaxResponse "
                        + "returns DOM updates. 50+ event adapters — click, change, submit, drag, keyboard, and more.",
                null));

        grid.add(featureCard("Dual Rendering",
                "Every component renders as HTML (toString(true)) for server-side pages or JSON (toString()) "
                        + "for AJAX responses — same component tree, two output formats.",
                null));

        content.add(grid);

        layout.add(buildSection("REACTIVE STACK",
                "Built on Vert.x 5 and GuicedEE",
                "Non-blocking I/O, dependency injection, and SPI discovery — reactive from the ground up.",
                true, content));

        getMain().add(layout);
    }
}

