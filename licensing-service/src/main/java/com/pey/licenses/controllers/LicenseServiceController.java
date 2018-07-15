package com.pey.licenses.controllers;

import java.util.List;

import com.pey.licenses.model.License;
import com.pey.licenses.services.LicenseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/organizations/{organizationId}/licenses")
public class LicenseServiceController {

    @Autowired
    private LicenseService licenseService;

    @GetMapping(value="/")
    public List<License> getLicenses(@PathVariable("organizationId")String organizationId){
        return licenseService.getLicensesByOrg(organizationId);    
    }
}
