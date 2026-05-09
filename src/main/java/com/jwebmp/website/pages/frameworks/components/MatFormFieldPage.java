package com.jwebmp.website.pages.frameworks.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.frameworks.FrameworkComponentPage;
import com.jwebmp.website.pages.frameworks.AngularMaterialFrameworkPage;
@NgComponent("jwebmp-comp-matformfield")
@NgRoutable(path = "frameworks/angular-material/mat-form-field")
public class MatFormFieldPage extends FrameworkComponentPage<MatFormFieldPage>
{
    public MatFormFieldPage()
    {
        super("angular-material", "Angular Material", AngularMaterialFrameworkPage.COMPONENTS.get(6));
    }
}

