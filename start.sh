#!/usr/bin/env bash

echo -e "\nStarting [Blue Bank] Application ....\n\
---------------------------------------\n"
cd customer-service/customer-mng
mvn spring-boot:start
cd ../..
cd account-service/account-mng
mvn spring-boot:start
cd ../..
cd transaction-service/transaction-mng
mvn spring-boot:start
echo -e "\nAll services are up and running ....\n\
---------------------------------------\n"