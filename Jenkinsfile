pipeline {
	agent {
		docker {
		    image 'maven:3.6.1-jdk-12' 
            args '-v /home/.m2:/root/.m2 -u root' 
		}
	}
	stages {
	    stage('Prepare') {
			steps {
				sh 'mvn clean'
			}	
		}
		stage('Build') {
			steps {
				sh 'mvn -B -DskipTests clean package'
			}
		}
		stage('Test') {
			steps {
				sh 'mvn test'
			}
			post {
                always {
                    junit 'target/surefire-reports/*.xml' 
                }
            }
		}
	}
	post {
		success {
			archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
		}
	}
}