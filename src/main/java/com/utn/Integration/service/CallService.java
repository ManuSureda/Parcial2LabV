package com.utn.Integration.service;

import com.utn.Integration.integrationElements.ApiIntegrationElement;
import com.utn.Integration.projection.CallsProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CallService {

    private final ApiIntegrationElement apiIntegrationElement;

    @Autowired
    public CallService (ApiIntegrationElement apiIntegrationElement){
        this.apiIntegrationElement = apiIntegrationElement;
    }


    public List<CallsProjection> getTopTenDestination(String dni){
        return apiIntegrationElement.getTopTenDestinations(dni);
    }

}
