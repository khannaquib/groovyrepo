pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                // Fetch the repository using SSH credentials
                git branch: 'main', url: 'https://github.com/khannaquib/ironpulse'
            }
        }
        stage('testing'){
            steps{
                sshagent(['nginx-server']) {
                    sh 'ssh -o StrictHostKeyChecking=no ubuntu@3.26.184.93 "sudo rm -r /var/www/html/ironpulse"'
                    sh 'scp -o strictHostKeyCheckin=no -r *ubuntu@3.26.184.93:/home/ubuntu'
                    sh 'ssh -o StrictHostKeyChecking=no ubuntu@3.26.184.93 "pwd"'
                    }
            }
        }
    }        
}