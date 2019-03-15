cd ../server
mvn clean install
mvn exec:java -Dexec.mainClass=com.gameofelte.server.Program
pause