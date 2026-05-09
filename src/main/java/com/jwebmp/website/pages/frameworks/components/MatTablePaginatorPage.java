package com.jwebmp.website.pages.frameworks.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.frameworks.FrameworkComponentPage;
import com.jwebmp.website.pages.frameworks.AngularMaterialFrameworkPage;
@NgComponent("jwebmp-comp-mattablepaginator")
@NgRoutable(path = "frameworks/angular-material/mat-table-paginator")
public class MatTablePaginatorPage extends FrameworkComponentPage<MatTablePaginatorPage>
{
    public MatTablePaginatorPage()
    {
        super("angular-material", "Angular Material", AngularMaterialFrameworkPage.COMPONENTS.get(11));
    }
}

