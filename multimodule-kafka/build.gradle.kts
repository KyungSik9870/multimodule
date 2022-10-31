dependencies {
    implementation(project(":multimodule-domain"))

    implementation("io.github.microutils:kotlin-logging:1.7.9")
    implementation("org.springframework.kafka:spring-kafka")
    testImplementation("org.springframework.kafka:spring-kafka-test")
}