FROM bellsoft/liberica-openjdk-alpine:17.0.8

# install curl jq
RUN apk add curl jq

# create workspace
WORKDIR /home/selenium-docker

# add the required files to run the tests

ADD target/docker-resources ./
ADD runner.sh runner.sh

# environment variables
# BROWSER
# HUB_HOST
# TEST_SUITE
# THREAD_COUNT

# run the tests(start the runner.sh
ENTRYPOINT sh runner.sh


