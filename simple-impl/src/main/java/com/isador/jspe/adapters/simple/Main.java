package com.isador.jspe.adapters.simple;

import com.isador.jspe.adapters.simple.nodes.SimpleBasicNode;
import com.isador.jspe.core.ModelStatistic;
import com.isador.jspe.core.Payload;
import com.isador.jspe.core.Resource;

public class Main {

    public static void main(String[] args) {
        Resource cpu = new Resource("cpu");
        cpu.setServiceTime(0.001);

        Resource mem = new Resource("mem");
        mem.setServiceTime(0.01);

        Resource net = new Resource("net");
        net.setServiceTime(0.1);


        Payload wu = new Payload("wu");
        Payload sql = new Payload("sql");
        Payload mes = new Payload("message");

        SimpleModel model = new SimpleModel();
        model.getConsumptionMatrix().setConsumption(wu, cpu, 1000.0);
        model.getConsumptionMatrix().setConsumption(wu, mem, 100.0);

        model.getConsumptionMatrix().setConsumption(sql, cpu, 500.0);
        model.getConsumptionMatrix().setConsumption(sql, mem, 500.0);
        model.getConsumptionMatrix().setConsumption(sql, net, 300.0);

        model.getConsumptionMatrix().setConsumption(mes, cpu, 100.0);
        model.getConsumptionMatrix().setConsumption(mes, mem, 1000.0);
        model.getConsumptionMatrix().setConsumption(mes, net, 1000.0);

        AbstractNode step1 = new SimpleBasicNode();
        step1.getPayloadMatrix().put(wu, 5.0);
        step1.getPayloadMatrix().put(sql, 10.0);

        AbstractNode step2 = new SimpleBasicNode();
        step2.getPayloadMatrix().put(wu, 10.0);
        step2.getPayloadMatrix().put(mes, 5.0);

        AbstractNode step3 = new SimpleBasicNode();
        step3.getPayloadMatrix().put(wu, 5.0);
        step3.getPayloadMatrix().put(sql, 5.0);
        step3.getPayloadMatrix().put(mes, 5.0);

        model.addNode(step1);
        model.addNode(step1, step2);
        model.addNode(step2, step3);

        ModelStatistic statistic = model.getStatistic();

        System.out.println("Total payload:");
        statistic.getTotalPayload().forEach((k, v) -> System.out.println(k.getTitle() + ": " + v));

        System.out.println("\nTotal resources:");
        statistic.getTotalResource().forEach((k, v) -> System.out.println(k.getTitle() + ": " + v));

        System.out.println("\nModel rating:" + statistic.getRating());
    }
}
