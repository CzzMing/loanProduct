package com.buba.service;

import java.util.Random;

public class TestClass {
    public static void main(String[] args) {
//        String code = "";
//        Random ran = new Random();
//        for (int i=0;i<6;i++){
//            code = code + ran.nextInt(10);
//        }
//        System.out.println("code"+code);

        String phone="13589642569";
        phone = phone.substring(0,3)+"****"+phone.substring(7,11);
        System.out.println("手机号码"+phone);
    }

}
