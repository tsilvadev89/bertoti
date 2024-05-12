package stategy;

public class Principal {
    public static void main(String[] args) {
        EstrategiaManutencao preventiva = new ManutencaoPreventiva();
        EstrategiaManutencao corretiva = new ManutencaoCorretiva();
        EstrategiaManutencao preditiva = new ManutencaoPreditiva();

        Equipamento equipamento = new Equipamento(preventiva);

        equipamento.realizarManutencao();

        equipamento.setEstrategiaManutencao(corretiva);
        equipamento.realizarManutencao();

        equipamento.setEstrategiaManutencao(preditiva);
        equipamento.realizarManutencao();
    }
}
