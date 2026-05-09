package com.jwebmp.website.pages.frameworks.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.frameworks.FrameworkComponentPage;
import com.jwebmp.website.pages.frameworks.AngularMaterialFrameworkPage;
@NgComponent("jwebmp-comp-matchipautocomp")
@NgRoutable(path = "frameworks/angular-material/mat-chip-auto-complete")
public class MatChipAutoCompletePage extends FrameworkComponentPage<MatChipAutoCompletePage>
{
    public MatChipAutoCompletePage()
    {
        super("angular-material", "Angular Material", AngularMaterialFrameworkPage.COMPONENTS.get(4));
    }
}

