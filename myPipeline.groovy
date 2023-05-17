pipeline {
  agent any

  stages {
    stage('Checkout') {
      steps {
        // GitHub 저장소에서 코드를 체크아웃합니다.
        git 'https://github.com/yourusername/yourrepository.git'
      }
    }

    stage('Build') {
      steps {
        // 빌드 명령어를 실행합니다.
        sh 'your-build-command'
      }
    }

    stage('Deploy') {
      steps {
        // AWS CodeDeploy 플러그인을 사용하여 배포합니다.
        awsCodeDeployPublisher(deploymentMethod: 'ec2', applicationName: 'your-application-name', deploymentGroupName: 'your-deployment-group-name', ignoreApplicationStopFailures: false)
      }
    }
  }
}
