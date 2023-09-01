pipeline {
    agent any
    stages {
        stage('Build Docker Image from Dockerfile') {
            steps {
                git branch: 'main', url: 'https://github.com/Vikas6409/dockpipe.git'
                script {
                    // Build the Docker image
                    sh 'docker build -t my-node-app .'
                    // sh "docker stop testapp || true"  // Stop existing container if exists
                    // sh "docker rm testapp || true"    // Remove existing container if exists
                }
            }
        }
}
