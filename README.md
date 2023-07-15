mvn spring-boot:build-image

docker-compose -f docker-compose-db.yml up -d

https://mkyong.com/maven/how-to-install-maven-in-windows/




Se este error aparcer
```bash
# deletar confi.json
## C:\Users\saulo\.docker
[ERROR] Failed to execute goal com.google.cloud.tools:jib-maven-plugin:3.3.2:dockerBuild (default-cli) on project boot_app: Build to Docker daemon failed, perhaps you should make sure your credentials for 'registry-1.docker.io/library/conf_server_image' are set up correctly. See https://github.com/GoogleContainerTools/jib/blob/master/docs/faq.md#what-should-i-do-when-the-registry-responds-with-unauthorized for help: Unauthorized for registry-1.docker.io/library/conf_server_image: 401 Unauthorized
[ERROR] GET https://auth.docker.io/token?service=registry.docker.io&scope=repository:library/conf_server_image:pull
[ERROR] {"details":"incorrect username or password"}
[ERROR] -> [Help 1]
[ERROR]
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR]
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoExecutionException
```

mvn -version
mvn compile jib:dockerBuild
mvnw clean compile jib:dockerBuild


#listar as image criada
docker image ls

#executar uma image criada
docker run -dp 8080:80 afdd80fe5867

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

ajustar os endpoint

Java SE 19 = 63,
Java SE 18 = 62,
Java SE 17 = 61,
Java SE 16 = 60, 
Java SE 15 = 59,
Java SE 14 = 58,
Java SE 13 = 57,
Java SE 12 = 56,
Java SE 11 = 55,
Java SE 10 = 54,
Java SE 9 = 53,
Java SE 8 = 52,
Java SE 7 = 51,
Java SE 6.0 = 50,
Java SE 5.0 = 49,
JDK 1.4 = 48,
JDK 1.3 = 47,
JDK 1.2 = 46,
JDK 1.1 = 45