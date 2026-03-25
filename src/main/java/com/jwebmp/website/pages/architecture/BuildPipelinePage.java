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

        content.add(richText(
                "At build time, the Angular Maven Plugin scans your classpath for `@NgApp`-annotated classes. "
                        + "It invokes the TypeScript Compiler which walks every `@NgComponent`, `@NgDirective`, "
                        + "`@NgDataService`, and `@NgRoutable` class. For each, it generates a `.ts` file, registers "
                        + "it in the Angular module, and adds its route to the router config. The result is a complete "
                        + "Angular 20 project that the Angular CLI builds into a production `dist/` directory.",
                "m"));

        content.add(mermaidDiagramWithTitle("Build Flow",
                """
                        graph TD
                          MVN["mvn install"]
                          COMPILE["compile: javac compiles Java sources"]
                          PROCESS["process-classes: Angular Maven Plugin"]
                          DISCOVER["Discovers @NgApp classes on classpath"]
                          TSCOMPILE["TypeScriptCompiler generates .ts files"]
                          MODPROC["AngularModuleProcessor builds module tree"]
                          COMPPROC["ComponentProcessor emits component .ts"]
                          DEPMGR["DependencyManager writes package.json"]
                          APPSETUP["AngularAppSetup generates angular.json"]
                          NGBUILD["npm install + ng build --configuration production"]
                          PACKAGE["package: dist/ bundled into the JAR"]

                          MVN --> COMPILE --> PROCESS
                          PROCESS --> DISCOVER
                          PROCESS --> TSCOMPILE
                          PROCESS --> MODPROC
                          PROCESS --> COMPPROC
                          PROCESS --> DEPMGR
                          PROCESS --> APPSETUP
                          DEPMGR --> NGBUILD
                          APPSETUP --> NGBUILD
                          NGBUILD --> PACKAGE
                        """));

        layout.add(buildSection("BUILD",
                "Build-Time Code Generation",
                "Java compiles → TypeScript generates → Angular builds → JAR packages.",
                false, content));
        getMain().add(layout);
    }
}

