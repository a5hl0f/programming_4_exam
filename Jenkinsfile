pipeline {
    agent any

    stages {
        stage('Git checkout') {
            steps {
                git 'https://github.com/a5hl0f/programming_4_exam'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
