package com.jwebmp.website.pages;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.WaStack;

@NgComponent("jwebmp-architecture")
@NgRoutable(path = "architecture")
public class ArchitecturePage extends WebsitePage<ArchitecturePage> implements INgComponent<ArchitecturePage>
{
    public ArchitecturePage()
    {

        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        getMain().add(layout);

        // Overview only — sub-sections are now individual pages
        var content = new WaStack();
        content.setGap(PageSize.Medium);
        content.add(bodyText(
                "JWebMP is a layered architecture where each layer has a single responsibility. "
                + "The foundation is GuicedEE (dependency injection, SPI discovery, Vert.x lifecycle). "
                + "JWebMP Core adds the HTML/CSS/JS component model. Plugins extend it with specific "
                + "component libraries. The Angular layer generates the frontend. At runtime, Vert.x "
                + "serves everything reactively. Explore each layer via the menu tree.",
                "m"));
        layout.add(buildSection("ARCHITECTURE",
                "How JWebMP Works",
                "A layered, modular architecture — each layer does one thing well.",
                false, content));
    }
}
