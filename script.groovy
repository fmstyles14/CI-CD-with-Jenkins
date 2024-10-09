def buildJar() {
    echo 'building the application...'
    sh 'mvn package'
}

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'jenkin-server-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t fmstyles/demo-app:jma-3.2 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push fmstyles/demo-app:jma-3.2'
    }
}

def deployApp() {
    echo 'deploying the application...'
}

return this
