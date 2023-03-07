pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean'
            }
        }
        stage('package') {
            steps {
                sh 'mvn -DskipTests package'
            }
        }
        stage('install') {
            steps {
                sh 'mvn -DskipTests install'
            }
        }
        stage('启动服务') {
            steps {
                sh 'cd /var/jenkins_home/.m2/repository/com/example/jenkins/0.0.1-SNAPSHOT/'
                echo "pwd"
                sh 'nohup java -jar jenkins-0.0.1-SNAPSHOT.jar > info.log 2>&1 &'
            }
        }
    }

}