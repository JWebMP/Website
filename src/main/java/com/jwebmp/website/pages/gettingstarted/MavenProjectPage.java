package com.jwebmp.website.pages.gettingstarted;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.plugins.prism.PrismLanguage;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-gs-maven")
@NgRoutable(path = "getting-started/maven-project")
public class MavenProjectPage extends WebsitePage<MavenProjectPage> implements INgComponent<MavenProjectPage> {
    public MavenProjectPage() {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        var content = new WaStack();
        content.setGap(PageSize.Medium);

        content.add(bodyText(
                "Create a new Maven project. Import the JWebMP BOM and add the dependencies you need. "
                        + "The BOM manages all version numbers.",
                "m"));

        content.add(codeBlockWithTitle("pom.xml",
                """
                        <properties>
                            <jwebmp.version>2.0.0-SNAPSHOT</jwebmp.version>
                            <guicedee.version>2.0.0-SNAPSHOT</guicedee.version>
                        </properties>
                        
                        <dependencyManagement>
                            <dependencies>
                                <dependency>
                                    <groupId>com.jwebmp</groupId>
                                    <artifactId>jwebmp-bom</artifactId>
                                    <version>${jwebmp.version}</version>
                                    <type>pom</type>
                                    <scope>import</scope>
                                </dependency>
                                <dependency>
                                    <groupId>com.guicedee</groupId>
                                    <artifactId>guicedee-bom</artifactId>
                                    <version>${guicedee.version}</version>
                                    <type>pom</type>
                                    <scope>import</scope>
                                </dependency>
                            </dependencies>
                        </dependencyManagement>
                        
                        <dependencies>
                            <dependency>
                                <groupId>com.guicedee</groupId>
                                <artifactId>client</artifactId>
                            </dependency>
                            <dependency>
                                <groupId>com.jwebmp.plugins</groupId>
                                <artifactId>angular</artifactId>
                            </dependency>
                            <dependency>
                                <groupId>com.jwebmp.plugins</groupId>
                                <artifactId>web-awesome</artifactId>
                            </dependency>
                        </dependencies>""", PrismLanguage.Xml));

        layout.add(buildSection("STEP 1",
                "Create the Maven Project",
                "Import the BOM. Add your dependencies.",
                false, content));
        getMain().add(layout);
    }
}

