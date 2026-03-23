package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-ts-client")
@NgRoutable(path = "plugins/typescript-client")
public class TypeScriptClientPluginPage extends PluginDetailPage<TypeScriptClientPluginPage> {
    public TypeScriptClientPluginPage() {
        super(PluginCatalog.getById("typescript-client").orElseThrow());
    }

    @Override
    protected List<PluginEntry.ExampleSnippet> pluginExamples() {
        return List.of(
                new PluginEntry.ExampleSnippet("Component with Fields and Lifecycle",
                        "Define an Angular component with typed fields and lifecycle hooks.",
                        """
                                @NgComponent("my-widget")
                                public class MyWidget extends DivSimple<MyWidget>
                                        implements INgComponent<MyWidget> {
                                
                                    @NgField("title = 'Hello World'")
                                    String title;
                                
                                    @NgOnInit
                                    public void onInit() {
                                        add(new Paragraph<>().setText("{{ title }}"));
                                    }
                                }""",
                        "java"),
                new PluginEntry.ExampleSnippet("Routing with Route Data",
                        "Define a routable page with route metadata.",
                        "@NgComponent(\"settings-page\")\n@NgRoutable(path = \"settings\", parent = {AppComponent.class})\n@NgRouteData(key = \"title\", value = \"'Settings'\")\npublic class SettingsPage extends DivSimple<SettingsPage>\n        implements INgComponent<SettingsPage> { }",
                        "java")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails() {
        return List.of(
                new PluginEntry.SpiDetail("IGuiceModule", "provides", "Registers TypeScript client Guice bindings for annotation processing"),
                new PluginEntry.SpiDetail("OnGetAllFields", "uses", "Extension point for custom field generation in TypeScript output"),
                new PluginEntry.SpiDetail("OnGetAllMethods", "uses", "Extension point for custom method generation in TypeScript output"),
                new PluginEntry.SpiDetail("OnGetAllImports", "uses", "Extension point for custom import generation in TypeScript output"),
                new PluginEntry.SpiDetail("OnGetAllConstructorParameters", "uses", "Extension point for constructor parameter injection in TypeScript output")
        );
    }
}
