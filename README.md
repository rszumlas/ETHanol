<div align="center">
<h1 align="center">ETHanol</h1>

<br>

<a align="center">
Backend of future Kotlin mobile app for vodka warehouse employees. Keeps track on incoming and outgoing orders. <br>
Every forklift worker can access a client app that displays recent parcels that came into the warehouse.
</a>
<br><br>
<img src="https://i.ibb.co/kXJBD13/forklift-reverse.png" alt="Logo" width="250">
</div>


<!-- ABOUT THE PROJECT -->
## About The Project

ETHanol is a REST API created to handle requests from mobile app and apply business logic to it (e.g calculate Ethereum amount based on delivery time and completion, that needs to be paid to worker for every order).
As a forklift driver you can accept parcels that show up on app.
<br><br>
Wanting to take up one of them, there are a few easy steps to follow:
1. Accept it.
2. Do your work and complete it. There should be displayed your destination shelf to help you.
3. When job done, mark order as finished/unfinished. You'll be paid in Ethereum based on delivery time.

***

### Getting started
1. Clone the repo
  ```sh
  git clone https://github.com/rszumlas/ETHanol.git
  ```
2. Compose remaining docker images (PostgreSQL, pgAdmin4)
  ```
  docker compose up -d
  ```
  
### Tech stack

* Spring Boot
* Spring Data JPA
* Spring Cloud
* PostgreSQL
* Docker
