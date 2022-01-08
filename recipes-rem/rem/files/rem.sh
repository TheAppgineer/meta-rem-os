#!/bin/sh

docker container inspect roon-extension-manager > /dev/null 2>&1

if [ $? -eq 0 ]; then
    docker start roon-extension-manager
    docker attach roon-extension-manager
else
    DOCKER_GID=$(stat -c '%g' /var/run/docker.sock 2> /dev/null)
    TZ=$(timedatectl | sed -n 's/^\s*Time zone: \(.*\) (.*/\1/p')

    docker run --network host --name roon-extension-manager --group-add ${DOCKER_GID} -v /home/rem:/home/node/.rem/ -v /var/run/docker.sock:/var/run/docker.sock -e "TZ=${TZ}" --log-driver journald theappgineer/roon-extension-manager:v1.x

    if [ $? -ne 0 ]; then
        exit 1
    fi
fi

EXIT_CODE=$(docker container inspect roon-extension-manager --format='{{.State.ExitCode}}')

if [ $EXIT_CODE -eq 66 ]; then
    docker rm roon-extension-manager
fi
