# songr

Is Java web application built with  Spring MVC,and Thymeleaf.

## classes 
1. MainController Class that has all the primary routs.
2. AlbumController Class for all albums routes.
3. songController Class for all songs routes.
4. SongrApplicationTest Class for all routes tests.


## Applcation Usage

1. go to `build.gradle` file and add the following dependencies

         dependencies {

          compile 'org.springframework.boot:spring-boot-starter-data-jpa'

          implementation('org.springframework.boot:spring-boot-starter-thymeleaf')

          implementation('org.springframework.boot:spring-boot-starter-web')

          runtimeOnly('org.postgresql:postgresql')

          testImplementation('org.springframework.boot:spring-boot-starter-test')

           }

2. create A database called songr in postgress and add the following fill the following inside your `application.proparties` file:
   
           spring.datasource.platform=postgres

           spring.datasource.url=jdbc:postgresql://localhost:5432/songr

           spring.datasource.username=<username>

           spring.datasource.password=<password>

           spring.jpa.hibernate.ddl-auto=update
   
           server.error.whitelabel.enabled=false
     
3. start your server 

## Running the application:

1. Navigate to localhost:8080 for home page
2. Navigate to localhost:8080/hello for welcoming page 
3. Navigate to localhost:8080/Captialize/{Any string you like} display you string captialized
4. Navigate to localhost:8080/songs to View all songs
5. Navigate to localhost:8080/albums to view all albums that have been added or add new album 
6. Navigate to localhost:8080/album/<album #> to view all albums in details also to view its songs also adding new songs to it


