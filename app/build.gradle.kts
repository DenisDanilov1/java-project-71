plugins {
    id("checkstyle")
    application
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass = "hexlet.code.App"
}

dependencies {
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.13.4")
    implementation ("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.13.4")
    implementation ("info.picocli:picocli:4.7.5")
    implementation("org.apache.commons:commons-lang3:3.14.0")
    implementation("org.apache.commons:commons-collections4:4.4")
    implementation("org.jetbrains:annotations:24.0.0")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}