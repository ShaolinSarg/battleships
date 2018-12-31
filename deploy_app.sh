#!/bin/bash
docker pull shaolinsarg/battleships:latest
docker stop battleships
docker rm battleships

docker run -d -p3000:3000 -e BATTLESHIP_TOKEN=555 --name battleships shaolinsarg/battleships:latest
