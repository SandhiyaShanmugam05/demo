
pipeline {
	agent any
	environment {
		
		mavenHome = tool 'jenkins-maven'
	}
	tools {
		jdk 'java-17'
	}
	stages {
		stage('Show Workspace') {
            steps {
                script {
                    echo "The workspace directory is: ${env.WORKSPACE}"
                }
            }
        }
		stage('Build'){
			steps {
				// bat "mvn clean install -DskipTests"
				bat "${mavenHome}/bin/mvn clean install -DskipTests"
			}
		}
		stage('Test'){
			steps{
				bat "mvn test"
			}
		}
		stage('Deploy') {
			steps {
			    bat "mvn jar:jar deploy:deploy"
			}
		}
	}
}