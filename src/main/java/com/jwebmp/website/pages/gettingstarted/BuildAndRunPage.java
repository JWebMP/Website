package com.jwebmp.website.pages.gettingstarted;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.annotations.structures.NgField;
import com.jwebmp.core.base.angular.client.annotations.structures.NgMethod;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.plugins.prism.PrismLanguage;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-gs-build-run")
@NgRoutable(path = "getting-started/build-and-run")
@NgField("useGradle = false;")
@NgField("private _storageListener: any;")
@NgField("private _customListener: any;")
@NgImportReference(value = "OnDestroy, OnInit", reference = "@angular/core")
@NgMethod("""
        ngOnInit() {
            const saved = localStorage.getItem('jwebmp-build-tool');
            if (saved) { this.useGradle = saved === 'gradle'; }
            this._storageListener = (e: StorageEvent) => {
                if (e.key === 'jwebmp-build-tool') {
                    this.useGradle = e.newValue === 'gradle';
                }
            };
            this._customListener = (e: any) => {
                this.useGradle = e.detail;
            };
            window.addEventListener('storage', this._storageListener);
            window.addEventListener('jwebmp-build-tool-change', this._customListener);
        }""")
@NgMethod("""
        ngOnDestroy() {
            window.removeEventListener('storage', this._storageListener);
            window.removeEventListener('jwebmp-build-tool-change', this._customListener);
        }""")
public class BuildAndRunPage extends WebsitePage<BuildAndRunPage> implements INgComponent<BuildAndRunPage>
{
    public BuildAndRunPage()
    {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        var content = new WaStack();
        content.setGap(PageSize.Medium);

        content.add(bodyText(
                "Build your project. What happens next depends on your mode.",
                "m"));

        // Maven build command
        var mvnBuild = codeBlockWithTitle("Terminal — Maven", "mvn clean install");
        mvnBuild.addAttribute("*ngIf", "!useGradle");
        content.add(mvnBuild);

        // Gradle build command
        var gradleBuild = codeBlockWithTitle("Terminal — Gradle", "./gradlew build", PrismLanguage.Bash);
        gradleBuild.addAttribute("*ngIf", "useGradle");
        content.add(gradleBuild);

        content.add(bodyText(
                "In Angular mode, the build plugin generates TypeScript, runs npm install and "
                + "ng build automatically. The output is a static SPA in the build target — deploy it "
                + "to any web server, CDN, or serve it locally. No JWebMP server required.",
                "m"));

        content.add(codeBlockWithTitle("Angular mode — serve the static SPA (optional)",
                """
                        # The built SPA is in target/webroot/
                        # Serve it however you like — nginx, Apache, CDN, or:
                        npx serve target/webroot/my-app""", PrismLanguage.Bash));

        content.add(bodyText(
                "In hosted mode, the Vert.x HTTP server serves the application. Start it "
                + "and open your browser.",
                "m"));

        content.add(codeBlockWithTitle("Hosted mode — start the server",
                """
                        java -jar target/my-app.jar
                        
                        # Open http://localhost:8080""", PrismLanguage.Bash));

        layout.add(buildSection("STEP 6",
                "Build and Run",
                "One command to build, one command to run.",
                true, content));
        getMain().add(layout);
    }
}

