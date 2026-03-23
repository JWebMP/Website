package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-angular-maven")
@NgRoutable(path = "plugins/angular-maven-plugin")
public class AngularMavenPluginPage extends PluginDetailPage<AngularMavenPluginPage>
{
    public AngularMavenPluginPage()
    {
        super(PluginCatalog.getById("angular-maven-plugin").orElseThrow());
    }

    @Override
    protected List<PluginEntry.ExampleSnippet> pluginExamples()
    {
        return List.of(
                new PluginEntry.ExampleSnippet(
                        "Full Build with Docker Image",
                        "Generate TypeScript, install dependencies, build Angular, and produce a Docker image in one Maven run.",
                        "<plugin>\n"
                        + "  <groupId>com.jwebmp.plugins</groupId>\n"
                        + "  <artifactId>angular-maven-plugin</artifactId>\n"
                        + "  <configuration>\n"
                        + "    <ensureToolchain>true</ensureToolchain>\n"
                        + "    <installDependencies>true</installDependencies>\n"
                        + "    <buildAngular>true</buildAngular>\n"
                        + "    <buildDockerImage>true</buildDockerImage>\n"
                        + "    <dockerImageName>my-app:latest</dockerImageName>\n"
                        + "  </configuration>\n"
                        + "</plugin>",
                        "xml"),
                new PluginEntry.ExampleSnippet(
                        "HTTPS with Custom Nginx Configuration",
                        "Enable HTTPS in the generated nginx.conf with TLS certificates and custom directives.",
                        "<plugin>\n"
                        + "  <groupId>com.jwebmp.plugins</groupId>\n"
                        + "  <artifactId>angular-maven-plugin</artifactId>\n"
                        + "  <configuration>\n"
                        + "    <buildAngular>true</buildAngular>\n"
                        + "    <buildDockerImage>true</buildDockerImage>\n"
                        + "    <nginxHttps>true</nginxHttps>\n"
                        + "    <nginxServerName>example.com</nginxServerName>\n"
                        + "    <nginxSslCertificate>/etc/nginx/ssl/cert.pem</nginxSslCertificate>\n"
                        + "    <nginxSslCertificateKey>/etc/nginx/ssl/key.pem</nginxSslCertificateKey>\n"
                        + "    <nginxCustomEntries>\n"
                        + "      <entry>client_max_body_size 50m;</entry>\n"
                        + "    </nginxCustomEntries>\n"
                        + "  </configuration>\n"
                        + "</plugin>",
                        "xml"),
                new PluginEntry.ExampleSnippet(
                        "Explicit App Selection",
                        "Build only specific @NgApp classes instead of auto-discovering all.",
                        "<plugin>\n"
                        + "  <groupId>com.jwebmp.plugins</groupId>\n"
                        + "  <artifactId>angular-maven-plugin</artifactId>\n"
                        + "  <configuration>\n"
                        + "    <appClasses>\n"
                        + "      <appClass>com.myapp.MyAngularApp</appClass>\n"
                        + "    </appClasses>\n"
                        + "    <classpathScope>compile</classpathScope>\n"
                        + "  </configuration>\n"
                        + "</plugin>",
                        "xml")
        );
    }

    @Override
    protected List<PluginEntry.ConfigEntry> pluginConfigurations()
    {
        return List.of(
                // Core
                new PluginEntry.ConfigEntry("skip", "boolean", "false", "Skip the entire plugin execution (-Djwebmp.angular.skip)"),
                new PluginEntry.ConfigEntry("classpathScope", "String", "runtime", "Maven classpath scope — runtime, compile, test, packaged/package/artifact"),
                new PluginEntry.ConfigEntry("outputDirectory", "String", "${project.build.directory}", "Base output directory for generated TypeScript sources"),
                new PluginEntry.ConfigEntry("appClasses", "List<String>", "(auto-discover)", "Explicit list of @NgApp fully-qualified class names to build"),
                // Toolchain
                new PluginEntry.ConfigEntry("installDependencies", "boolean", "false", "Run npm install during build (-Djwebmp.angular.install)"),
                new PluginEntry.ConfigEntry("installForce", "boolean", "false", "Run npm install --force (-Djwebmp.angular.install.force)"),
                new PluginEntry.ConfigEntry("ensureToolchain", "boolean", "false", "Provision Node.js/npm if not found (-Djwebmp.angular.ensureToolchain)"),
                new PluginEntry.ConfigEntry("downloadNpm", "boolean", "false", "Download npm separately during toolchain provisioning (-Djwebmp.angular.downloadNpm)"),
                new PluginEntry.ConfigEntry("nodeVersion", "String", "20.18.1", "Node.js version to provision (-Djwebmp.angular.nodeVersion)"),
                new PluginEntry.ConfigEntry("angularCliVersion", "String", "(latest)", "Angular CLI version to provision (-Djwebmp.angular.angularCliVersion)"),
                new PluginEntry.ConfigEntry("buildAngular", "boolean", "false", "Run ng build after code generation (-Djwebmp.angular.build)"),
                // Docker
                new PluginEntry.ConfigEntry("buildDockerImage", "boolean", "false", "Build an OCI/Docker image containing the Angular build served by nginx (-Djwebmp.angular.docker)"),
                new PluginEntry.ConfigEntry("dockerImageName", "String", "${artifactId}:${version}", "Docker image name (repository:tag)"),
                new PluginEntry.ConfigEntry("dockerBaseImage", "String", "nginx:alpine", "Base image for the generated Dockerfile"),
                new PluginEntry.ConfigEntry("dockerfilePath", "String", "(generated)", "Path to an existing Dockerfile — skips generation when set"),
                new PluginEntry.ConfigEntry("dockerBuildArgs", "List<String>", "(none)", "Additional arguments passed to docker build (e.g. --no-cache, --build-arg)"),
                // Nginx
                new PluginEntry.ConfigEntry("nginxHttps", "boolean", "false", "Enable HTTPS server block (port 443) with TLS in generated nginx.conf"),
                new PluginEntry.ConfigEntry("nginxSslCertificate", "String", "/etc/nginx/ssl/server.crt", "Path to SSL certificate inside the container"),
                new PluginEntry.ConfigEntry("nginxSslCertificateKey", "String", "/etc/nginx/ssl/server.key", "Path to SSL private key inside the container"),
                new PluginEntry.ConfigEntry("nginxHttpRedirect", "boolean", "true", "301 redirect HTTP to HTTPS when nginxHttps is enabled"),
                new PluginEntry.ConfigEntry("nginxServerName", "String", "localhost", "The server_name directive in generated nginx.conf"),
                new PluginEntry.ConfigEntry("nginxCustomEntries", "List<String>", "(none)", "Raw nginx directives injected into the server block"),
                new PluginEntry.ConfigEntry("nginxConfigFile", "String", "(generated)", "Path to an existing nginx.conf — skips generation when set")
        );
    }
}
