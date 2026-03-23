package com.jwebmp.website.pages.gettingstarted;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-gs-bootstrap")
@NgRoutable(path = "getting-started/bootstrap")
public class BootstrapPage extends WebsitePage<BootstrapPage> implements INgComponent<BootstrapPage> {
    public BootstrapPage() {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        var content = new WaStack();
        content.setGap(PageSize.Medium);

        content.add(bodyText(
                "The Boot class is your application entry point. It configures the HTTP port, "
                        + "enables Angular TypeScript processing, and starts the GuicedEE runtime. "
                        + "One line — IGuiceContext.inject() — boots everything.",
                "m"));

        content.add(codeBlockWithTitle("Boot.java",
                "public final class Boot {\n"
                        + "    public static void main(String[] args) {\n"
                        + "        System.setProperty(\"HTTP_ENABLED\", \"true\");\n"
                        + "        System.setProperty(\"HTTP_PORT\", \"8080\");\n"
                        + "        System.setProperty(\"jwebmp.process.angular.ts\", \"true\");\n"
                        + "        IGuiceContext.instance().inject();\n"
                        + "    }\n"
                        + "}"));

        layout.add(buildSection("STEP 3",
                "Bootstrap",
                "Start the runtime with a single method call.",
                false, content));
        getMain().add(layout);
    }
}

