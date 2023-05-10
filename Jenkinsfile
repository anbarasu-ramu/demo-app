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
    }
}     
   