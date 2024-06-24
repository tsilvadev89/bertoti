package strategy;


public class Main {
    public static void main(String[] args) {
        Equipamento equipamento = new Equipamento();

        Manutencao preventiva = new Preventiva();
        Manutencao corretiva = new Corretiva();
        Manutencao preditiva = new Preditiva();

        equipamento.setManutencao(preventiva);
        equipamento.realizarManutencao(); // Realizando manutenção preventiva

        equipamento.setManutencao(corretiva);
        equipamento.realizarManutencao(); // Realizando manutenção corretiva

        equipamento.setManutencao(preditiva);
        equipamento.realizarManutencao(); // Realizando manutenção preditiva
    }
}
