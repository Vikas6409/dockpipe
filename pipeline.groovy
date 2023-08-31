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
                    dockerfile: '/Docker/Dockerfile',
                    additionalBuildArgs: '--build-arg KEY=VALUE',
                    tags: "repository_name:tag"
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
                    sh "docker stop testapp || true"
                    sh "docker rm testapp || true"

                    sh "docker run -d -p 8080:80 --name testapp testapp:${env.BUILD_ID}" // Use --name to specify container name
                    }
                }
            }
      }
}
