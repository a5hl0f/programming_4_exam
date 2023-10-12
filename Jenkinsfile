
pipeline {
    agent any

    stages {
        stage('Git checkout') {
            steps {
               script{
                git 'https://github.com/a5hl0f/programming_4_exam'
               }
            }
        }
          stage('Build maven') {
            steps {
                script{
                    sh 'mvn clean package'
                }
            }
        }
        stage('unit Test maven') {
            steps {
                script{
                   sh 'mvn test'
                }
            }
        }
       
    }
}
