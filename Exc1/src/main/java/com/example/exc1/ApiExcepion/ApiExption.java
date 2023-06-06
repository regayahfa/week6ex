package com.example.exc1.ApiExcepion;

public class ApiExption extends RuntimeException{
    public ApiExption (String massege){
        super(massege);
    }
}
