cd ../server
mvn javadoc:javadoc
mvn verify
mvn package
cd ../scripts
pause