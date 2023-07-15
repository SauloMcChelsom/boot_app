mvn spring-boot:build-image
-Dspring-boot.build-image.imageName=myrepo/myimage



mvn compile com.google.cloud.tools:jib-maven-plugin:2.3.0:dockerBuild
<dependency>
    <groupId>com.google.cloud.tools</groupId>
    <artifactId>jib-maven-plugin</artifactId>
    <version>3.3.2</version>
    <scope>provided</scope>
</dependency>