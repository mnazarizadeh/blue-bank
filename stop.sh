#!/usr/bin/env bash

echo -e "\nStopping [Blue Bank] Application ....\n\
---------------------------------------\n"
for port in 8080 8081 8082
do
    echo "Stopping Service at port $port ...."
    curl -X POST localhost:${port}/api/actuator/shutdown
    echo -e "\nService at port ${port} stopped successfully .... \n"
done
read -r
echo -e "\nAll services stopped successfully ....\n\
---------------------------------------\n"