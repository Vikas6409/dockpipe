pipeline {
    agent any
    stages {
        stage('Build Docker Image from Dockerfile') {
            steps {
                git branch: 'main', url: 'https://github.com/Vikas6409/dockpipe.git'
                script {
                    // Use the sh step to run shell commands
                    sh 'docker build -t my-node-app .'
                }
            }
        }
    }
}
