#!/usr/bin/env bash

echo -e "\nStarting [Blue Bank] Application ....\n\
---------------------------------------\n"
function runService(){
  mvn spring-boot:run -f "$1"
}

for dir in $(find  ./*-service/*-mng -maxdepth 0 -type d)
do
    echo -e "Starting [${dir}] application.... Done \n" && \
    runService "$dir" &
done
read -r
echo -e "\nAll services are up and running ....\n\
---------------------------------------\n"