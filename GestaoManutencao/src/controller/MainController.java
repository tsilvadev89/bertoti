package controller;

import model.EquipmentComposite;
import model.PreventiveMaintenance;
import model.CorrectiveMaintenance;
import model.PredictiveMaintenance;
import view.MainView;
import view.EquipmentView;
import model.Composite;

public class MainController {

    // Componentes principais do programa
    private MainView mainView;
    private EquipmentView equipmentView;
    private Composite equipmentComposite;

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

    // Realizar ações de manutenção com base na seleção
    private void performPreventiveMaintenance() {
        PreventiveMaintenance preventiveMaintenance = new PreventiveMaintenance();
        preventiveMaintenance.executeMaintenance();
    }

    private void performCorrectiveMaintenance() {
        CorrectiveMaintenance correctiveMaintenance = new CorrectiveMaintenance();
        correctiveMaintenance.executeMaintenance();
    }

    private void performPredictiveMaintenance() {
        PredictiveMaintenance predictiveMaintenance = new PredictiveMaintenance();
        predictiveMaintenance.executeMaintenance();
    }

    // Exibir detalhes do equipamento
    private void viewEquipmentDetails() {
        equipmentView.displayEquipmentDetails((EquipmentComposite) equipmentComposite);
    }

    // Criar uma hierarquia de equipamentos de exemplo (substituir pela estrutura desejada)
    private Composite createEquipmentHierarchy() {
        EquipmentComposite root = new EquipmentComposite("Root");
        EquipmentComposite assemblyLine1 = new EquipmentComposite("Assembly Line 1");
        EquipmentComposite assemblyLine2 = new EquipmentComposite("Assembly Line 2");

        model.Equipment motor = new model.Equipment("Motor");
        model.Equipment compressor = new model.Equipment("Compressor");
        model.Equipment belt = new model.Equipment("Belt");

        assemblyLine1.addComponent(motor);
        assemblyLine1.addComponent(compressor);
        assemblyLine2.addComponent(belt);

        root.addComponent(assemblyLine1);
        root.addComponent(assemblyLine2);

        return root;
    }
}
