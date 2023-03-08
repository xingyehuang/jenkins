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
//                 stage('打包镜像') {
//                     steps {
//                         sh 'pwd'
//                         sh 'cd ${WORKSPACE} && sh start03.sh'
//                         sh 'pwd'
//                     }
//                 }
                stage('打包镜像') {
                    steps {
                        sh 'pwd'
                        sh 'cd ${WORKSPACE}'
                        sh 'ls'
                        sh 'sh build.sh'
                    }
                }
                stage('启动镜像') {
                    steps {
                        sh 'docker run -d -p 3389:3389 --name myjeninsboot  myjeninsboot:v1'
                    }
                }
    }

}