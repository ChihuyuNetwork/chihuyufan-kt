FROM eclipse-temurin:21.0.3_9-jre-jammy as builder
WORKDIR /opt
COPY gradle ./gradle
COPY src ./src
COPY build.gradle.kts .
COPY gradle.properties .
COPY settings.gradle.kts .
COPY gradlew .
RUN ./gradlew shadowJar

FROM eclipse-temurin:21.0.3_9-jre-jammy
WORKDIR /opt
COPY --from=builder /opt/build/libs/chihuyufan-kt-all.jar .
CMD ["java", "-jar", "chihuyufan-kt-all.jar"]
