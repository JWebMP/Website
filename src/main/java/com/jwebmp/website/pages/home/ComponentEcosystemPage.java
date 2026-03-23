package com.jwebmp.website.pages.home;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.Variant;
import com.jwebmp.webawesome.components.WaCluster;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-component-ecosystem")
@NgRoutable(path = "home/component-ecosystem")
public class ComponentEcosystemPage extends WebsitePage<ComponentEcosystemPage> implements INgComponent<ComponentEcosystemPage> {
    public ComponentEcosystemPage() {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);

        var content = new WaStack();
        content.setGap(PageSize.Medium);

        content.add(bodyText(
                "Every plugin is a JPMS module. Add the Maven dependency, and the component is available as a "
                        + "type-safe Java class. The annotation processor generates the Angular integration automatically. "
                        + "No npm install, no Angular module registration — just Java.",
                "m"));

        var grid = grid(3);

        grid.add(featureCard("AG Grid & AG Charts",
                "Enterprise data grids and 38+ chart types — configured in Java, rendered in Angular.",
                "com.jwebmp.plugins:aggrid / agcharts"));

        grid.add(featureCard("WebAwesome",
                "Modern, accessible UI component library with dark mode, responsive layout, and 18+ WaPage sub-components.",
                "com.jwebmp.plugins:web-awesome"));

        grid.add(featureCard("FullCalendar",
                "Drag-and-drop scheduling, resource timelines, and multiple calendar views.",
                "com.jwebmp.plugins:fullcalendar"));

        grid.add(featureCard("RabbitMQ Comms",
                "Bidirectional messaging — WebSocket/STOMP bridge with Angular directives and session-aware channels.",
                "com.jwebmp:jwebmp-rabbitmq"));

        grid.add(featureCard("Font Awesome",
                "6,000+ icons (Free) or 10,000+ (Pro) rendered as SVG with type-safe Java enums.",
                "com.jwebmp.plugins:fontawesome"));

        grid.add(featureCard("Chart.js",
                "Lightweight charts — bar, line, pie, doughnut, radar — for dashboards and reports.",
                "com.jwebmp.plugins:chartjs"));

        content.add(grid);

        var ctas = new WaCluster<>();
        ctas.setGap(PageSize.Small);
        ctas.add(buildCta("Full Plugin Catalog", "/plugins", Variant.Brand, null));
        content.add(ctas);

        layout.add(buildSection("20+ PLUGINS",
                "Production-Ready Component Library",
                "Grids, charts, calendars, icons, messaging — all type-safe, all Java, all JPMS.",
                true, content));

        getMain().add(layout);
    }
}

