
pipeline {
    agent any

    environment {
        // mavenHome = tool name: 'jenkins-maven', type: 'Maven'
         MAVEN_HOME = 'C:/Users/ssandhiya/Downloads/apache-maven-3.9.9-bin/apache-maven-3.9.9' 
    }

    tools {
        jdk 'java-17'  // Ensure the JDK is properly installed in Jenkins
    }

    stages {

        stage('Build'){
            steps {
                // Use Maven tool by referencing the correct 'mavenHome' environment variable
                bat "'${mavenHome}\\bin\\mvn' clean install -DskipTests"
            }
        }

        stage('Test'){
            steps {
                bat "'${mavenHome}\\bin\\mvn' test"
            }
        }

        stage('Deploy') {
            steps {
                bat "'${mavenHome}\\bin\\mvn' jar:jar deploy:deploy"
            }
        }
    }
}
