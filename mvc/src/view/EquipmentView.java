package view;

import model.Equipment;
import model.EquipmentComposite;

import java.util.List;
import model.Composite;

public class EquipmentView {

    public void displayEquipmentDetails(EquipmentComposite equipmentComposite) {
        System.out.println("Detalhes do Equipamento:");
        displayEquipmentDetailsRecursive(equipmentComposite, 0);
    }

    private void displayEquipmentDetailsRecursive(Composite component, int level) { // Use Composite here
        // Handle both EquipmentComposite and Equipment types
        if (component instanceof EquipmentComposite equipmentComposite) {
            List<Composite> components = equipmentComposite.getSubEquipments();
            for (Composite subComponent : components) {
                StringBuilder indent = new StringBuilder();
                for (int i = 0; i < level; i++) {
                    indent.append("  "); // Use two spaces for indentation
                }
                displayEquipmentDetailsRecursive(subComponent, level + 1);
                System.out.println(indent + "- " + equipmentComposite.getName()); // Display composite name after processing subcomponents
            }
        } else if (component instanceof Equipment equipment) {
            StringBuilder indent = new StringBuilder();
            for (int i = 0; i < level; i++) {
                indent.append("  "); // Use two spaces for indentation
            }
            System.out.println(indent + "- (Leaf) " + equipment.getName());
        }
    }
}
