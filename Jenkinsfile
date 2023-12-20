pipeline{

    agent any

    stages{

        stage('Build Jar'){
            steps{
                sh "mvn clean package -DskipTests"
                echo "doing mvn package"
            }
        }

        stage('Build Docker Image'){
            steps{
                sh "docker build -t=cosmotronica/runner:latest ."
            }
        }

        stage('Push Image'){
                    environment{
                        DOCKER_HUB = credentials('dockerhub-creds')
                    }
                    steps{
                        sh 'echo ${DOCKER_HUB_PSW} | docker login -u ${DOCKER_HUB_USR} --password-stdin'
                        sh 'docker push cosmotronica/runner:latest'
                        sh "docker tag cosmotronica/runner:latest cosmotronica/runner:${env.BUILD_NUMBER}"
                        sh "docker push cosmotronica/runner:${env.BUILD_NUMBER}"
                    }
                }

    }
        post {
            always {
                sh "docker logout"
            }
        }
}