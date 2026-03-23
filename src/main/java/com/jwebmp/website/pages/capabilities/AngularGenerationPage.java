package com.jwebmp.website.pages.capabilities;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-cap-angular")
@NgRoutable(path = "capabilities/angular-generation")
public class AngularGenerationPage extends WebsitePage<AngularGenerationPage> implements INgComponent<AngularGenerationPage> {
    public AngularGenerationPage() {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        var content = new WaStack();
        content.setGap(PageSize.Medium);
        var grid = grid(2);
        grid.add(featureCard("Component Generation", "@NgComponent, @NgDirective, @NgDataService — Java classes become Angular components with templates, imports, and lifecycle hooks. @NgField, @NgSignal, @NgMethod generate TypeScript class members.", null));
        grid.add(featureCard("Routing", "@NgRoutable(path, redirectTo, pathMatch, parent, sortOrder) defines Angular routes. AngularRoutingModule scans annotated classes and builds RouterModule.forRoot(routes) with parent-child nesting.", null));
        grid.add(featureCard("Build-Time Pipeline", "The Angular Maven Plugin discovers @NgApp classes, generates .ts sources, package.json, angular.json, tsconfig.json, installs npm dependencies, and runs ng build — all inside mvn install.", null));
        grid.add(featureCard("Angular Control-Flow", "NgIf, NgFor, NgLet render Angular 17+ @if, @for, @let template syntax from Java. Structural directives composed server-side, rendered client-side.", null));
        content.add(grid);
        layout.add(buildSection("ANGULAR", "Java-to-Angular Code Generation", "Annotations in, production Angular 20 out.", false, content));
        getMain().add(layout);
    }
}

