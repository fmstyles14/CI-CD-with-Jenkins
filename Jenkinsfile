def gv

pipeline {   
    agent any
    tools {
        maven 'maven-3.9.9'
    }
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                    gv.buildJar()

                }
            }
        }
         stage("auto build increment") {
                    steps {
                        script {
                            gv.buildAutoIncrement()

                        }
                    }
                }

        stage("build image") {
            steps {
                script {
                    gv.buildImage()
                }
            }
        }

        stage("deploy") {
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
        stage("commit version update") {
                    steps {
                        script {
                           withCredentials([usernamePassword(credentialsId: 'jenkinsCred', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                            sh 'git config --global user.email "jenkins@example.com" '
                            sh 'git config --global user.name "jenkins" '
                            sh 'git status'
                            sh 'git branch'
                            sh 'git config --list'


                            sh "git remote set-url origin https://${USER}:${PASS}github.com/fmstyles14/CI-CD-with-Jenkins.git"
                            sh 'git add .'
                            sh 'git commit -m "vi:version bump"'
                            sh ' git push origin HEAD:main'

                            }
                        }
                    }
                }
    }
} 
