#!/usr/bin/env groovy

@Library('piper-lib') _
@Library('piper-lib-os') __
import com.sap.icd.jenkins.Utils
import groovy.transform.Field

env.REPOSITORY_UNDER_TEST = "hubadr/jenkins-library"
env.LIBRARY_VERSION_UNDER_TEST = "cxone-dev-michael"

//sapPiperPipeline script: this


timeout(65535){
node {
    stage('Init') {
        node {
            deleteDir()
  	  	    checkout scm
   	  	    setupPipelineEnvironment script: this
        }
    }
    stage('CheckmarxOne') {
        node {
            try {
                echo "Invoke CheckmarxOne scan step"
                durationMeasure(script: this, measurementName: 'checkmarxone_duration') {
                    checkmarxOneExecuteScan script: this
                }
            }
            finally {
                //sapCumulusUpload script: this, filePattern: '**/Cx1_SASTReport_*.pdf, **/*Cx1_SAST*.html, **/ScanReport.*, **/toolrun_checkmarx_*.json, **/piper_checkmarx_report.json, **/*.sarif', stepResultType: 'checkmarxone'
            }
        }
    }
}
}
