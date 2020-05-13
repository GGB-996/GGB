package com.example.demo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class Result {
    private Integer code;
    private String msg;
    private Map<String, Object> data = new HashMap<String, Object>();

    public static Result success() {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("успех");
        return result;
    }

    public static Result error() {
        Result result = new Result();
        result.setCode(500);
        result.setMsg("отказ");
        return result;
    }

    public Result add(String key,Object value){
        this.data.put(key,value);
        return this;
    }
}
