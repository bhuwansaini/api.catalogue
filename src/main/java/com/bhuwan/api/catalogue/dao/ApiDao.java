package com.bhuwan.api.catalogue.dao;

import com.bhuwan.api.catalogue.model.Api;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ApiDao {

    int insertApi(UUID id, Api api);

    default int insertApi(Api api) {
        UUID id = UUID.randomUUID();
        return insertApi(id, api);
    }

    List<Api> selectAllApis();

    int deleteByApiId(UUID id);

    int updateApiById(UUID id, Api api);

    Optional<Api> selectApiById(UUID id);
}
