package com.custom.marketPlace.services;

import com.custom.marketPlace.constants.ErrorCodes;
import com.custom.marketPlace.error.ErrorMessage;
import com.custom.marketPlace.model.BaseEntity;
import com.custom.marketPlace.repo.IRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public abstract class AbstractService<ObjectClass  extends BaseEntity> implements IService<ObjectClass> {

    protected final IRepository<ObjectClass> repository;

    public AbstractService(IRepository<ObjectClass> repository) {
        this.repository = repository;
    }

    @Override
    public boolean saveEntity(ObjectClass entity) {
        try {
            repository.save(entity);
            log.trace("Entity {} saved", entity);
            return true;
        } catch (Exception e) {
            ErrorMessage msg = ErrorMessage.builder()
                    .errorCode(ErrorCodes.COULD_NOT_SAVE_ENTITY_CODE)
                    .message("Could not save entity %s because of error: %s. Cause: %s")
                    .build();
            msg.setParams(entity, e.getMessage(), e.getCause());
            log.error(msg.get(), e);
        }
        return false;
    }

    @Override
    public boolean deleteEntityById(UUID id) {
        try {
            ObjectClass object = repository.findById(id);
            repository.delete(object);
            log.trace("Entity with id = {} deleted", id);
            return true;
        } catch (Exception e) {
            ErrorMessage msg = ErrorMessage.builder()
                    .errorCode(ErrorCodes.COULD_NOT_DELETE_ENTITY_CODE)
                    .message("Could not delete entity with id = %s because of error: %s. Cause: %s")
                    .build();
            msg.setParams(id, e.getMessage(), e.getCause());
            log.error(msg.get(), e);
        }
        return false;
    }

    @Override
    public boolean updateEntityById(UUID id, ObjectClass entity) {
        try {
            ObjectClass object = repository.findById(id);
            repository.update(object);
            log.trace("Entity with id = {} updated", id);
            return true;
        } catch (Exception e) {
            ErrorMessage msg = ErrorMessage.builder()
                    .errorCode(ErrorCodes.COULD_NOT_UPDATE_ENTITY_CODE)
                    .message("Could not update entity with id = %s because of error: %s. Cause: %s")
                    .build();
            msg.setParams(id, e.getMessage(), e.getCause());
            log.error(msg.get(), e);
        }
        return false;
    }

    @Override
    public ObjectClass getEntityById(UUID id) {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            ErrorMessage msg = ErrorMessage.builder()
                    .errorCode(ErrorCodes.COULD_NOT_GET_ENTITY_CODE)
                    .message("Could not get entity with id = %s because of error: %s. Cause: %s")
                    .build();
            msg.setParams(id, e.getMessage(), e.getCause());
            log.error(msg.get(), e);
            return null;
        }
    }
}
