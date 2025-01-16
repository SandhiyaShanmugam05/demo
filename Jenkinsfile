pipeline {
    agent any

    environment {
        MAVEN_HOME = 'C:\\Users\\ssandhiya\\Downloads\\apache-maven-3.9.9-bin\\apache-maven-3.9.9'  // Manually set MAVEN_HOME if needed
    }

    tools {
        jdk 'java-17'  // Ensure JDK is properly configured in Jenkins
        maven 'jenkins-maven'  // Reference the tool 'jenkins-maven' as configured in Jenkins (configured in Global Tool Configuration)
    }

    stages {
        stage('Build') {
            steps {
                // Use Maven tool by referencing the 'maven' tool configured in Jenkins
                bat "'${tool name: 'jenkins-maven', type: 'Maven'}\\bin\\mvn' clean install -DskipTests"
            }
        }

        stage('Test') {
            steps {
                bat "'${tool name: 'jenkins-maven', type: 'Maven'}\\bin\\mvn' test"
            }
        }

        stage('Deploy') {
            steps {
                bat "'${tool name: 'jenkins-maven', type: 'Maven'}\\bin\\mvn' deploy"
            }
        }
    }
}
