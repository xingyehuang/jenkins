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
        stage('install') {
            steps {
                sh 'mvn -DskipTests install'
            }
        }
        stage('拷贝目录到启动目录') {
            steps {
			    				sh """
                					pwd
                					rm -rf ${WORKSPACE}/${JARFILENAME}
                					cp target/${JARFILENAME} ${WORKSPACE}
                					cd ${WORKSPACE}
                				"""
            }
        }
                stage('启动服务') {
                    steps {
                        sh 'BUILD_ID=donKillMe'
                        sh 'nohup java -jar jenkins-x.0.1-SNAPSHOT.jar >> jenkins.log 2>&1 &'
                    }
                }
    }

}