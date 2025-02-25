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

tasks.withType<JavaCompile>().configureEach {
    options.compilerArgs.add("--enable-preview")
}

tasks.withType<JavaExec>().configureEach {
    jvmArgs("--enable-preview")
}

task<JavaExec>("Listing1") {
    mainClass.set("Listing1")
    classpath = sourceSets["main"].runtimeClasspath
}

task<JavaExec>("Listing4") {
    mainClass.set("Listing4")
    classpath = sourceSets["main"].runtimeClasspath
}

task<JavaExec>("Listing5") {
    mainClass.set("Listing5")
    classpath = sourceSets["main"].runtimeClasspath
}
