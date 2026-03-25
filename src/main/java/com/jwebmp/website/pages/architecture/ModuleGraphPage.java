package com.jwebmp.website.pages.architecture;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.Variant;
import com.jwebmp.webawesome.components.WaCluster;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.webawesome.components.button.Appearance;
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-arch-modules")
@NgRoutable(path = "architecture/module-graph")
public class ModuleGraphPage extends WebsitePage<ModuleGraphPage> implements INgComponent<ModuleGraphPage> {
    public ModuleGraphPage() {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        var content = new WaStack();
        content.setGap(PageSize.Medium);

        content.add(richText(
                "Every JWebMP module declares its dependencies explicitly in `module-info.java`. "
                        + "The JPMS module graph ensures clean boundaries — no classpath hell, no hidden "
                        + "dependencies, no runtime surprises.",
                "m"));

        content.add(mermaidDiagramWithTitle("Core Module Dependencies",
                """
                        graph TD
                          CORE["com.jwebmp.core"]
                          CLIENT["com.jwebmp.client<br/>SPI contracts, AJAX pipeline"]
                          GUICEE["com.guicedee.client<br/>DI, lifecycle, CallScope"]
                          VERTX["com.guicedee.vertx<br/>Vert.x lifecycle, event bus"]
                          VXC["io.vertx.core"]
                          VXW["io.vertx.web"]
                          GUICE["com.google.guice<br/>Dependency injection"]
                          JACKSON["com.fasterxml.jackson<br/>JSON serialization"]
                          JAKARTA["jakarta.validation<br/>Bean Validation"]
                          COMMONS["org.apache.commons.*<br/>Utilities"]

                          CORE --> CLIENT
                          CORE --> GUICEE
                          CORE --> VERTX
                          CORE --> VXC
                          CORE --> VXW
                          CORE --> GUICE
                          CORE --> JACKSON
                          CORE --> JAKARTA
                          CORE --> COMMONS
                        """));

        var ctas = new WaCluster<>();
        ctas.setGap(PageSize.Small);
        ctas.add(buildCta("Browse All Plugins", "/plugins", Variant.Brand, null));
        ctas.add(buildCta("View Capabilities", "/capabilities", Variant.Neutral, Appearance.Outlined));
        content.add(ctas);

        layout.add(buildSection("MODULES", "JPMS Module Graph",
                "Explicit requires, explicit exports — no surprises.", true, content));
        getMain().add(layout);
    }
}

