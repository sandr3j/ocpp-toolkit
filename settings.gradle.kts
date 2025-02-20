rootProject.name = "ocpp-toolkit"

plugins {
    id("com.gradle.enterprise").version("3.11.4")
    id("de.fayard.refreshVersions") version "0.51.0"
}

gradleEnterprise {
    buildScan {
        termsOfServiceUrl = "https://gradle.com/terms-of-service"
        termsOfServiceAgree = "yes"
    }
}

include(
    "toolkit",
    "generic-api",
    "ocpp-wamp",
    "ocpp-soap",
    "ocpp-json",
    "ocpp-transport-websocket",
    "ocpp-transport",
    "ocpp-1-6-api-adapter",
    "ocpp-1-6-core",
    "ocpp-1-6-json",
    "ocpp-1-6-soap",
    "ocpp-1-5-core",
    "ocpp-1-5-api",
    "ocpp-1-5-api-adapter",
    "ocpp-1-5-json",
    "ocpp-1-5-soap",
    "ocpp-transport-soap",
    "ocpp-2-0-api-adapter",
    "ocpp-2-0-core",
    "ocpp-1-6-api",
    "ocpp-2-0-json",
    "ocpp-2-0-api",
    "utils",
    "operation-information"
)
