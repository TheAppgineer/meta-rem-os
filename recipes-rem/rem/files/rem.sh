#!/bin/sh

STATUS=$(docker container inspect roon-extension-manager --format='{{.State.Status}}')

if [ $? -eq 0 ]; then
    if [ "$STATUS" = "exited" ]; then
        docker start roon-extension-manager
    fi
else
    DOCKER_GID=$(stat -c '%g' /var/run/docker.sock 2> /dev/null)
    TZ=$(timedatectl | sed -n 's/^\s*Time zone: \(.*\) (.*/\1/p')

    docker run -d --network host --restart unless-stopped --name roon-extension-manager --group-add ${DOCKER_GID} -v /home/rem:/home/node/.rem/ -v /var/run/docker.sock:/var/run/docker.sock -e "TZ=${TZ}" --log-driver journald theappgineer/roon-extension-manager:v1.x

    if [ $? -ne 0 ]; then
        exit 1
    fi
fi

docker attach roon-extension-manager

EXIT_CODE=$(docker container inspect roon-extension-manager --format='{{.State.ExitCode}}')

if [ $EXIT_CODE -eq 66 ]; then
    docker rm roon-extension-manager
fi
