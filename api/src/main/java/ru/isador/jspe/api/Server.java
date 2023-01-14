package ru.isador.jspe.api;

import ru.isador.jspe.api.distributions.Distribution;

public class Server {

    private String id;
    private String name;
    private Distribution distribution;
    private ServerKind serverKind;
    private ServerRequest serverRequest;
    private int quantity;
    private SchedulingPolicy schedulingPolicy;
    private String serviceUnits;
    private float serviceTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
