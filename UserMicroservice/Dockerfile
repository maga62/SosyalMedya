FROM amazoncorretto:21.0.2-alpine3.19

# Uygulamanın jar dosyasını içine kopyala
COPY build/libs/user-service-0.0.1-SNAPSHOT.jar app.jar

# Uygulamayı çalıştır
ENTRYPOINT ["java", "-jar", "/app.jar"]
