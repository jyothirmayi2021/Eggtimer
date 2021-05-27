Build Project:
mvn clean install -Dskiptests

Run Project:
1. Tag the scenario you want to run with @test
2. Use command mvn test -Dcucumber.options="--tags @test" to run a scenario
