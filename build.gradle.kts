plugins {
    id("java")
}

group = "net.dinkla"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(24))
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.compilerArgs.add("--enable-preview")
}

tasks.withType<JavaExec>().configureEach {
    jvmArgs("--enable-preview")
}

task<JavaExec>("listing1") {
    mainClass.set("Listing1")
    classpath = sourceSets["main"].runtimeClasspath
}

task<JavaExec>("listing5") {
    mainClass.set("Listing5")
    classpath = sourceSets["main"].runtimeClasspath
}

task<JavaExec>("listing7") {
    mainClass.set("Listing7")
    classpath = sourceSets["main"].runtimeClasspath
}
