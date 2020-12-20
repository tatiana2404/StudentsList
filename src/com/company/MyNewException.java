package com.company;

public class MyNewException extends Exception{
    @Override
    public String getMessage(){
        return "Количество студентов привысило допустимое значение (10)";
    }
}
