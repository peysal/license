package com.pey.licenses.services;

import java.util.List;
import java.util.UUID;

import com.pey.licenses.config.ServiceConfig;
import com.pey.licenses.model.License;
import com.pey.licenses.repository.LicenseRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class LicenseService {

    @Autowired
    private LicenseRepository licenseRepository;
    @Autowired
    private ServiceConfig serviceConfig;

    public License getLicense(String organizationId, String licenseId){
        License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
        return license.withComment(serviceConfig.getExampleProperty());
    }

    public List<License> getLicensesByOrg(String organizationId){
        return licenseRepository.findByOrganizationId(organizationId);
    }

    public void saveLicense(License license){
        license.withId(UUID.randomUUID().toString());
        licenseRepository.save(license);
    }

}