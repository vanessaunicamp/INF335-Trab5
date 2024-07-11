pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Clona o código fonte do repositório
                git 'https://github.com/seu-usuario/seu-repositorio.git'
            }
        }
        stage('Build') {
            steps {
                // Compila o projeto Maven
                bat 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                // Executa os testes JUnit
                bat 'mvn test'
            }
        }
        stage('Package') {
            steps {
                // Empacota o projeto em um arquivo .jar
                bat 'mvn package'
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
