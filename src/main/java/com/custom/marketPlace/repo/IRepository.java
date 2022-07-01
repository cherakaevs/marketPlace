package com.custom.marketPlace.repo;

import com.custom.marketPlace.model.BaseEntity;

import java.util.UUID;

public interface IRepository<ObjectClass extends BaseEntity> {

    void save(ObjectClass object);

    void update(ObjectClass object);

    void delete(ObjectClass object);

    ObjectClass findById(UUID id);

}
