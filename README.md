# Docker  

- [x] Create Docker images for spring applications and push this image to docker hub 
- [ ] We will work on Integrating multiple dodcker images using Docker Compose file.  Create tow images like spring boot and Database they should be communicating with each other.  
- [ ] We will work on implementing a sample micro service application with Docker and swarm cluster.  

## Spring boot with Docker Image :

* We nee to generate Docker file for the spring boot application.  

#### Generating Docker file : 

Let’s go through each line of the Dockerfile and understand the details.

<b>FROM: </b> Docker image can have a parent image which will have all the basic details for execution of commands with in the image.We need to chose an image accordingly. In the above example, we use the openjdk:8-jdk-alpine image as our base image. It is a very lightweight OpenJDK 8 runtime image that uses Alpine Linux. (It’s perfect for small Java microservices.) 

<b>LABEL: </b> The LABEL instruction is used to add metadata to the image. In the above Dockerfile, we have added some info about the maintainer of the image through LABEL instruction.

<b>VOLUME:  </b>  In docker container once the container is lost all the info related to this container will be gone to avoid this we will use volumes which will store this info in host machine.  

<b>EXPOSE:  </b> As the name suggests, this instruction allows you to expose a certain port to the outside world.

<b>ARG:  </b>The ARG instruction defines a variable with a default value. You can override the default value of the variable by passing it at build time.

ARG <name>[=<default value>]
Once defined, the variable can be used by the instructions following it.

<b>ADD:  </b> The ADD instruction is used to copy new files and directories to the docker image.

<b>ENTRYPOINT:  </b> This is be command with which docker container will start .Every image will have set of binaries and the command with whcih it should start  

* We will create a file in project directory and name it as Dockerfile. 

        FROM openjdk:8-jdk-alpine
        LABEL maintainer="javajvm007@gmail.com"
        EXPOSE 8080
        ADD /target/springdockerdemo.jar springdockerdemo.jar
        ENTRYPOINT ["java", "-jar", "springdockerdemo.jar"] 

#### Setting up Docker Spotify Maven  plugin :

* We can use spotify plugin to generate docker images adding the plugin details in maven pom.xml   

        <!--  SPOTIFY PLUGIN CONFIGURATION -->
                    <plugin>
                        <groupId>com.spotify</groupId>
                        <artifactId>dockerfile-maven-plugin</artifactId>
                        <version>1.4.7</version>
                        <executions>
                            <execution>
                                <id>default</id>
                                <goals>
                                    <goal>build</goal>
                                    <goal>push</goal>
                                </goals>
                            </execution>
                        </executions>
                        <configuration>
                            <!-- UserName/Image name (image name should be small letters) -->
                            <repository>javajvm007/springdockerdemo</repository>
                            <tag>${project.version}</tag>
                            <buildArgs>
                                <JAR_FILE>target/${project.build.finalName}.jar</JAR_FILE>
                            </buildArgs>
                        </configuration>
                    </plugin>

NOTE :  jar file name should always be small letter or else spotify plug will fail.  

#### Build the Docker image and start the container : 

*  We can use the following docker build command to generate docker image.(navigate to DockerFIle location )  

        docker build ./ -t springdockerdemo
        
*  This will create docker image with latest version.  

*  Starting the Docker container. This will allow to access the image on http://localhost:5000/test/docker url.  

        docker run -p 5000:8080 -d  springdockerdemo:latest

#### Pushing the Docker image to Docker Hub  :   

* We need to tag the image to push the image in to hub.  

        docker tag image username/repository:tag
        
        docker tag springdockerdemo javajvm007/springdockerdemo:0.0.1-SNAPSHOT
        
 *  Now push the image to Dockerhub.  
 
        docker push javajvm007/springdockerdemo:0.0.1-SNAPSHOT  
        
 









