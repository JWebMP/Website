package com.jwebmp.website.pages.capabilities;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-cap-events")
@NgRoutable(path = "capabilities/event-system")
public class EventSystemPage extends WebsitePage<EventSystemPage> implements INgComponent<EventSystemPage> {
    public EventSystemPage() {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        var content = new WaStack();
        content.setGap(PageSize.Medium);
        var grid = grid(2);
        grid.add(featureCard("50+ Event Adapters", "OnClickAdapter, OnChangeAdapter, OnSubmitAdapter, OnDragAdapter, OnKeyDownAdapter, OnMouseEnterAdapter — each backed by a ServiceLoader SPI. Events must be named classes (no lambdas) for serialization and discovery.", null));
        grid.add(featureCard("AJAX Pipeline", "AjaxCall carries the event payload from browser to server. AjaxResponse returns DOM updates, component replacements, and script execution. The pipeline is fully reactive on Vert.x.", null));
        grid.add(featureCard("Feature System", "Feature<O,J> wraps a JavaScript library with typed options, CSS/JS references, and automatic dependency ordering. Features must be named classes for deduplication.", null));
        grid.add(featureCard("Call Interceptors", "SiteCallIntercepter, AjaxCallIntercepter, DataCallIntercepter — CRTP-based, sort-ordered, pluggable request processing for cross-cutting concerns like auth, logging, and metrics.", null));
        content.add(grid);
        layout.add(buildSection("EVENTS", "Server-Driven Event Handling", "Browser events fire Java handlers. Responses update the DOM.", true, content));
        getMain().add(layout);
    }
}

