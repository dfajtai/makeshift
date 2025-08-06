#!/bin/bash

# Load env vars form .env
set -o allexport
source ../.env
set +o allexport

# start maven
mvn clean install
