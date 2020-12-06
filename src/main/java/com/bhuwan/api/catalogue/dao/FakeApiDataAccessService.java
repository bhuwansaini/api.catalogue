package com.bhuwan.api.catalogue.dao;

import com.bhuwan.api.catalogue.model.Api;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakeApiDataAccessService implements ApiDao{

    private static List<Api> DB;

    static {
        DB = new ArrayList<>();
    }

    @Override
    public int insertApi(UUID id, Api api) {
        DB.add(new Api(id, api.getName()));
        return 1;
    }

    @Override
    public List<Api> selectAllApis() {
        return DB;
    }

    @Override
    public int deleteByApiId(UUID id) {

        Optional<Api> apiMaybe = selectApiById(id);
        if (apiMaybe.isPresent()) {
            DB.remove(apiMaybe.get());
            return 1;
        }
        return 0;
    }

    @Override
    public int updateApiById(UUID id, Api newApi) {
        return selectApiById(id)
                .map( a -> {
                    int indexOfApiToUpdate = DB.indexOf(a);
                    if(indexOfApiToUpdate >= 0) {
                        DB.set(indexOfApiToUpdate, new Api(id, newApi.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public Optional<Api> selectApiById(UUID id) {
        return DB.stream()
                .filter(api -> api.getId().equals(id))
                .findFirst();
    }
}
