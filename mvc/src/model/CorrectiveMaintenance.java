package model;

public class CorrectiveMaintenance implements MaintenanceStrategy {
    @Override
    public void executeMaintenance() {
        System.out.println("Realizando manutenção corretiva...");
        // Lógica específica da manutenção corretiva
    }
}
