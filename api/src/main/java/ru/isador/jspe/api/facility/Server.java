package ru.isador.jspe.api.facility;

import java.util.UUID;

import ru.isador.jspe.api.facility.distributions.Distribution;

public class Server {

    private final String id;
    private String name;
    private Distribution distribution;
    private ServerKind serverKind;
    private ServerRequest serverRequest;
    private int quantity;
    private SchedulingPolicy schedulingPolicy;
    private String serviceUnits;
    private float serviceTime;

    public Server() {
        id = UUID.randomUUID().toString();
    }

    public Server(String name) {
        id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Distribution getDistribution() {
        return distribution;
    }

    public void setDistribution(Distribution distribution) {
        this.distribution = distribution;
    }

    public ServerKind getServerKind() {
        return serverKind;
    }

    public void setServerKind(ServerKind serverKind) {
        this.serverKind = serverKind;
    }

    public ServerRequest getServerRequest() {
        return serverRequest;
    }

    public void setServerRequest(ServerRequest serverRequest) {
        this.serverRequest = serverRequest;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public SchedulingPolicy getSchedulingPolicy() {
        return schedulingPolicy;
    }

    public void setSchedulingPolicy(SchedulingPolicy schedulingPolicy) {
        this.schedulingPolicy = schedulingPolicy;
    }

    public String getServiceUnits() {
        return serviceUnits;
    }

    public void setServiceUnits(String serviceUnits) {
        this.serviceUnits = serviceUnits;
    }

    public float getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(float serviceTime) {
        this.serviceTime = serviceTime;
    }
}
