pipeline {
	agent {
		docker {
		    image 'maven:3-alpine' 
            args '-v /root/.m2:/root/.m2' 
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
				sh 'mvn compile'
			}
		}
		stage('Test') {
			steps {
				sh 'mvn test'
			}
		}
		stage('Package') {
			steps {
				sh 'mvn package'
			}
		}
	}

}