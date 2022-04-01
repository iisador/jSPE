package ru.isador.jspe.api.resource;

import java.util.Collection;

public interface Facility {

    Collection<Device> getDevices();

    void addDevice(Device device);

    void removeDevice(Device device);
}
