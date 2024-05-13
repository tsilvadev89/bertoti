package controller;

import model.Equipment;
import model.EquipmentComposite;
import model.PreventiveMaintenance;
import model.CorrectiveMaintenance;
import model.PredictiveMaintenance;
import view.MainView;
import view.EquipmentView;

public class MainController {
    private MainView mainView;
    private EquipmentView equipmentView;
    private EquipmentComposite equipmentComposite;

    public MainController() {
        mainView = new MainView();
        equipmentView = new EquipmentView();
        equipmentComposite = createEquipmentHierarchy();
    }

    public void run() {
        int choice;
        do {
            mainView.displayMenu();
            choice = mainView.getUserChoice();
            switch (choice) {
                case 1:
                    performPreventiveMaintenance();
                    break;
                case 2:
                    performCorrectiveMaintenance();
                    break;
                case 3:
                    performPredictiveMaintenance();
                    break;
                case 4:
                    viewEquipmentDetails();
                    break;
                case 5:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (choice != 5);
    }

    private void performPreventiveMaintenance() {
        PreventiveMaintenance preventiveMaintenance = new PreventiveMaintenance();
        preventiveMaintenance.executeMaintenance();
        equipmentComposite.performMaintenance();
    }

    private void performCorrectiveMaintenance() {
        CorrectiveMaintenance correctiveMaintenance = new CorrectiveMaintenance();
        correctiveMaintenance.executeMaintenance();
        equipmentComposite.performMaintenance();
    }

    private void performPredictiveMaintenance() {
        PredictiveMaintenance predictiveMaintenance = new PredictiveMaintenance();
        predictiveMaintenance.executeMaintenance();
        equipmentComposite.performMaintenance();
    }

    private void viewEquipmentDetails() {
        equipmentView.displayEquipmentDetails(equipmentComposite);
    }

    private EquipmentComposite createEquipmentHierarchy() {
        EquipmentComposite root = new EquipmentComposite();
        EquipmentComposite assemblyLine1 = new EquipmentComposite();
        EquipmentComposite assemblyLine2 = new EquipmentComposite();

        Equipment motor = new Equipment("Motor");
        Equipment compressor = new Equipment("Compressor");
        Equipment belt = new Equipment("Belt");

        assemblyLine1.addComponent(motor);
        assemblyLine1.addComponent(compressor);
        assemblyLine2.addComponent(belt);

        root.addComponent(assemblyLine1);
        root.addComponent(assemblyLine2);

        return root;
    }
}
