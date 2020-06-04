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
}

repositories {
  mavenCentral()
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
  jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
  jvmTarget = "1.8"
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
