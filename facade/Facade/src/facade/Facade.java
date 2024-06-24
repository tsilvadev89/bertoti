/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

/**
 *
 * @author thiag
 */

public class Facade {
    private ManutencaoComponent preventiva;
    private ManutencaoComponent corretiva;
    private ManutencaoComponent preditiva;

    public Facade(ManutencaoComponent preventiva, ManutencaoComponent corretiva, ManutencaoComponent preditiva) {
        this.preventiva = preventiva;
        this.corretiva = corretiva;
        this.preditiva = preditiva;
    }

    public void funcPreventiva() {
        System.out.println("Função Preventiva: " + preventiva.getTipo());
    }

    public void funcCorretiva() {
        System.out.println("Função Corretiva: " + corretiva.getTipo());
    }

    public void funcPreditiva() {
        System.out.println("Função Preditiva: " + preditiva.getTipo());
    }
}