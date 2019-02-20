package com.example.demo.baseModel;

import org.json.JSONObject;

import java.util.HashMap;

public class BaseInputModel {
    String apiName;
    String context;
    String urlInput;
    String method;
    HashMap requestBody;
    HashMap responseBody;

    public String getApiName() {
        return apiName;
    }

    public String getContext() {
        return context;
    }

    public String getUrlInput() {
        return urlInput;
    }

    public String getMethod() {
        return method;
    }

    public HashMap getRequestBody() {
        return requestBody;
    }

    public HashMap getResponseBody() {
        return responseBody;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void setUrlInput(String urlInput) {
        this.urlInput = urlInput;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setRequestBody(HashMap requestBody) {
        this.requestBody = requestBody;
    }

    public void setResponseBody(HashMap responseBody) {
        this.responseBody = responseBody;
    }

    public BaseInputModel() {
    }

    public BaseInputModel(String apiName, String context, String urlInput, String method, HashMap requestBody, HashMap responseBody) {
        this.apiName = apiName;
        this.context = context;
        this.urlInput = urlInput;
        this.method = method;
        this.requestBody = requestBody;
        this.responseBody = responseBody;
    }
}
