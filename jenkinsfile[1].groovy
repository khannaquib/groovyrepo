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
                    sh 'ssh -o StrictHostKeyChecking=no ubuntu@3.25.227.47 "ls"'
                    }
            }
        }
    }        
}