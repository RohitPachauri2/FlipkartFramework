pipeline {
    agent any

    environment {
        DOCKER_COMPOSE_VERSION = '1.29.2' // optional: pin docker-compose version
    }

    stages {
        stage('Checkout from GitHub') {
            steps {
                git branch: 'main', url: 'https://github.com/jstestingacademy/flipkartnew.git'
            }
        }

        stage('Build with Docker Compose') {
            steps {
                sh 'docker-compose down || true'
                sh 'docker-compose up --build -d'
            }
        }

        stage('Run Tests') {
            steps {
                // If your container runs tests automatically, just wait for logs
                sh 'docker-compose logs --follow'
                // OR if you need to run a specific command inside the container:
                // sh 'docker exec flipkart-automation-container java -jar app.jar'
            }
        }

        stage('Clean Up') {
            steps {
                sh 'docker-compose down'
            }
        }
    }

    post {
        always {
            echo 'Cleaning up workspace'
            cleanWs()
        }
    }
}
