cd ..

@echo off
echo Running Maven build...
./mvnw package -DskipTests

echo Starting Docker compose...
docker compose up --build
