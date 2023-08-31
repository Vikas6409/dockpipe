pipeline {
    agent any 
    stages {
        stage('Pull') { 
            steps {
                git branch: 'master', url: 'https://github.com/rajatpzade/studentapp.ui.git'
            }
        }
        stage('Build') { 
            steps {
              sh '/opt/apache-maven/bin/mvn clean package'
            }
        }
        stage('Test') { 
            steps {
                echo 'Test successfully'
            }
        }
        stage('Deploy') { 
            steps {
                echo 'yahoo  Deploy successfully'
            }
        }
    }
}
