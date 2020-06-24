package com.utn.Integration.integrationElements;


import com.utn.Integration.projection.CallsProjection;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@Component
public class ApiIntegrationElement {
    private RestTemplate rest;
    private final String URL = "http://localhost:8080/";


    @PostConstruct
    private void init(){
        rest = new RestTemplateBuilder().build();
    }


    public List<CallsProjection> getTopTenDestinations(String dni){
        return rest.getForObject(URL+"/parcial/top?dni={dni}",List.class,dni);
    }

}
