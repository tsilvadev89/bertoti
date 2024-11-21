/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observer;

/**
 *
 * @author thiag
 */
public class Manutencao implements ManutencaoObserver {
    private int mes;

    @Override
    public void update(int mes) {
        this.mes = mes;
        display();
    }

    public void display() {
        System.out.println("Mês de manutenção atualizado para: " + mes);
    }
}
