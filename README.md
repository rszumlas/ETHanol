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

ETHanol is a REST API created to handle requests from mobile app and apply business logic to it (e.g calculate Ethereum amount based on delivery time and completion, that needs to be paid to every employee for their work.).
As a forklift driver you can accept parcels that show up on app.
<br><br>
Process flow:
1. Accept delivery.
2. Move parcel to destination indicated in mobile app.
3. When job done, mark order as finished/unfinished. You'll be paid in Ethereum based on delivery time.

***

### Getting started
1. Clone the repo
  ```sh
  git clone https://github.com/rszumlas/ETHanol.git
  ```
2. Compose remaining docker images
  ```
  docker compose up -d
  ```
<br/>

## Endpoints
After running a service, you can access it's endpoint documentation with
  ```
  http://localhost:enter-service-port/swagger-ui.html
  ```
### Ports

* Account: 8080
* Parcel: 8081
* Parcel Accepted: 8082
* Parcel Done: 8083
* Parcel Handling Info: 8084
* Shelf: 8085
* Vodka: 8086

<br/>

## Tech stack

* Spring Boot (Hibernate/Spring Data JPA, Spring Cloud)
* Kafka
* PostgreSQL
* Docker
