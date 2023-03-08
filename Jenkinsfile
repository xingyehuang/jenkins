pipeline {
	environment {
		WORKSPACE="/docker/volume/maven/apache-maven-3.9.0/project"
		SERVER_NAME="jenkins"
		JARFILENAME="jenkins-0.0.1-SNAPSHOT.jar"
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
                					rm -rf ${WORKSPACE}/${JARFILENAME}
                					cp target/${JARFILENAME} ${WORKSPACE}
                					cd ${WORKSPACE}
                					nohup java -jar jenkins-0.0.1-SNAPSHOT.jar > info.log 2>&1 &
                				"""
            }
        }
    }

}