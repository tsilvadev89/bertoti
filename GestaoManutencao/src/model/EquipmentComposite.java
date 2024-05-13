package model;

import java.util.ArrayList;
import java.util.List;

public class EquipmentComposite implements Composite {
    private List<Composite> components;

    public EquipmentComposite() {
        this.components = new ArrayList<>();
    }

    public void addComponent(Composite component) {
        components.add(component);
    }

    public void removeComponent(Composite component) {
        components.remove(component);
    }

    @Override
    public void performMaintenance() {
        System.out.println("Realizando manutenção no equipamento composto:");
        for (Composite component : components) {
            component.performMaintenance();
        }
    }
}