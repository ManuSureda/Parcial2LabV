package com.utn.Integration.controller;

import com.utn.Integration.projection.CallsProjection;
import com.utn.Integration.service.CallService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CallWebController {
    private final CallService callService;

    @Autowired
    public CallWebController(CallService callService){
        this.callService = callService;
    }

    @GetMapping("/top")
    @ApiOperation(value = "returns the 10 destinations most called by the specified dni")
    public List<CallsProjection> getTopTenDestination(@RequestParam String dni){
        return callService.getTopTenDestination(dni);
    }

}
