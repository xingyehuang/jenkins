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
        stage('启动服务') {
            steps {
                sh 'cd /var/lib/docker/volumes/jenkins_home/_data/workspace/myJenkins/target'
                echo "pwd"
                sh 'nohup java -jar jenkins-0.0.1-SNAPSHOT.jar > info.log 2>&1 &'
            }
        }
    }

}