/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package facade;

public class Main {
    public static void main(String[] args) {
        ManutencaoComponent preventiva = new ManutencaoPreventiva();
        ManutencaoComponent corretiva = new ManutencaoCorretiva();
        ManutencaoComponent preditiva = new ManutencaoPreditiva();

        Facade facade = new Facade(preventiva, corretiva, preditiva);

        facade.funcPreventiva();
        facade.funcCorretiva();
        facade.funcPreditiva();
    }
}
