package com.bhuwan.api.catalogue.controller;

import com.bhuwan.api.catalogue.model.Api;
import com.bhuwan.api.catalogue.service.ApiListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api-catalogue/v1/api")
@RestController
public class ApiController {

    private final ApiListService apiListService;

    @Autowired
    public ApiController(ApiListService apiListService) {
        this.apiListService = apiListService;
    }

    @PostMapping
    public void addApi(@RequestBody Api api){
        apiListService.addApi(api);
    }

    @GetMapping
    public List<Api> getAllApis() {
        return apiListService.getAllApis();
    }

    @GetMapping(path = "{id}")
    public Api getApi(@PathVariable("id") UUID id) {
        return apiListService.selectApiById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteApi( UUID id) {
        apiListService.deleteApiById(id);
    }

    @PutMapping(path = "{id}")
    public void updateApi(@PathVariable("id") UUID id, @RequestBody Api newApi) {
        apiListService.updateApi(id, newApi);
    }
}
