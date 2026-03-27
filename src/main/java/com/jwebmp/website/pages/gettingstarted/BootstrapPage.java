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
                 "How you bootstrap depends on your mode. Angular mode only needs the Angular "
                        + "generation flag — there is no server to start. SSR mode starts the GuicedEE "
                        + "runtime with a Vert.x HTTP server.",
                "m"));

        content.add(codeBlockWithTitle("Boot.java — Angular mode (no server required)",
                """
                        public final class Boot {
                            public static void main(String[] args) {
                                // Generate the Angular project during build
                                System.setProperty("jwebmp.process.angular.ts", "true");
                                IGuiceContext.instance().inject();
                            }
                        }"""));

        content.add(codeBlockWithTitle("Boot.java — SSR mode (Vert.x server)",
                """
                        public final class Boot {
                            public static void main(String[] args) {
                                System.setProperty("HTTP_ENABLED", "true");
                                System.setProperty("HTTP_PORT", "8080");
                                IGuiceContext.instance().inject();
                            }
                        }"""));

        layout.add(buildSection("STEP 3",
                "Bootstrap",
                "Start the runtime with a single method call.",
                false, content));
        getMain().add(layout);
    }
}

