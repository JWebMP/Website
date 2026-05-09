package com.jwebmp.website.pages.frameworks.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.frameworks.FrameworkComponentPage;
import com.jwebmp.website.pages.frameworks.AngularMaterialFrameworkPage;
@NgComponent("jwebmp-comp-matautocomplete")
@NgRoutable(path = "frameworks/angular-material/mat-auto-complete")
public class MatAutoCompletePage extends FrameworkComponentPage<MatAutoCompletePage>
{
    public MatAutoCompletePage()
    {
        super("angular-material", "Angular Material", AngularMaterialFrameworkPage.COMPONENTS.get(1));
    }
}

