#!/bin/sh
ENV_FILE=environment.env
APPLICATION_CONTAINER=database_batch_app

echo
echo "Building application container image..."
sh ./script/build_docker_image.sh

echo "Starting using the environtment file $ENV_FILE..."
cd ./docker
sudo docker-compose --env-file $ENV_FILE up -d

echo "Cleaning untagged docker images."
sudo docker images -q -f "dangling=true" | sudo xargs --no-run-if-empty docker rmi -f

echo "Watching logs for $APPLICATION_CONTAINER container..."
sudo docker logs -f --tail 500 $APPLICATION_CONTAINER

echo "Finishing execution..."
sudo docker-compose down

echo
echo "Finished successfully."