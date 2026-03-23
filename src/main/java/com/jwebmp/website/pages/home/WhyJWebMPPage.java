package com.jwebmp.website.pages.home;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-why")
@NgRoutable(path = "home/why-jwebmp")
public class WhyJWebMPPage extends WebsitePage<WhyJWebMPPage> implements INgComponent<WhyJWebMPPage> {
    public WhyJWebMPPage() {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);

        var content = new WaStack();
        content.setGap(PageSize.Medium);

        var grid = grid(3);

        grid.add(featureCard("Single Language, Full Stack",
                "Your backend services, your frontend components, your data models, and your routing — all "
                        + "written in Java. No JavaScript, no TypeScript, no HTML templates to maintain separately.",
                null));

        grid.add(featureCard("Compile-Time Safety",
                "Every HTML element, every CSS property, every event handler is a Java type. Typos and mismatches "
                        + "are caught by the compiler, not discovered in the browser at runtime.",
                null));

        grid.add(featureCard("Rapid Development",
                "Add a dependency, annotate a class, build. New components, pages, and routes materialise "
                        + "automatically. The Maven plugin generates the entire Angular project for you.",
                null));

        content.add(grid);

        layout.add(buildSection("WHY JWEBMP",
                "One Language to Build It All",
                "Java developers should not need to learn a second ecosystem to ship a web application.",
                true, content));

        getMain().add(layout);
    }
}

