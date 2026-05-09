package com.jwebmp.website.pages.frameworks.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.frameworks.FrameworkComponentPage;
import com.jwebmp.website.pages.frameworks.BootstrapFrameworkPage;
@NgComponent("jwebmp-comp-bsbreadcrumb-container")
@NgRoutable(path = "frameworks/bootstrap/bsbreadcrumb-container")
public class BSBreadcrumbContainerPage extends FrameworkComponentPage<BSBreadcrumbContainerPage>
{
    public BSBreadcrumbContainerPage()
    {
        super("bootstrap", "Bootstrap", BootstrapFrameworkPage.COMPONENTS.get(3));
    }
}
