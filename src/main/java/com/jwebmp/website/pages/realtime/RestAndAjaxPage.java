package com.jwebmp.website.pages.realtime;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-rt-rest-ajax")
@NgRoutable(path = "real-time/rest-and-ajax")
public class RestAndAjaxPage extends WebsitePage<RestAndAjaxPage> implements INgComponent<RestAndAjaxPage> {
    public RestAndAjaxPage() {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        var content = new WaStack();
        content.setGap(PageSize.Medium);

        content.add(bodyText(
                "Define a Java class, annotate it with @NgRestClient, and the framework generates a fully typed Angular "
                + "service backed by HttpClient and Angular signals. One annotation per endpoint — GET, POST, PUT, DELETE, "
                + "or PATCH — with built-in polling, caching, deduplication, retry, deep-merge, and authentication. "
                + "No handwritten TypeScript. No boilerplate fetch calls.",
                "m"));

        var grid = grid(2);
        grid.add(featureCard("@NgRestClient",
                "Annotate a Java class with @NgRestClient to generate an @Injectable Angular service. "
                + "Specify the URL, HTTP method, response type, and behaviour flags — the TypeScript code is "
                + "produced at build time by the Angular Maven Plugin.",
                null));
        grid.add(featureCard("Signal-Based State",
                "Every generated service exposes data(), loading(), error(), and success() as Angular WritableSignals. "
                + "Components read them reactively — no manual subscribe/unsubscribe.",
                null));
        grid.add(featureCard("Polling & Caching",
                "Enable pollingEnabled with a configurable interval to re-fetch automatically. "
                + "Enable cachingEnabled with a TTL to skip the network call when data is still fresh.",
                null));
        grid.add(featureCard("Deduplication & Retry",
                "In-flight request deduplication prevents duplicate HTTP calls. "
                + "Configurable retryCount and retryDelayMs handle transient failures automatically.",
                null));
        grid.add(featureCard("Authentication",
                "Built-in auth support — Bearer, Basic, or Custom header. "
                + "Set authType and authTokenField to inject the token into every request.",
                null));
        grid.add(featureCard("Headers & Query Params",
                "@NgRestClientHeader and @NgRestClientQueryParam add static headers and query parameters "
                + "to every request from the generated service.",
                null));
        content.add(grid);

        content.add(codeBlockWithTitle("Simple GET client",
                """
                        @NgRestClient(url = "/api/users")
                        public class UsersClient
                                implements INgRestClient<UsersClient> {
                        }"""));

        content.add(codeBlockWithTitle("POST with caching, retry, and deduplication",
                """
                        @NgRestClient(
                            url = "/api/orders",
                            method = NgRestClient.HttpMethod.POST,
                            singleton = true,
                            cachingEnabled = true,
                            cacheTtlMs = 45_000,
                            deduplication = true,
                            retryCount = 3,
                            retryDelayMs = 2_000
                        )
                        public class OrderClient
                                implements INgRestClient<OrderClient> {
                        }"""));

        content.add(codeBlockWithTitle("Polling with deep merge",
                """
                        @NgRestClient(
                            url = "/api/notifications",
                            responseArray = true,
                            pollingEnabled = true,
                            pollingIntervalMs = 10_000,
                            deepMerge = true,
                            fetchOnCreate = true
                        )
                        public class NotificationsClient
                                implements INgRestClient<NotificationsClient> {
                        }"""));

        content.add(codeBlockWithTitle("Bearer auth with custom headers and query params",
                """
                        @NgRestClient(
                            url = "/api/combined",
                            method = NgRestClient.HttpMethod.POST,
                            authType = NgRestClient.AuthType.BEARER,
                            authTokenField = "this.authService.token()"
                        )
                        @NgRestClientHeader(name = "Content-Type",
                                            value = "application/json")
                        @NgRestClientQueryParam(name = "tenant",
                                                value = "default")
                        public class CombinedClient
                                implements INgRestClient<CombinedClient> {
                        }"""));

        layout.add(buildSection("REST & AJAX", "@NgRestClient — Typed Angular REST Services",
                "One annotation per endpoint. Signals, polling, caching, auth — no handwritten TypeScript.",
                false, content));
        getMain().add(layout);
    }
}

