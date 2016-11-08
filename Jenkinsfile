node {
    stage('SCM') {
        git 'https://github.com/nonetheless/guide.git'
    }
    stage('QA') {
       def scannerHome = tool 'SonarQube Scanner 2.8'
       sh "${scannerHome}/bin/sonar-scanner" 
    }
    stage('build') {
        def mvnHome = tool 'M3'
        sh "${mvnHome}/bin/mvn -f ./homework/pom.xml -B clean package "
    }
    stage('deploy') {
        sh "docker stop my || true"
        sh "docker rm my || true"
        sh "docker run --name my -p 11111:8080 -d tomcat"
        sh "docker cp homework/target/homework.war my:/usr/local/tomcat/webapps"
    }
    stage('results') {
        archiveArtifacts artifacts: '**/target/*.war', fingerprint: true
    }
}
