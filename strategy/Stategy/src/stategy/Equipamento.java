
package stategy;

public class Equipamento {
    private EstrategiaManutencao estrategiaManutencao;

    public Equipamento(EstrategiaManutencao estrategiaManutencao) {
        this.estrategiaManutencao = estrategiaManutencao;
    }

    public void setEstrategiaManutencao(EstrategiaManutencao estrategiaManutencao) {
        this.estrategiaManutencao = estrategiaManutencao;
    }

    public void realizarManutencao() {
        estrategiaManutencao.realizarManutencao();
    }
}
