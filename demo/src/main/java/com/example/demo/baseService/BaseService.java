package com.example.demo.baseService;

import com.example.demo.Util.Function;
import com.example.demo.baseModel.BaseModel;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.WildcardTypeName;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Set;

@Service
public class BaseService {

    ArrayList<BaseModel> baseModels =  new ArrayList <BaseModel>();

    public void entityGenerator(JSONObject jsonObject,String className) {

        ArrayList<TypeName> parameterTypes = new ArrayList <>();
        ArrayList<String> parameterNames = new ArrayList<String>();
        BaseModel model = new BaseModel();

        Set<String> keys = jsonObject.keySet();  // get the key values of JSON response
        model.setModelName(className);    // set the class name

        for(String key : keys){     // Iterate over JSON response

            Object valueOfKey = jsonObject.get(key);
            if(valueOfKey instanceof JSONObject) {   // check for a JSON object
                entityGenerator((JSONObject) valueOfKey,key);
            }
            else if(valueOfKey instanceof JSONArray) {  //// check for a JSON array
                JSONArray jsonArray = new JSONArray();
                jsonArray = (JSONArray) valueOfKey;
                entityGenerator((JSONObject) jsonArray.get(0),key);
            }

            parameterNames.add(key);
            parameterTypes.add(TypeName.get(valueOfKey.getClass()));
        }

        for(int i=0;i<parameterTypes.size();i++) {
            if(parameterTypes.get(i).toString().equals("java.lang.Integer")){
                parameterTypes.set(i,TypeName.INT);
            } else if(parameterTypes.get(i).toString().equals("org.json.JSONObject")) {
//                System.out.println(parameterNames.get(i)+" i "+ i);
                String modifiedClassName = Function.capitalizeFirstLetter(parameterNames.get(i));
                parameterTypes.set(i,ClassName.get("com.example.demo.model",modifiedClassName));                                              //String class type with capital
            }else if(parameterTypes.get(i).toString().equals("org.json.JSONArray")) {
                String modifiedClassName = Function.capitalizeFirstLetter(parameterNames.get(i));
                parameterTypes.set(i,ParameterizedTypeName.get(ClassName.get(ArrayList.class),ClassName.get("com.example.demo.model",modifiedClassName)));
            }
        }

//        System.out.println(parameterTypes);
        model.setParameterNames(parameterNames);   // add fieldsList to the model object
        model.setParameterTypes(parameterTypes);
        baseModels.add(model);    // add modelFormat objects to a list
    }

    public ArrayList<BaseModel> getModels(JSONObject jsonObject,String className) {
        entityGenerator(jsonObject,className);
        return baseModels;
    }


}















//public class BaseService {
//    public ArrayList<BaseModel> getModels(String outterModel, JSONObject body){
//        ArrayList<BaseModel> baseModels = new ArrayList<>();
//        BaseModel bm = new BaseModel();
//        bm.setModelName("StudentResponseModel");
//        ArrayList<Type> paramTypes = new ArrayList<>();
//        ArrayList<String> paramNames = new ArrayList<>();
//
//        paramTypes.add(Integer.TYPE);
//        paramTypes.add(String.class);
//        bm.setParameterTypes(paramTypes);
//        paramNames.add("age");
//        paramNames.add("name");
//        bm.setParameterNames(paramNames);
//
//        baseModels.add(bm);
//        return baseModels;
//
//
//    }
//}
