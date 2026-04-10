package com.jwebmp.website.pages;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.Variant;
import com.jwebmp.webawesome.components.WaCluster;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.webawesome.components.button.Appearance;

/**
 * Landing page for the JWebMP website.
 * <p>
 * Concise hero, key value propositions, plugin highlights, and CTAs.
 * Detailed technical content lives on the About page.
 */
@NgComponent("jwebmp-home")
@NgRoutable(path = "home", isDefault = true)
public class HomePage extends WebsitePage<HomePage> implements INgComponent<HomePage>
{
    public HomePage()
    {
        removeClass("website-content");

        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);

        layout.add(buildHero());
        layout.add(buildHighlights());
        layout.add(buildComponentEcosystem());
        layout.add(buildCallToAction());

        getMain().add(layout);
    }

    // ────────────────────────────────────────────────────────

    private WaStack buildHero()
    {
        var hero = new WaStack();
        hero.setGap(PageSize.Large);
        hero.setID("hero");
        hero.addClass("hero-banner");

        // Eyebrow
        var eyebrow = captionText("FULL-STACK JAVA WEB FRAMEWORK");
        eyebrow.addClass("hero-eyebrow");
        hero.add(eyebrow);

        // Main heading — extra large for impact
        var heading = headingText("h1", "xl", "Write Java. Ship Web Apps.");
        heading.addClass("hero-heading");
        hero.add(heading);

        // Subtitle
        var subtitle = bodyText(
                "Build complete web applications in pure Java. JWebMP generates Angular 21 SPAs "
                + "from annotated Java classes — or hosts on Vert.x 5 with GuicedEE services. "
                + "One language. Two modes. Zero TypeScript.",
                "l");
        subtitle.setWaColorText("quiet");
        subtitle.addClass("hero-subtitle");
        hero.add(subtitle);

        // Technology tags
        var tags = new WaCluster<>();
        tags.setGap(PageSize.Small);
        tags.addClass("hero-tags");
        tags.add(buildTag("Java 25+", Variant.Brand));
        tags.add(buildTag("Angular 21", Variant.Danger));
        tags.add(buildTag("Vert.x 5", Variant.Warning));
        tags.add(buildTag("JPMS", Variant.Success));
        tags.add(buildTag("20+ Plugins", Variant.Neutral));
        hero.add(tags);

        // Call-to-action buttons
        var ctas = new WaCluster<>();
        ctas.setGap(PageSize.Small);
        ctas.addClass("hero-ctas");
        ctas.add(buildCta("Get Started", "/getting-started", Variant.Brand, null));
        ctas.add(buildCta("About JWebMP", "/about", Variant.Neutral, Appearance.Outlined));
        ctas.add(buildCta("Browse Plugins", "/plugins", Variant.Neutral, Appearance.Outlined));
        hero.add(ctas);

        return hero;
    }

    private WaStack buildHighlights()
    {
        var content = new WaStack();
        content.setGap(PageSize.Medium);

        var grid = grid(3);

        grid.add(featureCard("Annotation-Driven",
                "Annotate your Java classes and the "
                + "build generates a complete Angular 21 project. No hand-written TypeScript.",
                null));

        grid.add(featureCard("Compile-Time Safe",
                "Every HTML element, CSS property, and event handler is a Java type. "
                + "Errors are caught by the compiler, not discovered in the browser.",
                null));

        grid.add(featureCard("Dual Mode",
                "Add the Angular plugin for a generated SPA, or run without it for "
                + "hosted mode on Vert.x 5 with GuicedEE services. Same component code either way.",
                null));

        grid.add(featureCard("Reactive & Non-Blocking",
                "Built on Vert.x 5 event-loop server and GuicedEE dependency injection. "
                + "JPMS modular, JLink-ready, production-grade.",
                null));

        grid.add(featureCard("Real-Time Ready",
                "REST, AJAX events, Vert.x event bus, and RabbitMQ — start with request/response, "
                + "layer in push updates when you need them.",
                null));

        grid.add(featureCard("IDE-Friendly",
                "Concrete Java classes with full autocomplete, refactoring, find-usages, "
                + "and go-to-definition in IntelliJ, Eclipse, or VS Code.",
                null));

        content.add(grid);

        var section = buildSection("WHY JWEBMP",
                "Everything You Need, Nothing You Don't",
                "A complete web framework that respects Java developers.",
                true, content);
        section.setID("why-jwebmp");
        return section;
    }

    private WaStack buildComponentEcosystem()
    {
        var content = new WaStack();
        content.setGap(PageSize.Medium);

        content.add(bodyText(
                "Every plugin is a JPMS module. Add the Maven dependency, and the component is available as a "
                + "type-safe Java class. Some plugins work in both modes; others — like AG Grid and AG Charts "
                + "— require the Angular plugin.",
                "m"));

        var grid = grid(3);

        grid.add(featureCard("AG Grid & AG Charts",
                "Enterprise data grids and 38+ chart types — configured in Java, rendered in Angular.",
                "com.jwebmp.plugins:aggrid / agcharts"));

        grid.add(featureCard("WebAwesome",
                "Modern, accessible UI component library with dark mode, responsive layout, and 18+ components.",
                "com.jwebmp.plugins:web-awesome"));

        grid.add(featureCard("FullCalendar",
                "Drag-and-drop scheduling, resource timelines, and multiple calendar views.",
                "com.jwebmp.plugins:fullcalendar"));

        grid.add(featureCard("RabbitMQ Comms",
                "Bidirectional messaging with broker-backed durability. STOMP/WebSocket bridge for Angular.",
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

        var section = buildSection("20+ PLUGINS",
                "Production-Ready Component Library",
                "Grids, charts, calendars, icons, messaging — all type-safe, all Java, all JPMS.",
                true, content);
        section.setID("component-ecosystem");
        return section;
    }

}
