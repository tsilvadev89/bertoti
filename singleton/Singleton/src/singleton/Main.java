/*
EquipamentoSingleton garante que apenas uma instância do equipamento seja criada, 
mesmo que seja solicitada de várias partes do código. 
Util quando queremos garantir que o equipamento seja compartilhado e 
acessado globalmente em toda a aplicação.
 */
package singleton;

// Classe Singleton para o Equipamento
class EquipamentoSingleton {
    private static EquipamentoSingleton instance;
    
    // Construtor privado para impedir a criação de instâncias fora desta classe
    private EquipamentoSingleton() {}
    
    // Método estático para obter a instância única do equipamento
    public static EquipamentoSingleton getInstance() {
        if (instance == null) {
            instance = new EquipamentoSingleton();
        }
        return instance;
    }
    
    // Método para realizar a manutenção no equipamento
    public void realizarManutencao() {
        System.out.println("Realizando manutenção no equipamento...");
    }
}

// Classe principal para testar o padrão
public class Main {
    public static void main(String[] args) {
        // Instancia unica do equipamento.
        EquipamentoSingleton equipamento = EquipamentoSingleton.getInstance();
        
        // Realizando a manutenção no equipamento
        equipamento.realizarManutencao();
        
        // Tentando criar outra instância do equipamento (não deve ser possível)
        //  EquipamentoSingleton outroEquipamento = new EquipamentoSingleton(); // Nao sera posivel
    }
}
