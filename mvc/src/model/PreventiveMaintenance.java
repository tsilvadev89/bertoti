package model;

public class PreventiveMaintenance implements MaintenanceStrategy {
    @Override
    public void executeMaintenance() {
        System.out.println("Realizando manutenção preventiva...");
        // Lógica específica da manutenção preventiva
    }
}
