package com.jwebmp.website.pages.gettingstarted;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-gs-module")
@NgRoutable(path = "getting-started/module-descriptor")
public class ModuleDescriptorPage extends WebsitePage<ModuleDescriptorPage> implements INgComponent<ModuleDescriptorPage> {
    public ModuleDescriptorPage() {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        var content = new WaStack();
        content.setGap(PageSize.Medium);

        content.add(bodyText(
                "JWebMP is fully JPMS. Create a module-info.java that requires the modules you use "
                        + "and opens your packages to Guice for dependency injection.",
                "m"));

        content.add(codeBlockWithTitle("src/main/java/module-info.java",
                "module my.app {\n"
                        + "    requires com.jwebmp.core;\n"
                        + "    requires com.jwebmp.core.angular;\n"
                        + "    requires com.jwebmp.webawesome;\n"
                        + "    requires com.guicedee.client;\n"
                        + "\n"
                        + "    opens my.app to com.google.guice;\n"
                        + "}"));

        layout.add(buildSection("STEP 2",
                "Module Descriptor",
                "Declare your JPMS module.",
                true, content));
        getMain().add(layout);
    }
}

