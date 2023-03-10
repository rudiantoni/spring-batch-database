# spring-batch-database
- Basic working structure without single responsibility, using job, step and tasklet.
- First project using a database (MySQL) for batch metadata persintence.
- Dockerized project: both application and database runs in separate containers.
- Automation oriented: most settings are done via shell scripts.

## Requirements
- Operational system Linux Ubuntu or related distros.
- Docker
    - Instructions: [Install Docker Engine on Ubuntu | Docker Documentation](https://docs.docker.com/engine/install/ubuntu/)
- Docker compose
    - Instructions: [Install the Compose standalone | Docker Documentation](https://docs.docker.com/compose/install/other/)
- Java (JRE/JDK)
    - Recommended JRE version 17.
    - Instructions: [OpenJDK: Download and install](https://openjdk.org/install/)

## Running
- Run the file *deploy.sh* with: `sh deploy.sh`.
    - It uses the following command line argument(s):
        - name
- For didatic purposes (like connecting and checking the database, checking logs, etc), the application doesn't clean the created containers automatically when finishes it's execution, so just follow the *Stopping* section instructions in order to fully stop and clean the application containers.
        
## Stopping
- Run the file *stop.sh* with: `sh stop.sh` to fully stop and remove the application containers.
    - You don't need to stop the application if you want to run it again.

> If you want to change the name in the message, you can change the **JOB_PARAMETER_NAME** variable value inside the file *docker/environment.env*.

Log image with working example:
- [spring-batch-database working example](https://imgur.com/a/e6pOSzQ)