echo "Running Maven build..."
./mvnw package -DskipTests

echo "Starting Docker Compose..."
docker compose up --build