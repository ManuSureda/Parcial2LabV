package com.utn.Integration.controller;

import com.utn.Integration.projection.CallsProjection;
import com.utn.Integration.service.CallService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class CallWebControllerTest {
    private CallWebController callWebController;

    @Mock
    private CallService callService;

    @BeforeEach
    void setUp() {
        initMocks(this);
        callWebController = new CallWebController(callService);
    }

    @Test
    void getTopTenDestination() {
        CallsProjection topTenCallProjection;
        ProjectionFactory factoryTopCall = new SpelAwareProxyProjectionFactory();
        topTenCallProjection = factoryTopCall.createProjection(CallsProjection.class);

        topTenCallProjection.setFull_name_o("Palo Kel");
        topTenCallProjection.setDestination_city("Mar del Plata");
        topTenCallProjection.setCant(5);

        List<CallsProjection> topCalls = new ArrayList<CallsProjection>();
        topCalls.add(topTenCallProjection);

        when(callService.getTopTenDestination("123")).thenReturn(topCalls);
        List<CallsProjection> response = callWebController.getTopTenDestination("123");
        assertEquals(response, topCalls);
    }
}