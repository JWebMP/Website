import com.jwebmp.core.base.angular.client.services.TypescriptIndexPageConfigurator;
import com.jwebmp.core.services.IPageConfigurator;
import com.jwebmp.website.WebsitePageConfigurator;

module com.jwebmp.website {

    requires transitive com.jwebmp.core;
    requires transitive com.jwebmp.client;

    requires transitive com.guicedee.client;
    requires transitive com.guicedee.guicedinjection;

    requires transitive com.jwebmp.webawesome;
    requires transitive com.jwebmp.webawesomepro;
    requires transitive com.jwebmp.core.angular;
    requires transitive com.jwebmp.core.base.angular.client;

    requires transitive com.jwebmp.plugins.markdown;
    requires transitive com.jwebmp.plugins.prism;
    requires transitive com.jwebmp.plugins.easingeffects;
    requires transitive com.jwebmp.plugins.agcharts;
    requires transitive com.jwebmp.plugins.aggrid;
    requires transitive com.jwebmp.plugins.graphing.chartjs;
    requires transitive com.jwebmp.plugins.fullcalendar;

    requires transitive com.guicedee.vertx;
    requires transitive com.guicedee.vertx.web;

    requires static lombok;
    requires org.apache.commons.text;
    requires org.apache.logging.log4j;
    requires org.apache.logging.log4j.core;
    requires org.mapstruct;

    opens com.jwebmp.website to com.google.guice;
    opens com.jwebmp.website.builder to com.google.guice;
    opens com.jwebmp.website.catalog to com.google.guice;
    opens com.jwebmp.website.pages to com.google.guice;
    opens com.jwebmp.website.pages.home to com.google.guice;
    opens com.jwebmp.website.pages.gettingstarted to com.google.guice;
    opens com.jwebmp.website.pages.architecture to com.google.guice;
    opens com.jwebmp.website.pages.capabilities to com.google.guice;
    opens com.jwebmp.website.pages.realtime to com.google.guice;
    opens com.jwebmp.website.pages.plugins to com.google.guice;

    provides TypescriptIndexPageConfigurator with WebsitePageConfigurator;
    provides IPageConfigurator with WebsitePageConfigurator;
}


