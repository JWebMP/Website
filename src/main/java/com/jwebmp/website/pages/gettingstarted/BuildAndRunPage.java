package com.jwebmp.website.pages.gettingstarted;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-gs-build-run")
@NgRoutable(path = "getting-started/build-and-run")
public class BuildAndRunPage extends WebsitePage<BuildAndRunPage> implements INgComponent<BuildAndRunPage> {
    public BuildAndRunPage() {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        var content = new WaStack();
        content.setGap(PageSize.Medium);

        content.add(bodyText(
                "Build with Maven. What happens next depends on your mode.",
                "m"));

        content.add(codeBlockWithTitle("Terminal — both modes",
                """
                        mvn clean install"""));

        content.add(bodyText(
                "In Angular mode, the Angular Maven Plugin generates TypeScript, runs npm install and "
                        + "ng build automatically. The output is a static SPA in the build target — deploy it "
                        + "to any web server, CDN, or serve it locally. No JWebMP server required.",
                "m"));

        content.add(codeBlockWithTitle("Angular mode — serve the static SPA (optional)",
                """
                        # The built SPA is in target/webroot/
                        # Serve it however you like — nginx, Apache, CDN, or:
                        npx serve target/webroot/my-app"""));

        content.add(bodyText(
                "In SSR mode, components are rendered on the server. Start the Vert.x HTTP server "
                        + "and open your browser.",
                "m"));

        content.add(codeBlockWithTitle("SSR mode — start the server",
                """
                        java -jar target/my-app.jar
                        
                        # Open http://localhost:8080"""));

        layout.add(buildSection("STEP 6",
                "Build and Run",
                "mvn install → java -jar → open browser.",
                true, content));
        getMain().add(layout);
    }
}

