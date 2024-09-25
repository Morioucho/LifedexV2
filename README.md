<p align="center">
  <img src="docs/images/LifeDexLogoSmall.png" width="400px" alt="LifeDex Logo">
</p>

<p align="center">
  <img src="https://github.com/Morioucho/LifeDex/actions/workflows/gradle.yml/badge.svg" alt="Gradle Test Status">
</p>


# LifeDex: A Guidebook on Life
LifeDex is a website intended to help people who are new to living by themselves with useful guides on various amounts of topics.

# Features
- **"How To" Tutorials:** A large index of tutorials on how to do basic things, for example, "How to fold your laundry" or "How to cook food".
- **Easy Recipes:** A collection of easy recipes that would be easy for people to make. For example, Avocado on Toast.
- **Tips & Tricks:** A variety of "Tips & Tricks" that aren't very important but are still very useful.
- **Financial Advice:** A collection of financial advice on how to budget your dorm, apartment, house, loans, and other things.

# Quick Start
First, install Docker from the Docker website, you can install it from [here](https://www.docker.com/).

Ensure that Docker is installed properly and that **Docker is running in the background.**

In order to build and run the program, you need to use the following commands:
```bash
# (!! MACOS ONLY !!) Ensure mvnw has write permissions.
# You only have to do this once.
chmod +x ./mvnw

# Build the project.
./mvnw package -DskipTests

# Deploy to Docker.
docker compose up --build

# Close down Docker.
docker compose down
```
Following this, the website should be up on `localhost:8080`. Or whatever port you configured SpringBoot to load into.

# Adding Changes
Updating the backend is fairly easy due to the usage of SpringBoot, every item, such as services and controllers, are stored in their respective packages: `controller`, `model`, `repository`, and `service`.

Updating the frontend is also easy as you can navigate to this folder: `src\main\resources`. You can add templates under the "template" folder (e.x. post.html) and normal pages under the "static" folder (e.x. index.html).

# Roadmap
There are many features planned ahead, but we are still working on implementing the core features such as the **website** and the **backend**.
  
  
<p align="center">
  <i> Made by Saumil Sharma, Kason Lai, Christian Hsu, and Ceazar Jensen Opaon.</i> <br>
  <sub><sup><sub><sup><sub><sup><sub><sup><sub><sup><sub><sup><sub><sup><sub><sup><a href="docs\Information.md">A little easter egg.</a></sup></sub></sup></sub></sup></sub></sup></sub></sup></sub></sup></sub></sup></sub></sup></sub>
</p>

