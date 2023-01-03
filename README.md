# database-spring-batch
- Basic working structure without single responsibility, using job, step and tasklet.
- First project using a database (MySQL) for batch metadata persintence.

## Running
- Operational system Linux Ubuntu or related distros.
- Docker
    - Instructions: [Install Docker Engine on Ubuntu | Docker Documentation](https://docs.docker.com/engine/install/ubuntu/)
- Docker compose
    - Instructions: [Install the Compose standalone | Docker Documentation](https://docs.docker.com/compose/install/other/)
- Recommended JRE version 17.
    - Instructions: [OpenJDK: Download and install](https://openjdk.org/install/)
- Command line argument: `name`
- Run the file `deploy.sh` with: `sh deploy.sh`.

> If you want to change the name in the message, you can change the `JOB_PARAMETER_NAME` variable value inside the file `docker/environment.env`.

Log image with working example:
- [database-spring-batch working example](https://imgur.com/a/e6pOSzQ)