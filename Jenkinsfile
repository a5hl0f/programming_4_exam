
pipeline {
    agent any

    stages {
        stage('Git checkout') {
            steps {
              
                git 'https://github.com/a5hl0f/programming_4_exam'
               
            }
        }
          stage('Build maven') {
            steps {
              
                    sh 'mvn clean package'
                
            }
        }
        stage('unit Test maven') {
            steps {
             
                   sh 'mvn test'
                
            }
        }
       
    }
}
