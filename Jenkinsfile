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
       
