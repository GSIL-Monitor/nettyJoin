package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    String home() {
        return "hello spring boot!";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    String helle() {
        return "sayHello!";
    }

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    @ResponseBody
    String helleName(@PathVariable String name) {
        return "hi " + name;
    }

    @RequestMapping(value = "/hello/{name}/{age}", method = RequestMethod.GET)
    @ResponseBody
    String helleNameAndAge(@PathVariable String name, @PathVariable Integer age) {
        return "hi " + name + "; age=" + age;
    }

    @RequestMapping(value = "{place}/hello/{name}", method = RequestMethod.GET)
    @ResponseBody
    String placeHelleName(@PathVariable String place, @PathVariable String name) {
        return place + " hi " + name;
    }
}