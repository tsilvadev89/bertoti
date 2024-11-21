/*
EquipamentoSingleton garante que apenas uma instância do equipamento seja criada, 
mesmo que seja solicitada de várias partes do código. 
Util quando queremos garantir que o equipamento seja compartilhado e 
acessado globalmente em toda a aplicação.
 */
package singleton;

public class Main {
    public static void main(String[] args) {
        Manutencao manutencao = Manutencao.getInstance();
        manutencao.setTipo("Preventiva");
        manutencao.iniciarManutencao(); // Iniciando manutenção do tipo: Preventiva
        manutencao.finalizarManutencao(); // Finalizando manutenção do tipo: Preventiva

        Manutencao outraManutencao = Manutencao.getInstance();
        System.out.println(outraManutencao.getTipo()); // Preventiva
    }
}
