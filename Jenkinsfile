pipeline{
    agent any
    tools {
        maven 'Maven' // use the configured Maven version
    }
    environment {
		SONAR_PROJECT_KEY = 'complete-cicd-02'
		SONAR_SCANNER_HOME = tool 'SonarQubeScanner'
	}
     stages{
         stage('GitHub'){
            steps{
                git credentialsId: 'Jinkin-git-dind', url: 'https://github.com/Ashutosh-kumar240/repository.git' 
             }
          }
          stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }   
          stage('SonarQube Analysis'){
            steps{
                 withCredentials([string(credentialsId: 'complete-cicd-02-token', variable: 'SONAR_TOKEN')]) {
                       withSonarQubeEnv('SonarQube') {
                                                sh """
						/var/jenkins_home/tools/hudson.plugins.sonar.SonarRunnerInstallation/SonarQubeScanner/bin/sonar-scanner \
						-Dsonar.projectKey=${SONAR_PROJECT_KEY} \
						-Dsonar.sources=. \
						-Dsonar.java.binaries=target/classes \
						-Dsonar.login=${SONAR_TOKEN}
						"""
                                               }
                         }
                }
          }
      }
}




