@Library('my-shared-library') _
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
        stage('unit Test maven') {
            steps {
                script{
                    mvnTest()
                }
            }
        }
         stage('Build maven') {
            steps {
                script{
                    buildmvn()
                }
            }
        }
        stage('Docker image build ') {
            steps {
                script{
                    buildDockerImage()
                }
            }
        }
       
    }
}
