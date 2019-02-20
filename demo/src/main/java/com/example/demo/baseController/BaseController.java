package com.example.demo.baseController;

import com.example.demo.baseModel.BaseInputModel;
import com.example.demo.baseModel.BaseModel;
import com.example.demo.baseService.BaseService;
import com.example.demo.baseService.ControllerBuilderService;
import com.example.demo.baseService.ModelBuilderService;
import com.example.demo.baseService.SwaggerBuilderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class BaseController {

    ControllerBuilderService controllerBuilderService = new ControllerBuilderService();
    ModelBuilderService modelBuilderService = new ModelBuilderService();
    SwaggerBuilderService swaggerConfig = new SwaggerBuilderService();

    @RequestMapping(value="/autogen",method= RequestMethod.POST,produces="application/json")
    public ResponseEntity<JSONObject> generate(@RequestBody BaseInputModel inputModel) {
//    public void generate() {
        //Input details
        String controllerName = inputModel.getApiName()+"Controller";
        String swaggerName = inputModel.getApiName();
        String outterResponseModelName = inputModel.getApiName()+"Response";
        System.out.println("..................");
        swaggerConfig.swaggerGenerator();

        try{
            ObjectMapper objectMapper = new ObjectMapper();
            BaseService baseService = new BaseService();

            if((inputModel.getMethod().equals("POST") || inputModel.getMethod().equals("PUT") || inputModel.getMethod().equals("DELETE")) && !inputModel.getRequestBody().isEmpty() ){
                String requestBodyStr = objectMapper.writeValueAsString(inputModel.getRequestBody());
                String responseBodyStr = objectMapper.writeValueAsString(inputModel.getResponseBody());
                JSONObject requestBody = new JSONObject(requestBodyStr);            // get requestBody as JSON object
                JSONObject responseBody = new JSONObject(responseBodyStr);          // get responseBody as JSON object

                String outterRequestModelName = inputModel.getApiName()+"Request";
                //Input request body details
                ArrayList<BaseModel> requestModels = baseService.getModels(requestBody,outterRequestModelName);
                ArrayList<BaseModel> responseModels = baseService.getModels(responseBody,outterResponseModelName);
                controllerBuilderService.generateController(swaggerName,controllerName,inputModel.getContext(),inputModel.getUrlInput(),inputModel.getMethod(),outterResponseModelName,outterRequestModelName);
                modelBuilderService.generateModels(requestModels);
                modelBuilderService.generateModels(responseModels);
            }else{
                String responseBodyStr = objectMapper.writeValueAsString(inputModel.getResponseBody());
                JSONObject responseBody = new JSONObject(responseBodyStr);
//                System.out.println(responseBody);

                //Output response body details
                ArrayList<BaseModel> responseModels = baseService.getModels(responseBody,outterResponseModelName);
                controllerBuilderService.generateController(swaggerName,controllerName,inputModel.getContext(),inputModel.getUrlInput(),inputModel.getMethod(),outterResponseModelName);
                modelBuilderService.generateModels(responseModels);
            }

            JSONObject res = new JSONObject();
            res.put("status","Success");

            return new ResponseEntity<JSONObject>(res, HttpStatus.OK);

        }catch (IOException ex){
            return null;
        }

    }




}
