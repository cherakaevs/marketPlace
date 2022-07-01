package com.custom.marketPlace.services;

import com.custom.marketPlace.model.BaseEntity;

import java.util.UUID;

public interface IService<ObjectClass extends BaseEntity> {

    boolean saveEntity(ObjectClass entity);

    boolean deleteEntityById(UUID id);

    boolean updateEntityById(UUID id, ObjectClass entity);

    ObjectClass getEntityById(UUID id);

}
