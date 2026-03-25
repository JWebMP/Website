package com.jwebmp.website.pages.architecture;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-arch-build")
@NgRoutable(path = "architecture/build-pipeline")
public class BuildPipelinePage extends WebsitePage<BuildPipelinePage> implements INgComponent<BuildPipelinePage> {
    public BuildPipelinePage() {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        var content = new WaStack();
        content.setGap(PageSize.Medium);

        content.add(bodyText(
                "At build time, the Angular Maven Plugin scans your classpath for @NgApp-annotated classes. "
                        + "It invokes the TypeScript Compiler which walks every @NgComponent, @NgDirective, "
                        + "@NgDataService, and @NgRoutable class. For each, it generates a .ts file, registers "
                        + "it in the Angular module, and adds its route to the router config. The result is a complete "
                        + "Angular 20 project that the Angular CLI builds into a production dist/ directory.",
                "m"));

        content.add(codeBlockWithTitle("Build Flow",
                """
                        mvn install
                          │
                          ├─ compile: javac compiles your Java sources
                          │
                          ├─ process-classes: Angular Maven Plugin runs
                          │   ├─ Discovers @NgApp classes on classpath
                          │   ├─ TypeScriptCompiler generates .ts files
                          │   ├─ AngularModuleProcessor builds module tree
                          │   ├─ ComponentProcessor emits component .ts
                          │   ├─ DependencyManager writes package.json
                          │   ├─ AngularAppSetup generates angular.json
                          │   └─ npm install + ng build --configuration production
                          │
                          └─ package: dist/ bundled into the JAR"""));

        layout.add(buildSection("BUILD",
                "Build-Time Code Generation",
                "Java compiles → TypeScript generates → Angular builds → JAR packages.",
                false, content));
        getMain().add(layout);
    }
}

