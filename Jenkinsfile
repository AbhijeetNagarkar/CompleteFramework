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
        
      stage('Git commit') { 
        steps {
            sh('''
                git branch
                git config user.email devops@truckx.com
                git config user.name devops-truckx
                git add 'ExcelOutput/loadingtime.xlsx' 
                git commit -m 'Loading time update after build success from jenkins'
            ''')
        }
      }

      stage('Git push') {
        environment {
          GIT_AUTH = credentials('jenkins-github-devops-pat')
        }
        steps {
            sh('''
                git config --local credential.helper "!f() { echo username=\\$GIT_AUTH_USR; echo password=\\$GIT_AUTH_PSW; }; f"
                git push origin HEAD:main
            ''')
        }
        
      }
    }
  }