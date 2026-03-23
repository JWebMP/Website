package com.jwebmp.website.builder;

import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class ApplicationBuilderService
{
    private static final AtomicReference<ApplicationBuilderService> INSTANCE = new AtomicReference<>();
    private final List<String> availableTemplates = List.of("WebAwesome SPA", "JWebMP Module", "Angular + JWebMP");

    private ApplicationBuilderService()
    {
    }

    public static ApplicationBuilderService getInstance()
    {
        INSTANCE.compareAndSet(null, new ApplicationBuilderService());
        return INSTANCE.get();
    }

    public void initialize()
    {
        // placeholder for builder warm-up logic, content generation, dependency checks
    }

    public List<String> getAvailableTemplates()
    {
        return Collections.unmodifiableList(availableTemplates);
    }

    public List<PluginEntry> getAvailablePlugins()
    {
        return PluginCatalog.getPlugins();
    }
}

