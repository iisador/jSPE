package ru.isador.jspe.api.facility;

public enum ServerRequest {

    NON_FCFS_TIME_SPEC("NonFCFSTimeSpec"),
    NON_FCFS_DEMAND_SPEC("NonFCFSDemandSpec"),
    NON_FCFS_VISIT_SPEC("NonFCFSVisitSpec"),
    FCFS_WORK_UNIT_SPEC("FCFSWorkUnitSpec");

    private final String value;

    ServerRequest(String v) {
        value = v;
    }

    public String value() {
        return value;
    }
}
