pipeline {
    agent {
        docker {
            image 'maven:3.8.5'
            args '-v /root/.m2:/root/.m2'
        }
    }
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