


como instalar maven no windows
https://mkyong.com/maven/how-to-install-maven-in-windows/



mvn -version

mvn compile jib:dockerBuild

docker-compose -f ./docker/docker-compose.yml up -d

docker stop boot_app

CONTAINER ID   IMAGE                            COMMAND                  CREATED          STATUS          PORTS                    NAMES
09f2ed95f684   saulomcchelsom/boot_app:latest   "java -cp @/app/jib-…"   23 minutes ago   Up 23 minutes   0.0.0.0:8080->8080/tcp   boot_app

#listar as image criada
docker image ls

#executar uma image criada
docker run -dp 8080:8080 afdd80fe5867

#lista a virtualização da imagem executada
docker container ls

#iniciar uma virtualização da imagem atraves do CONTAINER ID
docker start c2d0c0d2bf03

#parar a virtualização da imagem atraves do CONTAINER ID
docker stop c2d0c0d2bf03

#abrir a virtualização da imagem atraves do CONTAINER ID
docker exec -ti c2d0c0d2bf03 /bin/sh

#ver logger do console da virtualização da imagem atraves do CONTAINER ID
docker logs -f c2d0c0d2bf03


### Tutorial oficial: 
https://docs.microsoft.com/en-us/windows/wsl/install-win10

### Passo 1 (PowerShell Admin): 
dism.exe /online /enable-feature /featurename:Microsoft-Windows-Subsystem-Linux /all /norestart

### Passo 2 (PowerShell Admin):
dism.exe /online /enable-feature /featurename:VirtualMachinePlatform /all /norestart

### Passo 3
REINICIE O COMPUTADOR

### Passo 4 (Download the Linux kernel update package):
https://wslstorestorage.blob.core.windows.net/wslblob/wsl_update_x64.msi

### Passo 5 (PowerShell Admin):
wsl --set-default-version 2

### Passo 7 (Instale o docker):
Tutorial: https://docs.docker.com/docker-for-windows/install/



### How to start up spring-boot application via command line?
mvn spring-boot:run

java -jar target/boot_app-0.0.9-SNAPSHOT.jar

mvn clean install

mvn test


https://start.spring.io/

java.Project.start 17 
spring-boot 3.1.1
Apache Maven 3.9.3
Java version: 19.0.1



http://localhost:8080/h2-console/
JDBC URL:jdbc:h2:mem:testdb
User Name: saulo
Password:123