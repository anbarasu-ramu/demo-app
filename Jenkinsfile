pipeline { 

    environment {
        dockerimagename = "anbarasu/hello-world"
        dockerImage = ""
    }


    agent any
    stages{
        stage('checkout'){
            steps{
               git 'https://github.com/anbarasu-ramu/demo-app.git'
               // sh 'sh mvnw clean install'
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
          // sh "chown root:jenkins /run/docker.sock"
        script {
          dockerImage = docker.build dockerimagename
        }
      }
    }

     stage('Upload Image') {

      environment {
               registryCredential = 'docker-hub-login'
           }
      steps{
        script {
          docker.withRegistry( 'https://registry.hub.docker.com', registryCredential ) {
            dockerImage.push("v1")
          }
        }
      }
    }

    //
        stage('Deploy') {
        steps {
            script{
          withKubeConfig([credentialsId: 'minikube', serverUrl: 'https://192.168.64.22:8443']) {
                sh 'whereis kubectl'
                sh 'kubectl apply -f deploy.yaml -n springboot'
            }
         }
      }
    }
    //helm deployment

     /*    stage('Helm Deployment') {
        steps {
         sh 'helm list'
      }
    } */

    }
}     
   
