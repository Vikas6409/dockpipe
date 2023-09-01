pipeline {
    agent any
    stages {
        stage('Build Docker Image from Dockerfile') {
            steps {
                git branch: 'main', url: 'https://github.com/Vikas6409/dockpipe.git'
                script {
                    def dockerImage = docker.build(
                        context: '.',
                        dockerfile: 'Dockerfile',
                        additionalBuildArgs: '--build-arg KEY=VALUE',
                        tags: "app1:tag1"
                    )
                }
            }
        }
    }
}
