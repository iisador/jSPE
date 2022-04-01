package ru.isador.jspe.api.resource;

import ru.isador.jspe.api.Named;

public interface Device extends Named {

    String getDeviceKind();

    void setDeviceKind(String deviceKind);

    Integer getQuantity();

    void setQuantity(Integer quantity);

    String getSchedulingPolicy();

    void setSchedulingPolicy(String schedulingPolicy);

    Double getServiceUnits();

    void setServiceUnits(Double serviceUnits);

    Double getServiceTime();

    void setServiceTime(Double serviceTime);
}
