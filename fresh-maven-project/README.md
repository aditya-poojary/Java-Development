# database-connection

A tiny Maven Java project created automatically.

Quick commands (PowerShell on Windows):

```powershell
# from repository root
cd "d:\personal\React Projects\Java Development\database-connection"
# check maven
mvn -v
# compile & package (skip tests to speed up if desired)
mvn -q -DskipTests package
# run tests
mvn test
# run the app
mvn exec:java -Dexec.mainClass="com.example.App" -Dexec.args="World"
```

This project uses JUnit Jupiter for tests. The code is under `src/main/java` and tests under `src/test/java`.
