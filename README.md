# 🌐 JWebMP Website

[![JDK](https://img.shields.io/badge/JDK-25%2B-0A7?logo=java)](https://openjdk.org/projects/jdk/25/)
[![Build](https://img.shields.io/badge/Build-Maven-C71A36?logo=apachemaven)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0)

This repository powers the **public JWebMP website**, presenting the JWebMP framework with documentation, samples, plugin catalog, and getting-started guides.

## ✨ Site Vision
- Surface every JWebMP plugin alongside its capabilities so users can discover, inspect, and compose them into applications.
- Provide a **Plugin Catalog** that lists every available JWebMP plugin with descriptions and Maven coordinates.
- Offer a **Getting Started** guide that walks developers through creating their first JWebMP application.
- Showcase the **Capabilities** of the framework — type-safe HTML, CSS, events, Angular generation, and the plugin ecosystem.
- Host a single monolithic boot implementation that invokes `IGuiceContext.inject()` so the site remains focused and simple.
- Generate every page with the JWebMP/WebAwesome stack so that the WebAwesome components (`WaButton`, `WaCard`, `WaCluster`, `WaStack`, etc.) drive the layout, styling, and content.
- Define the primary navigation and page structure using WebAwesome's `WaPage`/`WaMenu` paradigms.

## 🧩 Plugin Catalog
- `angular` — Angular 20 application generation
- `web-awesome` — WebAwesome component library
- `web-awesome-pro` — Premium WebAwesome features
- `typescript-client` — TypeScript client generation
- `agcharts` / `agcharts-enterprise` — AG Charts
- `aggrid` / `aggrid-enterprise` — AG Grid
- `chartjs` — Chart.js charting
- `easing` — CSS/JS easing animations
- `fontawesome` / `fontawesome-pro` — Font Awesome icons
- `fullcalendar` / `fullcalendar-pro` — FullCalendar scheduling

## ⚙️ Technology Stack
- **Language**: Java 25 (with latest preview features)
- **Build Tool**: Maven
- **Frameworks**: GuicedEE, Vert.x 5, JWebMP, WebAwesome
- **Architecture**: Modular JPMS services
- **UI**: JWebMP + WebAwesome + Angular 20
- **Logging**: Log4j2 with Lombok `@Log4j2`
- **DTO Mapping**: MapStruct

## 🚀 Quick Start

```bash
# Build the project
mvn clean install

# Run the website
java -jar target/website-2.0.0-SNAPSHOT.jar
# → http://localhost:8766
```

## 📁 Project Structure

```
src/main/java/com/jwebmp/website/
├── Boot.java                          # Application entry point
├── WebsiteApplication.java            # NgApp definition
├── WebsiteBoot.java                   # Root boot component with WaPage layout
├── WebsitePageConfigurator.java       # IPageConfigurator for CSS references
├── package-info.java                  # Package-level annotations
├── builder/
│   └── ApplicationBuilderService.java # Template and plugin discovery
├── catalog/
│   ├── PluginCatalog.java             # Static plugin registry with categories
│   └── PluginEntry.java               # Plugin metadata (id, name, category, coords)
└── pages/
    ├── WebsitePage.java               # Base page with shared layout, menu, footer
    ├── HomePage.java                  # Landing — full-stack pitch, code samples, ecosystem
    ├── GettingStartedPage.java        # 6-step tutorial from zero to running app
    ├── ArchitecturePage.java          # Stack diagram, build pipeline, runtime flow
    ├── PluginsPage.java               # Category-grouped plugin catalog
    ├── RealTimePage.java              # RabbitMQ messaging deep-dive
    ├── CapabilitiesPage.java          # Rendering, Angular, events, SPI extensibility
    └── GitHubPage.java                # Repository links and related projects
```

## 📝 License
Apache 2.0 — see [LICENSE](./LICENSE).
