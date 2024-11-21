/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strategy;

/**
 *
 * @author thiag
 */

public class Equipamento {
    private Manutencao manutencao;

    public void setManutencao(Manutencao manutencao) {
        this.manutencao = manutencao;
    }

    public void realizarManutencao() {
        if (manutencao != null) {
            manutencao.realizar();
        } else {
            System.out.println("Nenhuma estratégia de manutenção definida");
        }
    }
}
