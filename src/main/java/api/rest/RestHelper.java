package api.rest;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * Class contains simple templates for working with rest api by rest assured
 */
class RestHelper {

    String url;
    Map<String, String> cookies;
    Map<String, String> headers;
    ContentType contentDefaultEnum = ContentType.JSON;

    Response get(String path) {
        return buildRequestSpecification().
                when().
                get(path);
    }

    Response get(String path, RequestSpecBuilder spec) {
        return buildRequestSpecification(spec).
                when().
                get(path);
    }

    Response get(String path, Map<String, ?> params) {
        return buildRequestSpecification().
                queryParams(params).
                when().
                get(path);
    }

    Response post(String userName, String pass, String path, String body) {
        return buildRequestSpecification()
                .auth()
                .basic(userName, pass)
                .basePath(path)
                .body(body)
                .post();
    }

    Response post(String path, Object body) {
        return buildRequestSpecification().
                body(body).
                when().
                post(path);
    }

    Response post(String path) {
        return buildRequestSpecification().
                when().
                post(path);
    }

    Response postMultipart(String path, String filePath) {
        return buildRequestSpecification().
                multiPart(new File(filePath)).
                when().
                post(path);
    }

    Response postMultipart(String path, Map<String, String> formParams, String filePath) {
        return buildRequestSpecification().
                formParams(formParams).
                multiPart(new File(filePath)).
                when().
                post(path);
    }

    Response put(String path) {
        return buildRequestSpecification().
                when().
                put(path);
    }

    Response put(String path, Map<String, ?> params) {
        return buildRequestSpecification().
                queryParams(params).
                when().
                put(path);
    }

    Response put(String path, Object body) {
        return buildRequestSpecification().
                body(body).
                when().
                put(path);
    }

    Response delete(String path) {
        return buildRequestSpecification().
                when().
                delete(path);
    }

    Response delete(String path, Map<String, ?> params) {
        return buildRequestSpecification().
                queryParams(params).
                when().
                delete(path);
    }

    Response delete(String path, Object body) {
        return buildRequestSpecification().
                body(body).
                when().
                delete(path);
    }

    private RequestSpecification buildRequestSpecification(RequestSpecBuilder requestSpecBuilder) {
        return given(requestSpecBuilder.setBaseUri(url)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new AllureRestAssured())
                .build());
    }

    private RequestSpecification buildRequestSpecification() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setAccept(contentDefaultEnum).setContentType(contentDefaultEnum);
        if (cookies != null)
            requestSpecBuilder.addCookies(cookies);
        if (headers != null)
            requestSpecBuilder.addHeaders(headers);
        return buildRequestSpecification(requestSpecBuilder);
    }
}
