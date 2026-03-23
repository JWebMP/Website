package com.jwebmp.website.pages.capabilities;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-cap-rendering")
@NgRoutable(path = "capabilities/rendering")
public class RenderingPage extends WebsitePage<RenderingPage> implements INgComponent<RenderingPage> {
    public RenderingPage() {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        var content = new WaStack();
        content.setGap(PageSize.Medium);
        var grid = grid(2);
        grid.add(featureCard("Complete HTML5 Element Library", "Every HTML5 element — Div, Span, Table, Form, Input (22 typed variants), Select, Canvas, Video, Article, Section — is a typed Java class with CRTP fluent API. Child constraints are enforced at compile time.", null));
        grid.add(featureCard("Typed CSS Builder", "14 CSS sub-packages: backgrounds, borders, colours, fonts, margins, padding, displays, text, tables, lists, outline, height/width, measurement, and animatable properties — all as Java annotations and builders.", null));
        grid.add(featureCard("Dual-Mode Output", "toString(true) renders full HTML with all CSS/JS assets for server-side rendering. toString() renders JSON for AJAX responses. Same component tree, two formats.", null));
        grid.add(featureCard("Component Hierarchy", "11-layer CRTP chain from ComponentBase to Component — each layer adds capabilities: hierarchy, HTML, attributes, options, styles, themes, data-binding, dependencies, features, events. Zero runtime overhead.", null));
        content.add(grid);
        layout.add(buildSection("RENDERING", "Type-Safe HTML, CSS, and JavaScript", "The entire web platform as Java types.", true, content));
        getMain().add(layout);
    }
}

