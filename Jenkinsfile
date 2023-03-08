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
//                     	sh """
//                              pwd
//                              cd /docker/volume/maven/apache-maven-3.9.0/project
//                              pwd
//                              docker rm -f $(docker ps -a | grep myjeninsboot | awk '{print $1}')
//                              docker rmi myjeninsboot:v1
//                              docker build -t myjeninsboot:v1 .
//                              docker images
//                           """
                        sh 'pwd'
                    }
                }
                stage('启动镜像') {
                    steps {
                        sh 'pwd'
                        sh 'docker run -d -p 3389:3389 --name myjeninsboot  myjeninsboot:v1'
                    }
                }
    }

}