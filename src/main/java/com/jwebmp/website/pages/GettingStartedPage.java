package com.jwebmp.website.pages;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.annotations.structures.NgField;
import com.jwebmp.core.base.angular.client.annotations.structures.NgMethod;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.Link;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.Variant;
import com.jwebmp.webawesome.components.WaCluster;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.webawesome.components.details.WaDetails;
import com.jwebmp.webawesome.components.tag.WaTag;

@NgComponent("jwebmp-getting-started")
@NgRoutable(path = "getting-started")
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
public class GettingStartedPage extends WebsitePage<GettingStartedPage> implements INgComponent<GettingStartedPage>
{
    public GettingStartedPage()
    {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        getMain().add(layout);

        var content = new WaStack();
        content.setGap(PageSize.Medium);

        content.add(bodyText(
                "This guide walks you through creating a JWebMP application from scratch. "
                + "JWebMP supports two running modes — choose the one that fits your project:",
                "m"));

        // ── Prerequisites (Maven) ──
        var mavenPrereqs = new DivSimple<>();
        mavenPrereqs.addAttribute("*ngIf", "!useGradle");

        var mavenPrereqLabel = captionText("Prerequisites");
        mavenPrereqs.add(mavenPrereqLabel);

        var mavenPills = new WaCluster<>();
        mavenPills.setGap(PageSize.Small);
        mavenPills.add(prereqPill("Java 25+", "https://adoptium.net", Variant.Brand));
        mavenPills.add(prereqPill("Maven 3.9+", "https://maven.apache.org", Variant.Neutral));
        mavenPills.add(prereqPill("Node.js 22+", "https://nodejs.org", Variant.Warning));
        mavenPrereqs.add(mavenPills);
        content.add(mavenPrereqs);

        // ── Prerequisites (Gradle) ──
        var gradlePrereqs = new DivSimple<>();
        gradlePrereqs.addAttribute("*ngIf", "useGradle");

        var gradlePrereqLabel = captionText("Prerequisites");
        gradlePrereqs.add(gradlePrereqLabel);

        var gradlePills = new WaCluster<>();
        gradlePills.setGap(PageSize.Small);
        gradlePills.add(prereqPill("Java 25+", "https://adoptium.net", Variant.Brand));
        gradlePills.add(prereqPill("Gradle 8.6+", "https://gradle.org", Variant.Neutral));
        gradlePills.add(prereqPill("Node.js 22+", "https://nodejs.org", Variant.Warning));
        gradlePrereqs.add(gradlePills);
        content.add(gradlePrereqs);

        // ── Entry Points ──
        var entryStack = new WaStack();
        entryStack.setGap(PageSize.Medium);

        var angularDetails = new WaDetails<>("Angular Mode (Client-Side/MicroFront SPA)");
        var angularContent = new WaStack();
        angularContent.add(bodyText(
                "Include the Angular plugin and the build plugin generates "
                + "a complete Angular 21 single-page application. "
                + "Node.js is required at build time for the Angular CLI. The resulting SPA is static "
                + "and can be served from any host or CDN — the JWebMP server is entirely optional.",
                "m"));
        angularContent.add(codeBlock(
                """
                        @NgApp(value = "my-app", bootComponent = MyHomePage.class)
                        public class MyApplication extends NGApplication<MyApplication> {
                            public MyApplication() {
                                getOptions().setTitle("My App");
                            }
                        }""", "java"));
        angularDetails.add(angularContent);
        entryStack.add(angularDetails);

        var ssrDetails = new WaDetails<>("Hosted Mode (JWebMP + GuicedEE Backend)");
        var ssrContent = new WaStack();
        ssrContent.add(bodyText(
                "JWebMP hosts the application on a Vert.x 5 endpoint alongside your GuicedEE backend. "
                + "REST APIs, WebSockets, authentication, and persistence all run on the same process. "
                + "Add the Angular plugin to serve a compiled SPA from the same endpoint, "
                + "or render pages server-side.",
                "m"));
        ssrContent.add(codeBlock(
                """
                        public class MyHomePage extends Page<MyHomePage> {
                            public MyHomePage() {
                                add("Hello World");
                            }

                            public static void main(String[] args) {
                                System.setProperty("HTTP_ENABLED", "true");
                                IGuiceContext.instance().inject();
                            }
                        }""", "java"));
        ssrDetails.add(ssrContent);
        entryStack.add(ssrDetails);

        content.add(entryStack);

        layout.add(buildSection("QUICK START",
                "Getting Started with JWebMP",
                "Choose your mode. Follow the steps. Ship your app.",
                false, content));

        // ── Bootstrap: Build Plugin (Angular) / Boot.java (Hosted) ──
        var bootstrapContent = new WaStack();
        bootstrapContent.setGap(PageSize.Medium);

        bootstrapContent.add(bodyText(
                "Angular mode uses a build plugin that generates the entire Angular project during your build. "
                + "Hosted mode starts the GuicedEE runtime with a Vert.x HTTP server.",
                "m"));

        // Maven plugin
        var mavenPlugin = codeBlockWithTitle("Angular mode — Maven plugin (pom.xml)",
                """
                        <plugin>
                            <groupId>com.jwebmp.plugins</groupId>
                            <artifactId>angular-maven-plugin</artifactId>
                            <version>${jwebmp.version}</version>
                            <executions>
                                <execution>
                                    <id>build-angular</id>
                                    <phase>install</phase>
                                    <goals>
                                        <goal>build</goal>
                                    </goals>
                                </execution>
                            </executions>
                        </plugin>""", "java");
        mavenPlugin.addAttribute("*ngIf", "!useGradle");
        bootstrapContent.add(mavenPlugin);

        // Gradle plugin
        var gradlePlugin = codeBlockWithTitle("Angular mode — Gradle plugin (build.gradle.kts)",
                """
                        plugins {
                            id("com.jwebmp.angular") version jwebmpVersion
                        }
                        
                        jwebmpAngular {
                            // runs during the build task
                        }""","groovy");
        gradlePlugin.addAttribute("*ngIf", "useGradle");
        bootstrapContent.add(gradlePlugin);

        var pluginNote = captionText(
                "The plugin discovers your annotated classes, generates TypeScript, "
                + "installs npm dependencies, and runs the Angular CLI — all in one build step.");
        pluginNote.setWaColorText("quiet");
        bootstrapContent.add(pluginNote);

        // Hosted mode Boot.java
        bootstrapContent.add(codeBlockWithTitle("Hosted mode — Boot.java (Vert.x server)",
                """
                        public final class Boot {
                            public static void main(String[] args) {
                                System.setProperty("HTTP_ENABLED", "true");
                                System.setProperty("HTTP_PORT", "8080");
                                IGuiceContext.instance().inject();
                            }
                        }""","java"));

        layout.add(buildSection("BOOTSTRAP",
                "Configure the Build Plugin",
                "Let the build plugin handle everything — or start the server manually.",
                false, bootstrapContent));

        // ── Closing note ──
        var closingNote = bodyText(
                "The module descriptor and your first component are identical for both modes. "
                + "Use the menu tree to navigate each remaining step.",
                "m");

        var closingSection = new WaStack();
        closingSection.setGap(PageSize.Medium);
        closingSection.add(closingNote);
        layout.add(closingSection);
    }

    private Link<?> prereqPill(String label, String url, Variant variant)
    {
        var link = new Link<>();
        link.setTag("a");
        link.addAttribute("href", url);
        link.addAttribute("target", "_blank");
        link.addAttribute("rel", "noopener noreferrer");
        link.addStyle("text-decoration:none");

        var tag = new WaTag<>();
        tag.setText(escapeAngular(label));
        tag.setVariant(variant);
        tag.setPill(true);
        link.add(tag);

        return link;
    }
}
