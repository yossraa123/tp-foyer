# Utiliser l'image de base Java
FROM openjdk:17-jdk-alpine
# Définir le répertoire de travail
WORKDIR /app

# Copier le fichier JAR dans l'image
COPY tp-foyer-5.0.0.jar app.jar

# Exposer le port sur lequel l'application écoute
EXPOSE 8089

# Commande pour exécuter l'application
CMD ["java", "-jar", "app.jar"]
