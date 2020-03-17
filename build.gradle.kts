import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.springframework.boot") version "2.2.5.RELEASE"
  id("io.spring.dependency-management") version "1.0.9.RELEASE"
  kotlin("jvm") version "1.3.61"
  kotlin("plugin.spring") version "1.3.61"
  id("org.unbroken-dome.test-sets") version "2.1.1"
}

group = "com.rubenaranamorera"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
  mavenCentral()
}

dependencies {
  // Spring
  implementation("org.springframework.boot:spring-boot-starter")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-security")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

  // jwt
  implementation("io.jsonwebtoken:jjwt:0.9.1")
  implementation("javax.xml.bind:jaxb-api:2.3.1")


  testImplementation("org.springframework.boot:spring-boot-starter-test") {
    exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
  }
  testImplementation("org.springframework.security:spring-security-test")

  testImplementation("io.rest-assured:rest-assured:4.3.0")
  testImplementation("io.rest-assured:spring-mock-mvc:4.3.0")
  testImplementation("io.rest-assured:json-path:4.3.0")
  testImplementation("io.rest-assured:xml-path:4.3.0")
}

testSets {
  create("integrationTest")
}

tasks.withType<Test> {
  useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs = listOf("-Xjsr305=strict")
    jvmTarget = "1.8"
  }
}
