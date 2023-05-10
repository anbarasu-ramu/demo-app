pipeline { 

    environment {
        dockerimagename = "anbarasu/hello-world"
        dockerImage = ""
    }


    agent any
    stages{
        stage('clone the repo'){
            steps{
               git 'https://github.com/anbarasu-ramu/demo-app.git'
               sh 'sh mvnw clean install'
            }
        }      
    

        stage('build'){
            steps{              
               sh 'sh mvnw clean install'
            }
        } 

        stage('Build image') {
      steps{
        // echo '${dockerimagename}'
        // sh 'docker build -t ${dockerimagename}:v2 .'
          sh "chown root:jenkins /run/docker.sock"
        script {
          dockerImage = docker.build dockerimagename
        }
      }
    }

    }
}     
   