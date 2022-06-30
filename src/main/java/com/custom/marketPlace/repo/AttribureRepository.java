package com.custom.marketPlace.repo;

import com.custom.marketPlace.enums.PossibleValues;
import com.custom.marketPlace.model.Attribute;

import java.util.UUID;

public interface AttribureRepository {
    Attribute getAttributeById(UUID id);
    Attribute getAttributeByName(String name);
    Attribute saveAttribute(Attribute a);
    void removeAttribute(Attribute a);
    void updateAttributeName(UUID id, String name);
    void updateAttributePossibleValues(UUID id, PossibleValues values);
}
