pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('package') {
            steps {
                sh 'mvn -DskipTests package'
            }
        }
    }

}