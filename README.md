# Docker  
- [ ] In this Repository we will Create Docker images for spring applications and chekin this image in docker hub.  
- [ ] We will work on Integrating multiple dodcker images using Docker Compose file.  
- [ ] We will work on implementing a sample micro service application with Docker and swarm cluster.  

## Spring boot with Docker Image :

* We nee to generate Docker file for the spring boot application.  

#### Generating Docker file : 

The Dockerfile is very simple and declarative. Let’s go through each line of the Dockerfile and understand the details.

<b>FROM: </b> Docker image can have a parent image which will have all the basic details for execution of commands with in the image.We need to chose an image accordingly. In the above example, we use the openjdk:8-jdk-alpine image as our base image. It is a very lightweight OpenJDK 8 runtime image that uses Alpine Linux. (It’s perfect for small Java microservices.) 

<b>LABEL: </b> The LABEL instruction is used to add metadata to the image. In the above Dockerfile, we have added some info about the maintainer of the image through LABEL instruction.

<b>VOLUME:  </b>  In docker container once the container is lost all the info related to this container will be gone to avoid this we will use volumes which will store this info in host machine.  

<b>EXPOSE:  </b> As the name suggests, this instruction allows you to expose a certain port to the outside world.

<b>ARG:  </b>The ARG instruction defines a variable with a default value. You can override the default value of the variable by passing it at build time.

ARG <name>[=<default value>]
Once defined, the variable can be used by the instructions following it.

<b>ADD:  </b> The ADD instruction is used to copy new files and directories to the docker image.

<b>ENTRYPOINT:  </b> This is be command with which docker container will start .Every image will have set of binaries and the command with whcih it should start  

We will create a file in project directory and name it as Dockerfile. 

    FROM java:8
    EXPOSE 8080
    ADD /targer/springDockerDemo.jar springDockerDemo.jar
    ENTRYPOINT ["java", "-jar", "springDockerDemo.jar"] 

Setting up Docker Maven  plugin :

* We can use spotify plugin to generate 
