package com.jwebmp.website.pages.frameworks.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.frameworks.FrameworkComponentPage;
import com.jwebmp.website.pages.frameworks.AngularMaterialFrameworkPage;
@NgComponent("jwebmp-comp-mataccordion")
@NgRoutable(path = "frameworks/angular-material/mat-accordion")
public class MatAccordionPage extends FrameworkComponentPage<MatAccordionPage>
{
    public MatAccordionPage()
    {
        super("angular-material", "Angular Material", AngularMaterialFrameworkPage.COMPONENTS.get(0));
    }
}

