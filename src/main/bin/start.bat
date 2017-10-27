java -jar jetty-runner-${jetty.version}.jar --log log/timing_yyyy_mm_dd.log^
 --out log/app_yyyy_mm_dd.log --port ${jetty.port} --classes configuration^
 ${artifactId}-${version}.war
