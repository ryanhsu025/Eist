# Compile the project

# Build the image

# Fire up the containers
./gradlew clean build
docker build -t eist-ngrok .
docker compose up -d