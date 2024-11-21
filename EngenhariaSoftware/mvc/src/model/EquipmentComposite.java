package model;

import java.util.ArrayList;
import java.util.List;

public class EquipmentComposite implements Composite {
    private String name;
    private List<Composite> components;

    public EquipmentComposite(String name) {
        this.name = name;
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
        System.out.println("Realizando manutenção no equipamento composto: " + name);
        for (Composite component : components) {
            component.performMaintenance();
        }
    }

    public List<Composite> getSubEquipments() {
        return List.copyOf(components);
    }

    public String getName() {
        return name;
    }
}
