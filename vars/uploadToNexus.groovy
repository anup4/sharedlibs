def call(nexusRepo) {
   def pom = readMavenPom file: 'pom.xml'
   def repo = nexusRepo //pom.version.endswith('SNAPSHOT') ? "my-app-snapshot" : "my-app-release"
   def artifactid = pom.artifactid
   def groupid = pom.groupid
   nexusArtifactUploader artifacts: [[artifactId: artifactid , classifier: '', file: 'target/${artifactid}-${pom.version}.war', type: 'war']], 
   credentialsId: 'AJ', 
   groupId: groupid, 
   nexusUrl: '172.31.43.180:8082', 
   nexusVersion: 'nexus2', 
   protocol: 'http', 
   repository: repo, 
   version: pom.version
}
