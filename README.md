# Car Rental Car Microservice

Car Rental microservice project for Service Engineering

## Build and Run 

1. `mvn package`
2. `docker build -t se-carrental/car-service .`
3. `docker tag se-carrental/car-service rabbitcarrental.azurecr.io/se-carrental/car-service:latest`
4. `docker login rabbitcarrental.azurecr.io`
5. `docker push rabbitcarrental.azurecr.io/se-carrental/car-service:latest`
6. `docker logout rabbitcarrental.azurecr.io`
7. `docker run -p 4444:4444 se-carrental/car-service`
