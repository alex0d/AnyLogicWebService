plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    kotlin("plugin.jpa") version "1.9.25"
    id("org.springframework.boot") version "3.4.0"
    id("io.spring.dependency-management") version "1.1.6"
}

group = "simulation"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.sun.xml.ws:jaxws-ri:4.0.3")
    implementation("org.postgresql:postgresql:9.2-1004-jdbc4")
    implementation("com.querydsl:querydsl-sql:5.1.0")
    implementation("org.eclipse.jetty:jetty-client:12.1.0.alpha0")

    implementation(files("libs/model.jar"))
    implementation(files("libs/com.xj.anylogic.engine.jar"))
    implementation(files("libs/com.xj.anylogic.engine.nl.jar"))
    implementation(files("libs/com.xj.anylogic.engine.sa.jar"))
    implementation(fileTree("libs/lib") {
        exclude("**/*slf4j*.jar")
    })

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-web-services")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    runtimeOnly("org.postgresql:postgresql")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
