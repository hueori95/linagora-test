    pipeline{
        agent any
        stages {
            stage('Build jar'){
                steps{
                    sh "mvn clean package -DskipTests"
                }
            }
            stage('Build Image'){
                steps{
                    sh "docker build -t=huent995/selenium:lastest ."
                }
            }
            stage('Push Image'){
                environment{
                    DOCKER_HUB = credentials('dockerhub-creds')
                }
                steps{
                    sh 'docker login -u ${DOCKER_HUB_USR} -p ${DOCKER_HUB_PSW}'
                    sh "docker push huent995/selenium:lastest"
                    sh "docker tag huent995/selenium:lastest huent995/selenium:${env.BUILD_NUMBER}"
                    sh "docker push huent995/selenium:${env.BUILD_NUMBER}"
                }
            }
        }
        post {
            always {
                sh "docker logout"
            }
        }
    }