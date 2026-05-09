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
        var layout = new WaStack<>();
        layout.setGap(PageSize.ExtraLarge);
        var content = new WaStack<>();
        content.setGap(PageSize.Medium);

        content.add(richText(
                "At build time, the Angular Maven Plugin scans your classpath for `@NgApp`-annotated classes. "
                        + "It invokes the TypeScript Compiler which walks every `@NgComponent`, `@NgDirective`, "
                        + "`@NgDataService`, and `@NgRoutable` class. For each, it generates a `.ts` file, registers "
                        + "it in the Angular module, and adds its route to the router config. The result is a complete "
                        + "Angular 21 project that the Angular CLI builds into a production `dist/` directory.",
                "m"));

        content.add(mermaidDiagramWithTitle("Build Flow",
                """
                        graph LR
                          MVN["mvn install"] --> COMPILE["javac"]
                          COMPILE --> PLUGIN["Angular Maven Plugin"]

                          subgraph CODEGEN["Code Generation"]
                            direction TB
                            DISCOVER["Discover @NgApp"]
                            TSCOMPILE["Generate .ts files"]
                            MODPROC["Build module tree"]
                            COMPPROC["Emit components"]
                            DISCOVER --> TSCOMPILE --> MODPROC --> COMPPROC
                          end

                          subgraph SCAFFOLD["Project Scaffold"]
                            direction TB
                            DEPMGR["Write package.json"]
                            APPSETUP["Write angular.json"]
                          end

                          PLUGIN --> CODEGEN
                          PLUGIN --> SCAFFOLD
                          CODEGEN --> NGBUILD["ng build --prod"]
                          SCAFFOLD --> NGBUILD
                          NGBUILD --> PACKAGE["dist/ → JAR"]

                          style CODEGEN fill:#1e3a5f,stroke:#60a5fa,stroke-width:2px,color:#e2e8f0
                          style SCAFFOLD fill:#1a3330,stroke:#34d399,stroke-width:2px,color:#e2e8f0
                          style PACKAGE fill:#312e81,stroke:#818cf8,stroke-width:2px,color:#e2e8f0
                        """));

        layout.add(buildSection("BUILD",
                "Build-Time Code Generation",
                "Java compiles → TypeScript generates → Angular builds → JAR packages.",
                false, content));
        getMain().add(layout);
    }
}
