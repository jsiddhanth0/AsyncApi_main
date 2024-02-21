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
                    sh 'sudo docker-compose build'
                    // sh 'sudo docker buildx build -t jsiddhanth0/asyncapi .'
                }
            }
        }
        stage("push image"){
            steps{
                script{
                    withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                        // sh 'sudo docker login -u jsiddhanth0 -p ${dockerhubpwd}'
                        sh 'sudo docker-compose push'
                    }
                    // sh 'sudo docker push jsiddhanth0/asyncapi '
                }
            }
        }
        stage("deploy"){
            steps{
                script{
                    sh 'sudo docker-compose up '
                    // sh "sudo docker run -d -p 5000:5000 jsiddhanth0/asyncapi"
                }
            }
        }
    }
}
// pipeline {
//     agent any

//     environment {
//         DOCKER_REGISTRY = "hub.docker.com" // Replace with your registry
//         DOCKER_IMAGE_NAME = "Async_api_sid"
//         APP_NAME = "demo12" // Replace with your application name
//         GIT_URL = "https://github.com/jsiddhanth0/AsyncApi_main.git"
//         GIT_CREDENTIALS_ID = "springdeploy-user"
//     }

//     stages {
//         stage('Checkout Code') {
//             steps {
//                 git branch: 'master', credentialsId: GIT_CREDENTIALS_ID, url: GIT_URL
//             }
//         }

//         stage('Build') {
//             steps {
//                 sh 'mvn clean package'
//             }
//         }

//         stage('Build image') {
//             steps {
//                 script {
//                     sh 'docker build -t ${DOCKER_IMAGE_NAME}:${BUILD_NUMBER}'
//                         // docker.build("${DOCKER_IMAGE_NAME}", "--build-arg JAR_FILE=target/${APP_NAME}.jar", ".")
//                      // docker.build("${DOCKER_REGISTRY}/${DOCKER_IMAGE_NAME}:${BUILD_NUMBER}", "--build-arg JAR_FILE=target/${APP_NAME}.jar", ".")

                    
//                     // dockerImage name: "${DOCKER_REGISTRY}/${DOCKER_IMAGE_NAME}:${BUILD_NUMBER}",
//                     //   dockerFile: 'DockerFile',
//                     //   buildArgs: ['JAR_FILE=target/${APP_NAME}.jar']
//                     //  docker.build(
//                     //   image: "${DOCKER_REGISTRY}/${DOCKER_IMAGE_NAME}:${BUILD_NUMBER}",
//                     //   context: '.',
//                     //   args: ['--build-arg', "JAR_FILE=target/${APP_NAME}.jar"]
//                     // )
                                   

//                 }
//             }
//         }

//         stage('Push image') {
//             steps {
//                 script {
//                     docker.withCredentials([username: 'your_docker_username', password: 'your_docker_password']) {
//                         docker.push("${DOCKER_REGISTRY}/${DOCKER_IMAGE_NAME}:${BUILD_NUMBER}")
//                     }
//                 }
//             }
//         }

//         stage('Deploy') {
//             steps {
//                 script {
//                     // Replace with your deployment command or script, considering container orchestration if needed
//                     sh "docker run -d -p 8080:8080 ${DOCKER_REGISTRY}/${DOCKER_IMAGE_NAME}:${BUILD_NUMBER}"
//                 }
//             }
//         }
//     }

//     post {
//         success {
//             cleanWs()
//         }
//     }
// }
// // node {
// //     def WORKSPACE = "/var/lib/jenkins/workspace/springboot-deploy"
// //     def dockerImageTag = "springboot-deploy${env.BUILD_NUMBER}"

// // try{
// //      notifyBuild('STARTED')
// //      stage('Clone Repo') {
// //         // for display purposes
// //         // Get some code from a GitHub repository
// //         git url: 'https://github.com/jsiddhanth0/AsyncApi_main.git',
// //             credentialsId: 'springdeploy-user',
// //             branch: 'main'
// //      }
// //       stage('Build docker') {
// //              dockerImage = docker.build("springboot-deploy:${env.BUILD_NUMBER}")
// //       }

// //       stage('Deploy docker'){
// //               echo "Docker Image Tag Name: ${dockerImageTag}"
// //               sh "docker stop springboot-deploy || true && docker rm springboot-deploy || true"
// //               sh "docker run --name springboot-deploy -d -p 8081:8081 springboot-deploy:${env.BUILD_NUMBER}"
// //       }
// // }catch(e){
// //     currentBuild.result = "FAILED"
// //     throw e
// // }finally{
// //     notifyBuild(currentBuild.result)
// //  }
// // }

// // def notifyBuild(String buildStatus = 'STARTED'){

// // // build status of null means successful
// //   buildStatus =  buildStatus ?: 'SUCCESSFUL'
// //   // Default values
// //   def colorName = 'RED'
// //   def colorCode = '#FF0000'
// //   def now = new Date()
// //   // message
// //   def subject = "${buildStatus}, Job: ${env.JOB_NAME} FRONTEND - Deployment Sequence: [${env.BUILD_NUMBER}] "
// //   def summary = "${subject} - Check On: (${env.BUILD_URL}) - Time: ${now}"
// //   def subject_email = "Spring boot Deployment"
// //   def details = """<p>${buildStatus} JOB </p>
// //     <p>Job: ${env.JOB_NAME} - Deployment Sequence: [${env.BUILD_NUMBER}] - Time: ${now}</p>
// //     <p>Check console output at "<a href="${env.BUILD_URL}">${env.JOB_NAME}</a>"</p>"""


// //   // Email notification
// //     emailext (
// //          to: "jsiddhanth1@gmail.com",
// //          subject: subject_email,
// //          body: details,
// //          recipientProviders: [[$class: 'DevelopersRecipientProvider']]
// //        )
// // }
