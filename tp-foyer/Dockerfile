# Utilise l'image OpenJDK 11 depuis Docker Hub
FROM openjdk:17-jdk-alpine

# Expose le port de l'application Spring Boot
EXPOSE 8082

# Ajoute le fichier JAR de votre application dans l'image Docker
# Remplacez `tp-foyer-1.0.jar` par le nom correct de votre JAR généré
ADD target/tp-foyer-1.0.jar tp-foyer-1.0.jar

# Commande pour exécuter l'application Spring Boot
ENTRYPOINT ["java", "-jar", "/tp-foyer-1.0.jar"]
