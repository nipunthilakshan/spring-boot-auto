package com.example.demo.baseModel;


import com.squareup.javapoet.TypeName;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class BaseModel {
    private String modelName;
    private ArrayList<TypeName> parameterTypes;
    private ArrayList<String> parameterNames;

    public String getModelName() {
        return modelName;
    }

    public ArrayList<TypeName> getParameterTypes() {
        return parameterTypes;
    }

    public ArrayList<String> getParameterNames() {
        return parameterNames;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setParameterTypes(ArrayList<TypeName> parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public void setParameterNames(ArrayList<String> parameterNames) {
        this.parameterNames = parameterNames;
    }

    public BaseModel() {
    }

    public BaseModel(String className, ArrayList<TypeName> parameterTypes, ArrayList<String> parameterNames) {
        this.modelName = modelName;
        this.parameterTypes = parameterTypes;
        this.parameterNames = parameterNames;
    }
}
