@Library('my-shared-library') _
pipeline {
    agent any

    stages {
        stage('Git checkout') {
            steps {
               gitCheckout(
                branch: "master",
                url: "https://github.com/a5hl0f/programming_4_exam"
               )
            }
        }
        stage('unit Test maven ') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
