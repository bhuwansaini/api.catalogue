package com.bhuwan.api.catalogue.service;

import com.bhuwan.api.catalogue.dao.ApiDao;
import com.bhuwan.api.catalogue.model.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApiListService {

    private final ApiDao apiDao;

    @Autowired
    public ApiListService(@Qualifier("fakeDao") ApiDao apiDao) {
        this.apiDao = apiDao;
    }

    public int addApi(Api api) {
        return apiDao.insertApi(api);
    }

    public List<Api> getAllApis() {
        return apiDao.selectAllApis();
    }

    public Optional<Api> selectApiById(UUID id) {
        return apiDao.selectApiById(id);
    }

    public int updateApi(UUID id, Api newApi) {
        return apiDao.updateApiById(id,newApi);
    }

    public int deleteApiById(UUID id) {
        return apiDao.deleteByApiId(id);
    }

}
