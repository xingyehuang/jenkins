pipeline {
	environment {
		WORKSPACE="/docker/volume/project"
		SERVER_NAME="jenkins"
		JARFILENAME="jenkinse*.jar"
	}
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
			    				sh """
                					pwd
                					cp target/${JARFILENAME} ${WORKSPACE}
                					cd ${WORKSPACE}
                					nohup java -jar jenkins-0.0.1-SNAPSHOT.jar > info.log 2>&1 &
                				"""
            }
        }
    }

}