package spacex;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import io.cucumber.java.en.When;
import util.LogDemarker;
import util.PathConstants;
import util.ProjectPropertyUtil;
import util.RestBase;

public class LaunchStepDefinitions {

    private static final Logger logger = LogManager.getLogger(LaunchStepDefinitions.class);
    private RestBase restBase;

    public LaunchStepDefinitions(RestBase restBase) {
        this.restBase = restBase;
    }
    @When("Get the latest launch")
    public void getTheLatestLaunch() {
        logger.info(LogDemarker.stepDefBegining());
        logger.info("[Step]: Get the latest launch");
        restBase.get(ProjectPropertyUtil.getValue("spaceX.baseuri")+ PathConstants.LATEST_LAUNCH);
        logger.info(restBase.response.getBody().prettyPrint());
        logger.info(LogDemarker.stepDefEnding());
    }

    @When("Get the rocket details")
    public void getTheRocketDetails() {
        logger.info(LogDemarker.stepDefBegining());
        logger.info("[Step]: Get the rocket details");
        restBase.get(ProjectPropertyUtil.getValue("spaceX.baseuri")+PathConstants.ROCKETS);
        logger.info(restBase.response.getBody().prettyPrint());
        logger.info(LogDemarker.stepDefEnding());
    }

    @When("Get the core details")
    public void getTheCoreDetails() {
        logger.info(LogDemarker.stepDefBegining());
        logger.info("[Step]: Get the latest launch");
        restBase.get(ProjectPropertyUtil.getValue("spaceX.baseuri")+PathConstants.CORES);
        logger.info(restBase.response.getBody().prettyPrint());
        logger.info(LogDemarker.stepDefEnding());
    }
}
