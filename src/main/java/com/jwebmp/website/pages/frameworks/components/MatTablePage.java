package com.jwebmp.website.pages.frameworks.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.frameworks.FrameworkComponentPage;
import com.jwebmp.website.pages.frameworks.AngularMaterialFrameworkPage;
@NgComponent("jwebmp-comp-mattable")
@NgRoutable(path = "frameworks/angular-material/mat-table")
public class MatTablePage extends FrameworkComponentPage<MatTablePage>
{
    public MatTablePage()
    {
        super("angular-material", "Angular Material", AngularMaterialFrameworkPage.COMPONENTS.get(10));
    }
}

