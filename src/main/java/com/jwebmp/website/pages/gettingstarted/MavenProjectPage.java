package com.jwebmp.website.pages.gettingstarted;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
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
                "<properties>\n"
                        + "    <jwebmp.version>2.0.0-SNAPSHOT</jwebmp.version>\n"
                        + "    <guicedee.version>2.0.0-SNAPSHOT</guicedee.version>\n"
                        + "</properties>\n"
                        + "\n"
                        + "<dependencyManagement>\n"
                        + "    <dependencies>\n"
                        + "        <dependency>\n"
                        + "            <groupId>com.jwebmp</groupId>\n"
                        + "            <artifactId>jwebmp-bom</artifactId>\n"
                        + "            <version>${jwebmp.version}</version>\n"
                        + "            <type>pom</type>\n"
                        + "            <scope>import</scope>\n"
                        + "        </dependency>\n"
                        + "        <dependency>\n"
                        + "            <groupId>com.guicedee</groupId>\n"
                        + "            <artifactId>guicedee-bom</artifactId>\n"
                        + "            <version>${guicedee.version}</version>\n"
                        + "            <type>pom</type>\n"
                        + "            <scope>import</scope>\n"
                        + "        </dependency>\n"
                        + "    </dependencies>\n"
                        + "</dependencyManagement>\n"
                        + "\n"
                        + "<dependencies>\n"
                        + "    <dependency>\n"
                        + "        <groupId>com.guicedee</groupId>\n"
                        + "        <artifactId>client</artifactId>\n"
                        + "    </dependency>\n"
                        + "    <dependency>\n"
                        + "        <groupId>com.jwebmp.plugins</groupId>\n"
                        + "        <artifactId>angular</artifactId>\n"
                        + "    </dependency>\n"
                        + "    <dependency>\n"
                        + "        <groupId>com.jwebmp.plugins</groupId>\n"
                        + "        <artifactId>web-awesome</artifactId>\n"
                        + "    </dependency>\n"
                        + "</dependencies>"));

        layout.add(buildSection("STEP 1",
                "Create the Maven Project",
                "Import the BOM. Add your dependencies.",
                false, content));
        getMain().add(layout);
    }
}

