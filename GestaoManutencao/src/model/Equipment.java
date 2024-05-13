package model;

import java.util.ArrayList;
import java.util.List;

public class Equipment implements Composite {
    private String name;
    private List<Equipment> subEquipments;

    public Equipment(String name) {
        this.name = name;
        this.subEquipments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addComponent(Equipment equipment) {
        subEquipments.add(equipment);
    }

    public void removeComponent(Equipment equipment) {
        subEquipments.remove(equipment);
    }

    @Override
    public void performMaintenance() {
        System.out.println("Realizando manutenção no equipamento: " + name);
        for (Equipment subEquipment : subEquipments) {
            subEquipment.performMaintenance();
        }
    }

    public List<Equipment> getSubEquipments() {
        return subEquipments;
    }
}
