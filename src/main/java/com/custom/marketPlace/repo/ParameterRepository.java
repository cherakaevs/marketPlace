package com.custom.marketPlace.repo;

import com.custom.marketPlace.model.Parameter;

import java.util.UUID;

public interface ParameterRepository {
    Parameter getParameterById(UUID id);
    Parameter getParameterByValue(String value);
    Parameter saveParameter(Parameter p);
    void removeParameter(Parameter p);
    void updateParameterValue(UUID id, String value);
}
