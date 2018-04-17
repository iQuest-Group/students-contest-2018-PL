# iQuest contest 2018

## Introduction
This repository contains mock API server created for iQuest student contest. 
It contains endpoints related to railway industry system:
1. **Search for trains**: Allows to search for trains by origin and destination cities, and departure date and time (datetime ISO format)
2. **Get prices for train**: If we found train, we can get possible prices by train ID and travel class (First, Second)
3. **Get seats for train**: If we found train, we can get possible seats by train ID and travel class (First, Second)
4. **Reserve/unreserve seats**: When we took all possible seats for train, we can either reserve, or unreserve the seat. After reservation of seat, seat will become unavailable for others. In case of unreservation, it will become available to others again.

## Launching mock API server
1. In order to launch server, you need to have Java 8 (JRE+JDK) installed in your system.
2. After cloning repository, you need to run the server. You can do it by executing:

**Linux/MacOS**
```bash
./mvnw spring-boot:run
```
**Windows**
```bash
./mvnw.cmd spring-boot:run
```

3. By default, server is running on **8080** port. If you need to change it, you need to pass parameter to executed command:
```bash
./mvnw spring-boot:run -Dspring-boot.run.jvmArguments='-Dserver.port=9999'
```
In this case, server will start on **9999** port.

The essence of this server are API endpoints for the operations mentioned in "Introduction" section. You can take a look at all of them, and even test it in action. Just go to http://localhost:8080/swagger-ui.html . This link contains automatically generated API documentation.

## How is it working?
When you run the above command, tomcat server is executed, and in-memory database is created. Each time you re-run the server, the database is created from scratch. In-memory database contains entities, like.: Train, Price Offer, Seats etc.
**Trains** entity is the most important one. Server is supporting the following routes:
1. **Warsaw-Gdansk**
2. **Warsaw-Cracow**

In terms of departure date, you can pick the date from current date (start date of server), up to 10 days further.
If you started server on 17th of april, you can search for Warsaw-Gdansk or Warsaw-Cracow route starting from 17th, ending on 26th of April.
*Example search:* when you search for Warsaw-Gdansk for 22th of April, you will receive as train for 22th, and all future trains (up to 26th of April)

## I need this server to be visible to public. What to do?
In most of cases you need only to run this server locally. On the other hand, it may happen, that you need some external system to see this server. An example could be chatbot system (like.: DialogFlow). In that case we can use tool called **ngrok** (https://ngrok.com/). It allows you to create an SSH tunnel. By using this you will be able to test this server with external systems.

After signing up and getting **ngrok** command line tool, you can open SSH tunnel for our server (on 8080 port):
```bash
./ngrok http 8080
```

As a response, you should get something like:
```bash
Session Status                online
Account                       Sebastian Mekal (Plan: Pro)
Version                       2.2.8
Region                        United States (us)
Web Interface                 http://127.0.0.1:4040
Forwarding                    http://fa3137f3.ngrok.io -> localhost:8080
Forwarding                    https://fa3137f3.ngrok.io -> localhost:8080

Connections                   ttl     opn     rt1     rt5     p50     p90
                              0       0       0.00    0.00    0.00    0.00
```
In our case, the public IP for us is: https://fa3137f3.ngrok.io

In case of any problems and questions, please contact **Sebastian Mękal (sebastian.mekal@iquestgroup.com)**
