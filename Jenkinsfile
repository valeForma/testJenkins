pipeline {
    agent {
        docker {
        	echo 'starting docher'
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }
    options {
        skipStagesAfterUnstable()
    }
    stages {
        stage('Build') {
            steps {
            	echo 'building app'
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
            	echo 'running test'
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Deliver') { 
            steps {
            	echo 'delivering packet'
                sh './jenkins/scripts/deliver.sh' 
            }
        }
    }
}