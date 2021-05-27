package util;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class RestBase {

    public RequestSpecification request = RestAssured.given();
    public Response response = null;
    public HashMap<String, String> sharedDataMap = new HashMap<>();

    // reset rest request
    public void resetRequest() {
        request = RestAssured.given();
    }

    // reset rest Response
    public void resetResponse() {
        response = null;
    }

    /*
     *** Sets ContentType*** We should set content type as JSON or XML before starting
     * the test
     */
    public void setContentType() {
        // sets content type in the request
        request.contentType(ContentType.JSON).accept(ContentType.JSON);
    }

    public void setBasicAuthentication(String userName, String password) {
        // Sets basic Authentication in the request
        request.auth().basic(userName, password);
    }

    public void setHeader(String headerName, String headerValue) {
        // Sets Header in the request
        request.header(headerName, headerValue);
    }

    public void get(String uri) {
        // get method
        response = request.get(uri);
    }

    public void post(String uri) {
        // post method
        response = request.post(uri);
    }

    public void delete(String uri) {
        // post method
        response = request.delete(uri);
    }

    public void patch(String uri) {
        // post method
        response = request.patch(uri);
    }

    public void put(String uri) {
        // put method
        response = request.put(uri);
    }

    public void resetSharedDataMap() {
        sharedDataMap = null;
    }


}
