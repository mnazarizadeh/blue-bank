#!/usr/bin/env bash

echo -e "\nStarting [Blue Bank] Application ....\n\
---------------------------------------\n"
cd customer-service/customer-mng
mvn spring-boot:stop
cd ../..
cd account-service/account-mng
mvn spring-boot:stop
cd ../..
cd transaction-service/transaction-mng
mvn spring-boot:stop
echo -e "\nAll services stopped successfully ....\n\
---------------------------------------\n"