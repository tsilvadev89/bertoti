/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package observer;

/*
Subject representa o equipamento industrial que pode realizar manutenção. O EquipamentoObserver é o 
observador que será notificado quando a manutenção for realizada. A notificação é feita quando o 
método realizarManutencao() é chamado no Subject
*/
public class Main {
    public static void main(String[] args) {
        Equipamento equipamento = new Equipamento();
        Manutencao manutencao = new Manutencao();

        equipamento.addObserver(manutencao);
        equipamento.setMes(5); // Mês de manutenção atualizado para: 5
    }
}
