#!/bin/sh

set -e

IMAGE_NAME=renukafernando/train-service
VERSION=test

cd "$(dirname "$0")"
mvn clean package;
docker build -t $IMAGE_NAME:$VERSION .
