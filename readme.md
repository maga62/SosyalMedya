# Notlar

## Docker Image larını eklemek

    PostgreSQL
    userName: postgres
    password: 1 
    DD: AuthDB
```bash
docker run -d --name postgressql -p 5432:5432 maga_440/postgressql:v.0.1
```
    MongoDB
    userName: admin
    password: 1
    DB: UserProfileDB
```bash
docker run -d --name mongodb -p 27017:27017 magaclb/mongodb:v0.3
```
    mongod:
    db.createUser({user: "muhammed",pwd: "1",roles: ["readWrite","dbAdmin"]})


```bash
docker run --name microservice-redis -p 6379:6379 -d redis
```

```bash
docker run --name redis-gui -d -p 8001:8001 redislabs/redisinsight:1.14.0
```
## Redis Spring Boot Config

    ilgili bağımlılıklar eklenir
    implementation 'org.springframework.boot:spring-boot-starter-data-redis:3.4.3'

    reddis repository olrak kullanılabileceği gibi cache olarakta kullanıla bilir bu nedenle springde cache i 

## Dockerfile ile image Olusturmak 

    DİKKAT!!!!
    1- lokalimizde çalıştırışlcak ise doğru yöntem 
```bash
docker build -t configserver:v1 . 
```
    2 - docker hub üzerinde yayınlanacak şekilde
```bash
docker build -t magaclb/configserver:v1 . 

docker build -t magaclb/authmicroservice:v1 . 

docker build -t magaclb/usermicroservice:v1 . 

```



