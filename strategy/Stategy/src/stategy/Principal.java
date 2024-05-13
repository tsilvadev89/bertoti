package stategy;



interface EstrategiaManutencao {
    void realizarManutencao();
}

class ManutencaoPreventiva implements EstrategiaManutencao {
    public void realizarManutencao() {
        System.out.println("Realizando manutenção preventiva...");
    }
}

class ManutencaoCorretiva implements EstrategiaManutencao {
    public void realizarManutencao() {
        System.out.println("Realizando manutenção corretiva...");
    }
}

class ManutencaoPreditiva implements EstrategiaManutencao {
    public void realizarManutencao() {
        System.out.println("Realizando manutenção preditiva...");
    }
}

class Equipamento {
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

public class Principal {
    public static void main(String[] args) {
        ManutencaoPreventiva preventiva = new ManutencaoPreventiva();
        ManutencaoCorretiva corretiva = new ManutencaoCorretiva();
        ManutencaoPreditiva preditiva = new ManutencaoPreditiva();

        Equipamento equipamento = new Equipamento(preventiva);

        equipamento.realizarManutencao();

        equipamento.setEstrategiaManutencao(corretiva);
        equipamento.realizarManutencao();

        equipamento.setEstrategiaManutencao(preditiva);
        equipamento.realizarManutencao();
    }
}
