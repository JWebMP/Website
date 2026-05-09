package com.jwebmp.website.pages.frameworks.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.frameworks.FrameworkComponentPage;
import com.jwebmp.website.pages.frameworks.BootstrapFrameworkPage;
@NgComponent("jwebmp-comp-bsbadge")
@NgRoutable(path = "frameworks/bootstrap/bsbadge")
public class BSBadgePage extends FrameworkComponentPage<BSBadgePage>
{
    public BSBadgePage()
    {
        super("bootstrap", "Bootstrap", BootstrapFrameworkPage.COMPONENTS.get(2));
    }
}
