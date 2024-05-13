/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package facade;

// Subsistema de manutenção preventiva
class ManutencaoPreventiva {
    public void realizarManutencao() {
        System.out.println("Realizando manutenção preventiva...");
    }
}

// Subsistema de manutenção corretiva
class ManutencaoCorretiva {
    public void realizarManutencao() {
        System.out.println("Realizando manutenção corretiva...");
    }
}

// Subsistema de manutenção preditiva
class ManutencaoPreditiva {
    public void realizarManutencao() {
        System.out.println("Realizando manutenção preditiva...");
    }
}

// Facade para a manutenção do equipamento
class EquipamentoFacade {
    private ManutencaoPreventiva manutencaoPreventiva;
    private ManutencaoCorretiva manutencaoCorretiva;
    private ManutencaoPreditiva manutencaoPreditiva;

    public EquipamentoFacade() {
        this.manutencaoPreventiva = new ManutencaoPreventiva();
        this.manutencaoCorretiva = new ManutencaoCorretiva();
        this.manutencaoPreditiva = new ManutencaoPreditiva();
    }

    public void realizarManutencaoPreventiva() {
        manutencaoPreventiva.realizarManutencao();
    }

    public void realizarManutencaoCorretiva() {
        manutencaoCorretiva.realizarManutencao();
    }

    public void realizarManutencaoPreditiva() {
        manutencaoPreditiva.realizarManutencao();
    }
}

public class Main {
    public static void main(String[] args) {
        EquipamentoFacade facade = new EquipamentoFacade();

        // Realizando diferentes tipos de manutenção usando a facade
        facade.realizarManutencaoPreventiva();
        facade.realizarManutencaoCorretiva();
        facade.realizarManutencaoPreditiva();
    }
}
