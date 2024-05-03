FROM bellsoft/liberica-openjdk-alpine:17.0.8

#install curl jq
RUN apk add curl jq
#create workspace
WORKDIR /home/selenium-docker
ADD target/docker-resources ./
ADD runner.sh runner.sh

#start the runner.sh
ENTRYPOINT sh runner.sh

#Environment variables
#BROWSER
#HUB_HOST
#TEST_SUITE
#THREAD_COUNT

#run the test
#ENTRYPOINT java -cp 'libs/*' \
#                -Dselenium.grid.enabled=true \
#                -Dselenium.grid.hubHost=${HUB_HOST} \
#                -Dbrowser=${BROWSER} \
#                org.testng.TestNG \
#                -threadcount ${THREAD_COUNT} \
#                test-suites/${TEST_SUITE}
