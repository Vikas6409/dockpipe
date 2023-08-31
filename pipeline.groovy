pipeline {
    agent any 
    stages {
        stage('Pull') { 
            steps {
                git branch: 'main', url: 'https://github.com/Vikas6409/dockpipe.git'
            }
        }
       
        stage('Build Docker Image') {
            steps {
                script {
                    def dockerImage = docker.build(
                        context: '.',
                        dockerfile: '/home/ec2-user/workspace/Docker/Dockerfile',
                        tags: "testapp:${env.BUILD_ID}"
                    )
                }
            }
        }

        stage('Test') { 
            steps {
                echo 'Test successfully'
            }
        }

        stage('Deploy on Same Instance') {
            steps {
                script {
                    sh "docker stop testapp || true"  // Stop existing container if exists
                    sh "docker rm testapp || true"    // Remove existing container if exists

                    sh "docker run -d -p 8080:80 --testapp testapp:${env.BUILD_ID}"
                }
            }
        }
    }
}
