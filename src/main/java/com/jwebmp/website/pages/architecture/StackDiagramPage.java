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

        content.add(mermaidDiagramWithTitle("The JWebMP Stack",
                """
                        block-beta
                          columns 1
                          block:app["YOUR APPLICATION"]
                            columns 3
                            a1["@NgComponent"] a2["@NgRoutable"] a3["@NgDataService"]
                          end
                          space
                          block:plugins["PLUGINS & COMPONENTS"]
                            columns 3
                            p1["WebAwesome"] p2["AG Grid"] p3["Charts"]
                            p4["RabbitMQ"] p5["Font Awesome"] p6["Calendar"]
                          end
                          space
                          block:core["JWEBMP CORE"]
                            columns 3
                            c1["HTML Elements"] c2["CSS Builder"] c3["Events"]
                            c4["AJAX Pipeline"] c5["Angular Generator"] c6["TS Compiler"]
                          end
                          space
                          block:foundation["GUICEDEE FOUNDATION"]
                            columns 3
                            f1["Google Guice DI"] f2["SPI Discovery"] f3["JPMS"]
                            f4["Vert.x 5 HTTP"] f5["Event Bus"] f6["Call Scopes"]
                          end
                          app --> plugins --> core --> foundation
                        """));

        layout.add(buildSection("STACK",
                "Four-Layer Architecture",
                "Your app → Plugins → JWebMP Core → GuicedEE Foundation.",
                true, content));
        getMain().add(layout);
    }
}

