import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "com.xemantic.rx"
version = "1.0-SNAPSHOT"

plugins {
  kotlin("jvm") version "1.3.72"
  `maven-publish`
}

java {
  sourceCompatibility = JavaVersion.VERSION_1_8
  targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
  implementation(kotlin("stdlib-jdk8"))
  implementation("io.reactivex.rxjava3:rxjava:3.0.4")
  testImplementation("org.junit.jupiter:junit-jupiter:5.6.2")
  testImplementation("ch.tutteli.atrium:atrium-fluent-en_GB:0.12.0")
  testImplementation("ch.tutteli.atrium:atrium-api-fluent-en_GB-kotlin_1_3:0.12.0")
}

repositories {
  mavenCentral()
}

tasks.test {
  useJUnitPlatform()
  testLogging {
    events("passed", "skipped", "failed")
  }
}

// config JVM target to 1.8 for kotlin compilation tasks
tasks.withType<KotlinCompile>().configureEach {
  kotlinOptions.jvmTarget = "1.8"
}

val sourcesJar by tasks.registering(Jar::class) {
  archiveClassifier.set("sources")
  from(sourceSets.main.get().allSource)
}

publishing {
  publications {
    register("mavenJava", MavenPublication::class) {
      from(components["java"])
      artifact(sourcesJar.get())
    }
  }
}
