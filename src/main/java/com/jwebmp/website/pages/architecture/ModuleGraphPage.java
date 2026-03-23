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

        content.add(bodyText(
                "Every JWebMP module declares its dependencies explicitly in module-info.java. "
                        + "The JPMS module graph ensures clean boundaries — no classpath hell, no hidden "
                        + "dependencies, no runtime surprises.",
                "m"));

        content.add(codeBlockWithTitle("Core Module Dependencies",
                "com.jwebmp.core\n"
                        + " ├── com.jwebmp.client          (SPI contracts, AJAX pipeline)\n"
                        + " ├── com.guicedee.client         (DI, lifecycle, CallScope)\n"
                        + " ├── com.guicedee.vertx          (Vert.x lifecycle, event bus)\n"
                        + " ├── io.vertx.core               (Vert.x core)\n"
                        + " ├── io.vertx.web                (Vert.x Web router)\n"
                        + " ├── com.google.guice            (Dependency injection)\n"
                        + " ├── com.fasterxml.jackson        (JSON serialization)\n"
                        + " ├── jakarta.validation           (Bean Validation)\n"
                        + " └── org.apache.commons.*         (Utilities)"));

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

