package com.pey.licenses.repository;

import java.util.List;

import com.pey.licenses.model.License;

import org.springframework.data.repository.CrudRepository;

public interface LicenseRepository extends CrudRepository<License, String> {
    public List<License> findByOrganizationId(String organizationId);
    public License findByOrganizationIdAndLicenseId(String organizationId, String licenseId);
}