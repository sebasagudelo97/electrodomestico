pipeline {
  //Donde se va a ejecutar el Pipeline
  agent {
    label 'Slave_Induccion'
  }

  //Opciones específicas de Pipeline dentro del Pipeline
  options {
    	buildDiscarder(logRotator(numToKeepStr: '3'))
 	disableConcurrentBuilds()
  }

  //Una sección que define las herramientas “preinstaladas” en Jenkins
  tools {
    jdk 'JDK11_Centos' //Preinstalada en la Configuración del Master
    gradle 'Gradle5.6_Centos' //Preinstalada en la Configuración del Master
  }

  //Aquí comienzan los “items” del Pipeline
  stages{
        stage('Checkout') {
              steps{
                    echo "------------>Checkout<------------"
                    checkout([
                        $class: 'GitSCM',
                        branches: [[name: '*/master']],
                        doGenerateSubmoduleConfigurations: false,
                        extensions: [],
                        gitTool: 'Default',
                        submoduleCfg: [],
                        userRemoteConfigs: [[
                            credentialsId: 'GitHub_sebasagudelo97',
                            url:'https://github.com/sebasagudelo97/electrodomestico'
                        ]]
                    ])

             }
        }
	

	stage("Install dependecias"){
		steps{
			dir("TallerElectrodomestico-cliente"){
				sh "npm ci"
			}
		}
	}
	
	stage("Construis front"){
		steps{
			dir("TallerElectrodomestico-cliente"){
				sh "npm run build"
			}
		}
	}
        stage('Compile & Unit Tests Backend') {
              steps{

                 echo "------------>Cleaning previous compilations<------------"
		dir("TallerElectrodomestico-servidor"){ 
                 sh 'gradle --b ./build.gradle clean'

                 echo "------------>Unit Tests<------------"
                 sh 'gradle --b ./build.gradle test jacocoTestReport'
		}
             }
        }
	
	stage('Unit test Frontend'){
		steps{
			dir("TallerElectrodomestico-cliente"){
				sh "npm run test"
			}
		}
	}
	stage('End to end Frontend'){
		steps{
			dir("TallerElectrodomestico-cliente"){
				sh "npm run e2e"
			}
		}
	}
        stage('Static Code Analysis') {
      		steps {
        	echo '------------>Análisis de código estático<------------'
        	withSonarQubeEnv('Sonar') {
          	sh "${tool name: 'SonarScanner',type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner"
          	// sh 'gradle sonarqube'
        	}
      	   }
    	}
        stage('Build') {
              steps {
                    echo "------------>Build<------------"
		dir("TallerElectrodomestico-servidor"){ 
                    //Construir sin tarea test que se ejecutó previamente
                    sh 'gradle --b ./build.gradle build -x test'
		}
              }
        }
  }

  post {
        always {
            echo 'This will always run'
        }
        success {
            echo 'This will run only if successful'
        }
        failure {
            echo 'This will run only if failed'

        }
        unstable {
            echo 'This will run only if the run was marked as unstable'
        }
        changed {
            echo 'This will run only if the state of the Pipeline has changed'
            echo 'For example, if the Pipeline was previously failing but is now successful'
        }
  }
}