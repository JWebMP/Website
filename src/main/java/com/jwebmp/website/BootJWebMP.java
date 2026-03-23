package com.jwebmp.website;

import com.guicedee.client.IGuiceContext;
import com.guicedee.client.utils.LogUtils;
import com.jwebmp.webawesome.components.WebAwesomePageConfigurator;
import com.jwebmp.website.builder.ApplicationBuilderService;

import lombok.extern.log4j.Log4j2;

@Log4j2
public final class BootJWebMP
{

    private BootJWebMP()
    {
    }

    public static void main(String[] args)
    {
        System.setProperty("HTTP_ENABLED", "true");
        System.setProperty("HTTP_PORT", "8766");
        System.setProperty("jwebmp.process.angular.ts", "false");
        LogUtils.addHighlightedConsoleLogger();
        WebAwesomePageConfigurator.setWaKitCode("fad4033d8cb94cc4");

        IGuiceContext.instance().inject();
        ApplicationBuilderService.getInstance().initialize();
        log.info("JWebMP Website ready.");
    }
}

