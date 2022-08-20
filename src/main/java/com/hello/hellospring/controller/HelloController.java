package com.hello.hellospring.controller;

import com.hello.hellospring.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
public class HelloController {


    @GetMapping("hello")
    public String hello(Model model){
        // servlet request serverside rendering
        // model
        // viewResolver beanNameResolver
        model.addAttribute("data","hello");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

//  @ResponseBody : body에 String을 직접 넣어주겠다.
    @GetMapping("hello-string")
    @ResponseBody
    public String heallString(@RequestParam("name") String name){
        return "hello" + name;
    }


    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam String name){
        // command  + shift + enter : 자동완성
        Hello hello = new Hello();
        hello.setName(name);
        return hello;

    }

    static class Hello {
        private String name;
//        command + n : Generater
        // java bean jack , 자바 빈 표준 방식, porperty 접근방식 (?)
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    /*
    * --거의(특정 사건에 대해서 수정을 하긴하...?)손대지 않고 그대로 쓴다.--
    * viewResolver대신에 HttpMessageConverter 동작
    * 기본 문자 처리 : StringHttpMessageConvetre
    * 기본 객체 처리 : MappingJackson2HttpMessageConveter
    * byte처리 등등 기타 여러 HttpMessageConveter가 기본으로 등록되어 있음
    * */

//    viewResolver 정리 필요 : 템플릿 엔진

}
