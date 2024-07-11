pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Clona o código fonte do repositório
                git 'https://github.com/vanessaunicamp/INF335-Trab5'
            }
        }
        stage('Build') {
            steps {
                // Compila o projeto Maven
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                // Executa os testes JUnit
                sh 'mvn test'
            }
        }
        stage('Package') {
            steps {
                // Empacota o projeto em um arquivo .jar
                sh 'mvn package'
            }
        }
    }

    post {
        always {
            // Arquiva os artefatos gerados (arquivos .jar)
            archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
        }
        success {
            echo 'Build succeeded!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
