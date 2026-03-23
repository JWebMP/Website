package com.jwebmp.website.pages.home;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-developer-experience")
@NgRoutable(path = "home/developer-experience")
public class DeveloperExperiencePage extends WebsitePage<DeveloperExperiencePage> implements INgComponent<DeveloperExperiencePage> {
    public DeveloperExperiencePage() {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);

        var content = new WaStack();
        content.setGap(PageSize.Medium);

        var grid = grid(2);

        grid.add(featureCard("CRTP Fluent API",
                "Every component uses Curiously Recurring Template Pattern generics for fluent, "
                        + "chainable builders: card.setAppearance(Outlined).add(heading).add(body).",
                null));

        grid.add(featureCard("SPI Extensibility",
                "IPageConfigurator, IEventConfigurator, render-ordering hooks — extend the framework "
                        + "by implementing an interface and registering via ServiceLoader or module-info.java.",
                null));

        grid.add(featureCard("Maven Build Integration",
                "The Angular Maven Plugin discovers @NgApp classes, generates TypeScript, installs npm "
                        + "dependencies, and runs the Angular CLI build — all inside mvn install.",
                null));

        grid.add(featureCard("IDE-Friendly",
                "Every component is a concrete Java class. Full autocomplete, refactoring, "
                        + "find-usages, and go-to-definition in IntelliJ, Eclipse, or VS Code.",
                null));

        content.add(grid);

        layout.add(buildSection("DEVELOPER EXPERIENCE",
                "Built for Java Engineers",
                "Fluent APIs, compile-time checks, Maven integration, and full IDE support.",
                false, content));

        getMain().add(layout);
    }
}

