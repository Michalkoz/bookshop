package com.michalkoz.catalog.application;

import com.michalkoz.catalog.domain.CatalogService;

public class CatalogController {

    private final CatalogService service;

    public CatalogController(CatalogService service) {
        this.service = service;
    }


}
