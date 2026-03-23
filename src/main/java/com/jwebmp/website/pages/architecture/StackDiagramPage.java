package com.jwebmp.website.pages.architecture;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-arch-stack")
@NgRoutable(path = "architecture/stack")
public class StackDiagramPage extends WebsitePage<StackDiagramPage> implements INgComponent<StackDiagramPage> {
    public StackDiagramPage() {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        var content = new WaStack();
        content.setGap(PageSize.Medium);

        content.add(bodyText(
                "The JWebMP stack is four layers deep. Your application sits at the top; everything "
                        + "below is framework infrastructure.",
                "m"));

        content.add(codeBlockWithTitle("The JWebMP Stack",
                "  YOUR APPLICATION\n"
                        + "  ┌─────────────────────────────────────────────┐\n"
                        + "  │  @NgComponent  @NgRoutable  @NgDataService  │  ← Your Java classes\n"
                        + "  └──────────────────────┬──────────────────────┘\n"
                        + "                         │\n"
                        + "  PLUGINS & COMPONENTS\n"
                        + "  ┌─────────────────────────────────────────────┐\n"
                        + "  │  WebAwesome │ AG Grid │ Charts │ Calendar   │  ← JPMS plugin modules\n"
                        + "  │  RabbitMQ   │ Font Awesome │ Easing         │\n"
                        + "  └──────────────────────┬──────────────────────┘\n"
                        + "                         │\n"
                        + "  JWEBMP CORE\n"
                        + "  ┌─────────────────────────────────────────────┐\n"
                        + "  │  HTML Elements │ CSS Builder │ Events       │  ← Component model\n"
                        + "  │  AJAX Pipeline │ Page Configurators         │\n"
                        + "  │  Angular Generator │ TypeScript Compiler    │  ← Build-time codegen\n"
                        + "  └──────────────────────┬──────────────────────┘\n"
                        + "                         │\n"
                        + "  GUICEDEE FOUNDATION\n"
                        + "  ┌─────────────────────────────────────────────┐\n"
                        + "  │  Google Guice DI │ SPI Discovery │ JPMS     │  ← Runtime foundation\n"
                        + "  │  Vert.x 5 HTTP  │ Event Bus │ Call Scopes  │\n"
                        + "  │  Jackson JSON    │ Jakarta Validation       │\n"
                        + "  └─────────────────────────────────────────────┘"));

        layout.add(buildSection("STACK",
                "Four-Layer Architecture",
                "Your app → Plugins → JWebMP Core → GuicedEE Foundation.",
                true, content));
        getMain().add(layout);
    }
}

