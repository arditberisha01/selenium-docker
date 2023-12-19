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
                sh "docker build -t=cosmotronica/runner ."
            }
        }

        stage('Push Image'){
                    steps{
                        sh "docker push cosmotronica/runner"
                    }
                }

    }

}