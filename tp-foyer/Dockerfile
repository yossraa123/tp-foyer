# Utiliser l'image de base Java
FROM openjdk:11-jre-slim

# Définir le répertoire de travail
WORKDIR /app

# Copier le fichier JAR dans l'image
COPY tpfoyer-5.0.0.jar app.jar

# Exposer le port sur lequel l'application écoute
EXPOSE 8080

# Commande pour exécuter l'application
CMD ["java", "-jar", "app.jar"]