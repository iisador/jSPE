package ru.isador.jspe.api.facility;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Среда исполнения приложения.
 * <p>
 * Набор серверов и ресурсов.
 *
 * @since 1.0.0
 */
public class Facility {

    private final Map<String, Server> servers;
    private final Map<Server, Amount> overheadMatrix;

    private final String id;
    private String name;

    public Facility() {
        id = UUID.randomUUID().toString();
        servers = new HashMap<>();
        overheadMatrix = new HashMap<>();
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

    public Optional<Server> getServer(String serverId) {
        return Optional.ofNullable(servers.get(serverId));
    }

    public void addServer(Server server) {
        servers.put(server.getId(), server);
    }

    public void addOverhead(SoftwareResource softwareResource, Server server, float amountOfService) {
        overheadMatrix.put(server, new Amount(softwareResource, amountOfService));
    }

    private record Amount(SoftwareResource softwareResource, float amountOfService) {
    }
}
