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
                    // sh 'ssh -o StrictHostKeyChecking=no ubuntu@52.63.49.96 "sudo rm -r /var/www/html/ironpulse/*"'
                    sh 'scp -o StrictHostKeyChecking=no -r * ubuntu@52.63.49.96:/home/ubuntu'
                    sh 'ssh -o StrictHostKeyChecking=no ubuntu@52.63.49.96 "sudo mv /home/ubuntu/* /var/www/html/ironpulse"'

                    }
            }
        }
    }        
}