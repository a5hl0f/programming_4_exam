@Library('my-shared-library') _
pipeline {
    agent any

    stages {
        stage('Git checkout') {
            steps {
                script{
               gitCheckout()
                }
            }
        }
        stage('unit Test maven ') {
            steps {
                script{
                    mvnTest()
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
