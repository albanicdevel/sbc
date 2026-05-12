plugins {
    id("java")
}

group = "org.albanix"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("net.dv8tion:JDA:6.4.1")
    implementation("org.spongepowered:configurate-yaml:4.2.0")
    implementation("ch.qos.logback:logback-classic:1.5.6")
}

tasks.test {
    useJUnitPlatform()
}