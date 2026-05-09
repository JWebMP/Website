package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-core")
@NgRoutable(path = "plugins/core")
public class CorePluginPage extends PluginDetailPage<CorePluginPage>
{
    public static final List<PluginEntry.ComponentInfo> COMPONENTS = List.of(
            new PluginEntry.ComponentInfo("Page", "Top-level HTML page container with head, body, CSS/JS queues, and rendering pipeline", "com.jwebmp.core.base.html",
                    List.of(
                            new PluginEntry.PropertyInfo("title", "String", "null", "The page title shown in the browser tab"),
                            new PluginEntry.PropertyInfo("tiny", "boolean", "false", "Minifies HTML output, removing whitespace"),
                            new PluginEntry.PropertyInfo("runningLocalhost", "boolean", "true", "Whether serving from localhost or remote"),
                            new PluginEntry.PropertyInfo("author", "String", "null", "The page author meta tag")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Build a Page", "Create an HTML page with components",
                            "Page&lt;?&gt; page = new Page&lt;&gt;();\npage.setTitle(\"My App\");\npage.getBody().add(new H1&lt;&gt;().setText(\"Hello\"));\npage.getBody().add(new Paragraph&lt;&gt;().setText(\"Welcome\"));\nString html = page.toString(true);", "java")),
                    List.of(new PluginEntry.ConstructorInfo("Page()", "Creates an empty HTML page with head and body")),
                    List.of(
                            new PluginEntry.MethodInfo("getBody", "Body", "getBody()", "Returns the page body element"),
                            new PluginEntry.MethodInfo("getHead", "Head", "getHead()", "Returns the page head element"),
                            new PluginEntry.MethodInfo("setTitle", "Page", "setTitle(String title)", "Sets the page title"),
                            new PluginEntry.MethodInfo("setTiny", "Page", "setTiny(boolean tiny)", "Enables minified HTML output"),
                            new PluginEntry.MethodInfo("toString", "String", "toString(boolean tiny)", "Renders the full page as HTML"),
                            new PluginEntry.MethodInfo("setRunningLocalhost", "Page", "setRunningLocalhost(boolean localhost)", "Controls localhost vs remote serving")
                    ),
                    List.of(), List.of(),
                    List.of("IPage", "IComponentHierarchyBase")),

