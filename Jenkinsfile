pipeline {
    agent any
    stages {
        stage('checkout code'){
            steps {
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/jsiddhanth0/AsyncApi_main.git']])
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage("build image"){
            steps{
                script{
                    sh 'sudo docker-compose build '
                    // sh 'sudo docker buildx build -t jsiddhanth0/asyncapi .'
                }
            }
        }
        stage("push image"){
            steps{
                script{
                    withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                        sh 'sudo docker login -u jsiddhanth0 -p ${dockerhubpwd}'
                        sh 'sudo docker-compose push'
                    }
                    // sh 'sudo docker push jsiddhanth0/asyncapi '
                }
            }
        }
        // stage("deploy"){
        //     steps{
        //         script{
        //             sh 'sudo docker-compose up '
        //             // sh "sudo docker run -d -p 5000:5000 jsiddhanth0/asyncapi"
        //         }
        //     }
        // }
    }
}

