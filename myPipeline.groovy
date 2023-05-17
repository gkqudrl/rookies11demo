pipeline {
  agent any

  stages {
    stage('Checkout') {
      steps {
        // GitHub 저장소에서 코드를 체크아웃합니다.
        git 'https://github.com/gkqudrl/rookies11demo.git'
      }
    }

    stage('Build') {
      steps {
        // Maven을 사용하여 프로젝트 빌드 및 패키지 생성
        sh 'mvn clean package'
      }
    }

    stage('Deploy') {
      steps {
        // AWS CodeDeploy 플러그인을 사용하여 배포합니다.
        awsCodeDeployPublisher(deploymentMethod: 'ec2', applicationName: 'jenkinsDeploy', deploymentGroupName: 'jenkinsDepG', ignoreApplicationStopFailures: false)
      }
    }
  }
}
