pipeline{
    agent any
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
         stage('SonarQube Analysis'){
            steps{
                 withCredentials([string(credentialsId: 'complete-cicd-02-token', variable: 'SONAR_TOKEN')]) {
                       withSonarQubeEnv('SonarQube') {
                                                sh """
						${SONAR_SCANNER_HOME}/bin/sonar-scanner \
						-Dsonar.projectKey=${SONAR_PROJECT_KEY} \
						-Dsonar.sources=. \
						-Dsonar.host.url=http://sonarqube:9000 \
						-Dsonar.login=${SONAR_TOKEN}
						"""
                                               }
                         }
                }
          }
      }
}




