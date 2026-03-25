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
                """
                          YOUR APPLICATION
                          ┌─────────────────────────────────────────────┐
                          │  @NgComponent  @NgRoutable  @NgDataService  │  ← Your Java classes
                          └──────────────────────┬──────────────────────┘
                                                 │
                          PLUGINS & COMPONENTS
                          ┌─────────────────────────────────────────────┐
                          │  WebAwesome │ AG Grid │ Charts │ Calendar   │  ← JPMS plugin modules
                          │  RabbitMQ   │ Font Awesome │ Easing         │
                          └──────────────────────┬──────────────────────┘
                                                 │
                          JWEBMP CORE
                          ┌─────────────────────────────────────────────┐
                          │  HTML Elements │ CSS Builder │ Events       │  ← Component model
                          │  AJAX Pipeline │ Page Configurators         │
                          │  Angular Generator │ TypeScript Compiler    │  ← Build-time codegen
                          └──────────────────────┬──────────────────────┘
                                                 │
                          GUICEDEE FOUNDATION
                          ┌─────────────────────────────────────────────┐
                          │  Google Guice DI │ SPI Discovery │ JPMS     │  ← Runtime foundation
                          │  Vert.x 5 HTTP  │ Event Bus │ Call Scopes  │
                          │  Jackson JSON    │ Jakarta Validation       │
                          └─────────────────────────────────────────────┘\
                        """));

        layout.add(buildSection("STACK",
                "Four-Layer Architecture",
                "Your app → Plugins → JWebMP Core → GuicedEE Foundation.",
                true, content));
        getMain().add(layout);
    }
}

