plugins {
	java
	id("org.springframework.boot") version "3.2.1"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.9.20"
	kotlin("plugin.spring") version "1.9.20"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations { // 의존선 구성
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories { // Gradle이 종속성을 찾기 위해 어떤 저장소를 검색할지 정의
	mavenCentral()
}


dependencies {
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("org.postgresql:postgresql:42.6.0")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.postgresql:postgresql")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlin:kotlin-stdlib")
	implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")


}

// Gradle 빌드 스크립트에서 테스트 작업에 대한 설정을 지정하는 부분
tasks.withType<Test> { // Gradle에서 제공하는 'Test' 타입의 작업에 대한 설정 블록 시작
	useJUnitPlatform()	//해당 테스트 작업에서 JUnit 5의 테스트 플랫폼을 사용하도록 설정
}
