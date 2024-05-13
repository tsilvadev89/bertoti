package view;

import model.Equipment;
import java.util.List;

public class EquipmentView {
    public void displayEquipmentDetails(Equipment equipment) {
        System.out.println("Detalhes do Equipamento:");
        System.out.println("Nome: " + equipment.getName());
        System.out.println("Subequipamentos:");

        List<Equipment> subEquipments = equipment.getSubEquipments();
        if (subEquipments.isEmpty()) {
            System.out.println("Nenhum subequipamento.");
        } else {
            for (Equipment subEquipment : subEquipments) {
                System.out.println("- " + subEquipment.getName());
            }
        }
    }
}
