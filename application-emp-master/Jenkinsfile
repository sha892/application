pipeline {
    agent any
     environment {
    COSIGN_PASSWORD=credentials('cosign-password')
    COSIGN_PRIVATE_KEY=credentials('cosign-private-key')
    COSIGN_PUBLIC_KEY=credentials('cosign-public-key')

  }

    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'github-token', url: 'https://github.com/7shivam/application-emp.git']]])
            }
        }
        stage('mvn Build') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('docker image Build') {
            steps {
                sh 'docker build -t ghcr.io/7shivam/application-emp:$BUILD_NUMBER .'
            }
        }
        stage('Login to github') {
            steps {
                sh 'docker login ghcr.io -u 7shivam -p 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'
            }
        }
        stage('push image to github') {
            steps {
                sh 'docker push ghcr.io/7shivam/application-emp:$BUILD_NUMBER'
            }
        }
        stage('sign the github image') {
            steps {
                sh 'cosign version'
                sh 'cosign sign --key $COSIGN_PRIVATE_KEY ghcr.io/7shivam/application-emp:$BUILD_NUMBER'
            }
        }
        stage('verify the github image') {
            steps {
                sh 'cosign version'
                sh 'cosign verify --key $COSIGN_PUBLIC_KEY ghcr.io/7shivam/application-emp:$BUILD_NUMBER'
            }
        }
        
    }
}
