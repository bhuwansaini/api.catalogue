package com.bhuwan.api.catalogue.dao;

import com.bhuwan.api.catalogue.model.Api;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository("mssql")
public class ApiCatalogDataAccessService implements ApiDao {
    @Override
    public int insertApi(UUID id, Api api) {
        return 0;
    }

    @Override
    public int insertApi(Api api) {
        return 0;
    }

    @Override
    public List<Api> selectAllApis() {
        return Arrays.asList( new Api(UUID.randomUUID(), "FROM MS SQL DB"));
    }

    @Override
    public int deleteByApiId(UUID id) {
        return 0;
    }

    @Override
    public int updateApiById(UUID id, Api api) {
        return 0;
    }

    @Override
    public Optional<Api> selectApiById(UUID id) {
        return Optional.empty();
    }
}
