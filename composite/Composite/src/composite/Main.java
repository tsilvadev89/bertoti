/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/*Neste exemplo, o Composite é utilizado para representar um equipamento industrial, 
onde o equipamento completo é composto por conjuntos de partes, e cada conjunto pode
conter partes individuais ou outros conjuntos. Quando a manutenção é realizada no
equipamento completo, a manutenção é propagada recursivamente para todas as partes 
e subpartes através da hierarquia Composite.*/


package composite;
public class Main {
    public static void main(String[] args) {
        ManutencaoComponent preventiva = new Manutencao("Preventiva");
        ManutencaoComponent corretiva = new Manutencao("Corretiva");
        ManutencaoComponent preditiva = new Manutencao("Preditiva");

        ManutencaoComposite manutencaoGeral = new ManutencaoComposite("Manutenção Geral");
        manutencaoGeral.add(preventiva);
        manutencaoGeral.add(corretiva);
        manutencaoGeral.add(preditiva);

        manutencaoGeral.mostrarManutencao();
    }
}
