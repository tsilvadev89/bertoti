package model;

import java.util.ArrayList;
import java.util.List;

public class Equipment implements Composite {
    private String name;
    private List<Composite> subEquipments;

    public Equipment(String name) {
        this.name = name;
        this.subEquipments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addComponent(Composite equipment) {
        subEquipments.add(equipment);
    }

    public void removeComponent(Composite equipment) {
        subEquipments.remove(equipment);
    }

    @Override
    public void performMaintenance() {
        System.out.println("Realizando manutenção no equipamento: " + name);
        for (Composite subEquipment : subEquipments) {
            subEquipment.performMaintenance();
        }
    }

    public List<Composite> getSubEquipments() {
        return subEquipments;
    }
}