            new PluginEntry.ComponentInfo("DivSimple", "Simplified div element for quick component authoring without generics complexity", "com.jwebmp.core.base.html",
                    List.of(
                            new PluginEntry.PropertyInfo("tag", "String", "div", "The HTML tag name"),
                            new PluginEntry.PropertyInfo("text", "String", "null", "The text content of the div")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Simple Div", "Create a div with text and a child",
                            "DivSimple&lt;?&gt; div = new DivSimple&lt;&gt;();\ndiv.setText(\"Hello World\");\ndiv.setID(\"myDiv\");\ndiv.addClass(\"container\");\ndiv.add(new Paragraph&lt;&gt;().setText(\"Child paragraph\"));", "java")),
                    List.of(
                            new PluginEntry.ConstructorInfo("DivSimple()", "Creates an empty div"),
                            new PluginEntry.ConstructorInfo("DivSimple(String text)", "Creates a div with text content")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("setText", "DivSimple", "setText(String text)", "Sets the text content"),
                            new PluginEntry.MethodInfo("setID", "DivSimple", "setID(String id)", "Sets the element ID"),
                            new PluginEntry.MethodInfo("addClass", "DivSimple", "addClass(String className)", "Adds a CSS class"),
                            new PluginEntry.MethodInfo("add", "DivSimple", "add(IComponentHierarchyBase child)", "Adds a child component")
                    ),
                    List.of(), List.of(),
                    List.of("IComponentHierarchyBase", "GlobalChildren")),

            new PluginEntry.ComponentInfo("Paragraph", "HTML paragraph element with text alignment and styling", "com.jwebmp.core.base.html",
                    List.of(
                            new PluginEntry.PropertyInfo("text", "String", "null", "The paragraph text content"),
                            new PluginEntry.PropertyInfo("textAlign", "String", "null", "Text alignment: left, center, right, justify")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Paragraph", "Create a centred paragraph",
                            "Paragraph&lt;?&gt; p = new Paragraph&lt;&gt;();\np.setText(\"This is centred text.\");\np.setTextAlign(\"center\");", "java")),
                    List.of(
                            new PluginEntry.ConstructorInfo("Paragraph()", "Creates an empty paragraph"),
                            new PluginEntry.ConstructorInfo("Paragraph(String text)", "Creates a paragraph with text")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("setText", "Paragraph", "setText(String text)", "Sets the text content"),
                            new PluginEntry.MethodInfo("setTextAlign", "Paragraph", "setTextAlign(String alignment)", "Sets the text alignment")
                    ),
                    List.of(), List.of(),
                    List.of("IComponentHierarchyBase", "GlobalChildren")),

            new PluginEntry.ComponentInfo("Table", "HTML table with typed header, body, and footer sections", "com.jwebmp.core.base.html",
                    List.of(
                            new PluginEntry.PropertyInfo("caption", "String", "null", "The table caption text")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("HTML Table", "Create a table with header and data rows",
                            "Table&lt;?&gt; table = new Table&lt;&gt;();\nTableHeaderGroup&lt;?&gt; head = table.addHeader();\nhead.addHeaderRow(\"Name\", \"Email\");\nTableBodyGroup&lt;?&gt; body = table.addBody();\nbody.addRow(\"Alice\", \"alice@ex.com\");", "java")),
                    List.of(new PluginEntry.ConstructorInfo("Table()", "Creates an empty table element")),
                    List.of(
                            new PluginEntry.MethodInfo("addHeader", "TableHeaderGroup", "addHeader()", "Adds and returns a thead section"),
                            new PluginEntry.MethodInfo("addBody", "TableBodyGroup", "addBody()", "Adds and returns a tbody section"),
                            new PluginEntry.MethodInfo("addFooter", "TableFooterGroup", "addFooter()", "Adds and returns a tfoot section"),
                            new PluginEntry.MethodInfo("setCaption", "Table", "setCaption(String caption)", "Sets the table caption")
                    ),
                    List.of(), List.of(),
                    List.of("IComponentHierarchyBase")),

            new PluginEntry.ComponentInfo("Form", "HTML form element with action, method, and input bindings", "com.jwebmp.core.base.html",
                    List.of(
                            new PluginEntry.PropertyInfo("action", "String", "null", "The form submission URL"),
                            new PluginEntry.PropertyInfo("method", "String", "POST", "The HTTP method: GET or POST"),
                            new PluginEntry.PropertyInfo("enctype", "String", "null", "The form encoding type")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("HTML Form", "Create a form with inputs",
                            "Form&lt;?&gt; form = new Form&lt;&gt;();\nform.setAction(\"/submit\");\nform.setMethod(\"POST\");\nform.add(new InputTextType&lt;&gt;().setPlaceholder(\"Name\"));\nform.add(new Button&lt;&gt;().setText(\"Submit\"));", "java")),
                    List.of(new PluginEntry.ConstructorInfo("Form()", "Creates an empty form element")),
                    List.of(
                            new PluginEntry.MethodInfo("setAction", "Form", "setAction(String action)", "Sets the submission URL"),
                            new PluginEntry.MethodInfo("setMethod", "Form", "setMethod(String method)", "Sets the HTTP method"),
                            new PluginEntry.MethodInfo("setEnctype", "Form", "setEnctype(String enctype)", "Sets the encoding type"),
                            new PluginEntry.MethodInfo("add", "Form", "add(IComponentHierarchyBase child)", "Adds a form child element")
                    ),
                    List.of(new PluginEntry.EventInfo("submit", "Fired when the form is submitted")),
                    List.of(),
                    List.of("IComponentHierarchyBase")),

            new PluginEntry.ComponentInfo("InputTextType", "Typed text input element with placeholder, value, and validation", "com.jwebmp.core.base.html.inputs",
                    List.of(
                            new PluginEntry.PropertyInfo("placeholder", "String", "null", "Placeholder text shown when empty"),
                            new PluginEntry.PropertyInfo("value", "String", "null", "The input value"),
                            new PluginEntry.PropertyInfo("required", "boolean", "false", "Whether the field is required"),
                            new PluginEntry.PropertyInfo("maxLength", "int", "0", "Maximum character length"),
                            new PluginEntry.PropertyInfo("pattern", "String", "null", "Regex validation pattern"),
                            new PluginEntry.PropertyInfo("readOnly", "boolean", "false", "Whether the input is read-only")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Text Input", "Create a required text input",
                            "InputTextType&lt;?&gt; input = new InputTextType&lt;&gt;();\ninput.setPlaceholder(\"Enter your name\");\ninput.setRequired(true);\ninput.setMaxLength(100);", "java")),
                    List.of(new PluginEntry.ConstructorInfo("InputTextType()", "Creates a text input element")),
                    List.of(
                            new PluginEntry.MethodInfo("setPlaceholder", "InputTextType", "setPlaceholder(String placeholder)", "Sets the placeholder text"),
                            new PluginEntry.MethodInfo("setValue", "InputTextType", "setValue(String value)", "Sets the input value"),
                            new PluginEntry.MethodInfo("setRequired", "InputTextType", "setRequired(boolean required)", "Makes the field required"),
                            new PluginEntry.MethodInfo("setMaxLength", "InputTextType", "setMaxLength(int maxLength)", "Sets the max character length"),
                            new PluginEntry.MethodInfo("setPattern", "InputTextType", "setPattern(String pattern)", "Sets a regex validation pattern"),
                            new PluginEntry.MethodInfo("setReadOnly", "InputTextType", "setReadOnly(boolean readOnly)", "Makes the input read-only")
                    ),
                    List.of(
                            new PluginEntry.EventInfo("input", "Fired on every keystroke"),
                            new PluginEntry.EventInfo("change", "Fired when the value changes and focus is lost")
                    ),
                    List.of(),
                    List.of("IComponentHierarchyBase", "BSFormChildren")),

            new PluginEntry.ComponentInfo("Feature", "Wraps JavaScript libraries with typed options, CSS/JS references, and render hooks", "com.jwebmp.core.base",
                    List.of(
                            new PluginEntry.PropertyInfo("name", "String", "null", "The feature name identifier"),
                            new PluginEntry.PropertyInfo("component", "IComponentHierarchyBase", "null", "The component this feature is attached to"),
                            new PluginEntry.PropertyInfo("sortOrder", "int", "500", "Render order among features")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Custom Feature", "Create a feature that runs JavaScript on a component",
                            "public class FadeInFeature extends Feature&lt;FadeInFeature&gt; {\n    public FadeInFeature(IComponentHierarchyBase component) {\n        super(\"FadeIn\", component);\n    }\n    @Override\n    protected void assignFunctionsToComponent() {\n        addQuery(\"$('#\" + getComponent().getID() + \"').fadeIn();\");\n    }\n}", "java")),
                    List.of(
                            new PluginEntry.ConstructorInfo("Feature(String name)", "Creates a feature with a name"),
                            new PluginEntry.ConstructorInfo("Feature(String name, IComponentHierarchyBase component)", "Creates a feature attached to a component")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("assignFunctionsToComponent", "void", "assignFunctionsToComponent()", "Override to define the JavaScript for this feature"),
                            new PluginEntry.MethodInfo("addQuery", "Feature", "addQuery(String javascript)", "Adds a JavaScript query string"),
                            new PluginEntry.MethodInfo("getComponent", "IComponentHierarchyBase", "getComponent()", "Returns the attached component"),
                            new PluginEntry.MethodInfo("addCssReference", "Feature", "addCssReference(CSSReference ref)", "Adds a CSS reference"),
                            new PluginEntry.MethodInfo("addJavaScriptReference", "Feature", "addJavaScriptReference(JavascriptReference ref)", "Adds a JavaScript reference")
                    ),
                    List.of(), List.of(),
                    List.of("IFeature"))
    );

    public CorePluginPage()
    {
        super(PluginCatalog.getById("core").orElseThrow());
    }

    @Override
    protected List<PluginEntry.ComponentInfo> pluginComponents()
    {
        return COMPONENTS;
    }

    @Override
    protected List<PluginEntry.ExampleSnippet> pluginExamples()
    {
        return List.of(
                new PluginEntry.ExampleSnippet("Create a Page with Components",
                        "Build a full HTML page with nested div, heading, and paragraph.",
                        "Page<?> page = new Page<>();\nDiv<?, ?, ?> container = new Div<>();\ncontainer.add(new H1<>().setText(\"Hello\"));\ncontainer.add(new Paragraph<>().setText(\"Welcome to JWebMP\"));\npage.getBody().add(container);\nString html = page.toString(true);",
                        "java"),
                new PluginEntry.ExampleSnippet("Server-Driven Click Event",
                        "Attach a server-side click handler that runs Java code when the button is clicked.",
                        "var button = new Button<>().setText(\"Click Me\");\nbutton.addEvent(new OnClickAdapter(button) {\n    @Override\n    public void onClick(AjaxCall<?> call, AjaxResponse<?> response) {\n        response.addComponent(new Paragraph<>()\n            .setText(\"Button was clicked!\"));\n    }\n});",
                        "java")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "uses", "Discovered at startup to inject CSS/JS references and configure the page before rendering"),
                new PluginEntry.SpiDetail("IPage", "uses", "Page implementations discovered via ServiceLoader for automatic route registration"),
                new PluginEntry.SpiDetail("IGuiceModule", "provides", "Registers core Guice bindings for component model, event system, and rendering pipeline"),
                new PluginEntry.SpiDetail("IOnComponentConfigured", "provides", "Callback fired after each component is configured, enabling post-processing hooks"),
                new PluginEntry.SpiDetail("ScriptProvider", "uses", "Provides dynamic JavaScript fragments injected into the page at render time")
        );
    }

    @Override
    protected List<PluginEntry.ConfigEntry> pluginConfigurations()
    {
        return List.of(
                new PluginEntry.ConfigEntry("Page.setTiny(boolean)", "boolean", "false", "Enable minified HTML output — removes whitespace and comments"),
                new PluginEntry.ConfigEntry("Page.setRunningLocalhost(boolean)", "boolean", "true", "Controls whether to serve from localhost or remote address")
        );
    }
}
