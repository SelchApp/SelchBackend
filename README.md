# SelchBackend


This is the backend service for the Selch App that serves the following purposes
* User authentification
* API for
  * User position service
  * Routing service

The backend is just a prototype that must not be used in production environments.

The compile the backend, simply call `mvn package`.
To use the services, access the services via
* http://localhost:8080/position/self (GET/POST)
* http://localhost:8080/position/user/n (GET)
* http://localhost:8080/team/n (GET)
* http://localhost:8080/route/touser/n (POST including GPS coordinates)
