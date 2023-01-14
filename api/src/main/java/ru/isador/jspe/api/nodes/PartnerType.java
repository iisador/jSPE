package ru.isador.jspe.api.nodes;

/**
 * Вид синхронизации.
 *
 * @since 1.0.0
 */
public enum PartnerType {

    SYNCHRONOUS_CALL("SynchronousCall"),
    DEFERRED_SYNCHRONOUS_CALL("DeferredSynchronousCall"),
    ASYNCHRONOUS_CALL("AsynchronousCall"),
    NO_REPLY("NoReply"),
    REPLY("Reply");

    private final String value;

    PartnerType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }
}
