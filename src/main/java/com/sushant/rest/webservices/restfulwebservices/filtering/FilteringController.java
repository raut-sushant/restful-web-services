package com.sushant.rest.webservices.restfulwebservices.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBean retrieveSomeBean(){
        return new SomeBean("Value1","Value2","Value3");
    }

    @GetMapping("/filteringList")
    public List<SomeBean> retrieveSomeBeanList(){
        return Arrays.asList(new SomeBean("Value1","Value2","Value3"),
                new SomeBean("Value11","Value12","Value13"));
    }
}
