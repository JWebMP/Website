package com.jwebmp.website.pages;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.WaStack;

@NgComponent("jwebmp-capabilities")
@NgRoutable(path = "capabilities")
public class CapabilitiesPage extends WebsitePage<CapabilitiesPage> implements INgComponent<CapabilitiesPage>
{
    public CapabilitiesPage()
    {

        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        getMain().add(layout);

        // Overview only — sub-sections are now individual pages
        var content = new WaStack();
        content.setGap(PageSize.Medium);
        content.add(bodyText(
                "JWebMP is a full-stack Java framework for building reactive web applications. "
                + "It produces both the backend (Vert.x HTTP server, Guice DI, AJAX pipeline) and "
                + "the frontend (Angular 20 SPA) from a single Java codebase. Explore each capability "
                + "in detail via the menu tree.",
                "m"));
        layout.add(buildSection("OVERVIEW",
                "What JWebMP Can Do",
                "A comprehensive look at every layer of the framework.",
                false, content));
    }
}
