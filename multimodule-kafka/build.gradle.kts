dependencies {
    implementation(project(":multimodule-domain"))

    implementation("org.springframework.kafka:spring-kafka")
    testImplementation("org.springframework.kafka:spring-kafka-test")
}