pipeline {
    agent { label 'linux-slave1' }
    
    tools { 
        maven 'maven'
    }
  
    stages {
        
      stage('Test run') {
        steps {
          sh '''
             mvn -version
             mvn clean install
          '''
        }
      }
        
    }
    
  }
