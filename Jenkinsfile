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
          // sh "chown root:jenkins /run/docker.sock"
        script {
          dockerImage = docker.build dockerimagename
        }
      }
    }

     stage('Pushing Image') {

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
        stage('Apply Kubernetes files') {
        steps {
            script{
          withKubeConfig([credentialsId: 'minikube', serverUrl: 'https://192.168.64.22:8443']) {
                sh 'curl -LO "https://storage.googleapis.com/kubernetes-release/release/v1.27.1/bin/linux/amd64/kubectl"'  
                sh 'chmod u+x ./kubectl'  
                sh 'PATH=$PATH:$(pwd)'
                sh 'echo $PATH'
                sh 'kubectl apply -f hello.yaml -n springboot'
            }
         }
      }
    }
    //

    }
}     
   