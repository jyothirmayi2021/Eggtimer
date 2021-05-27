package spacex;

import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import util.LogDemarker;
import util.RestBase;

public class GlobalStepDefinitions {

    private static final Logger logger = LogManager.getLogger(GlobalStepDefinitions.class);
    private RestBase restBase;

    public GlobalStepDefinitions(RestBase restBase) {
        this.restBase = restBase;
    }

    @And("Set Path Variable")
    public void setPathVariable(DataTable dataTable) {
        // Set path variables
        logger.info(LogDemarker.stepDefBegining());
        logger.info("[Step]: set the path variables");
        Map<String, String> parameters = dataTable.asMap(String.class, String.class);
        for (Map.Entry<String, String> parametersMap : parameters.entrySet()) {
            restBase.request.pathParam(parametersMap.getKey(), parametersMap.getValue());
            logger.info("Path variable Key: " + parametersMap.getKey() + " and Value: " + parametersMap.getValue());
        }
        logger.info(LogDemarker.stepDefEnding());
    }

    @Then("Verify status code is {string}")
    public void verifyStatusCodeIs(String statusCode) {
        logger.info(LogDemarker.stepDefBegining());
        logger.info("[Step]: Verify status code is" + statusCode);
        logger.info(restBase.response.getStatusCode());
        Assert.assertEquals(Integer.parseInt(statusCode), restBase.response.getStatusCode());
        logger.info(LogDemarker.stepDefEnding());
    }

    @And("Verify REST response for below values")
    public void andVerifyRESTResponseForBelowValues(DataTable dataTable) {
        // Assert on the Response attributes
        logger.info(LogDemarker.stepDefBegining());
        logger.info("[Step]: Verify REST response for below values");
        JsonPath jsonPathEvaluator = restBase.response.jsonPath();
        Map<String, String> pathValue = dataTable.asMap(String.class, String.class);
        for (Map.Entry<String, String> pathValueMap : pathValue.entrySet()) {
            Object value = jsonPathEvaluator.get(pathValueMap.getKey());
            logger.info("Expected " + pathValueMap.getKey() + " value is: " + pathValueMap.getValue());
            Assert.assertEquals(pathValueMap.getValue(), String.valueOf(value));
        }
        logger.info(LogDemarker.stepDefEnding());
    }
}
