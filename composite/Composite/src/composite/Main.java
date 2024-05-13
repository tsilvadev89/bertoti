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

import java.util.ArrayList;
import java.util.List;

// Componente Composite
interface Componente {
    void realizarManutencao();
}

// Folha do Composite
class Parte implements Componente {
    private String nome;

    public Parte(String nome) {
        this.nome = nome;
    }

    public void realizarManutencao() {
        System.out.println("Realizando manutenção na parte: " + nome);
    }
}

// Composite
class EquipamentoComposite implements Componente {
    private List<Componente> componentes = new ArrayList<>();

    public void adicionarComponente(Componente componente) {
        componentes.add(componente);
    }

    public void removerComponente(Componente componente) {
        componentes.remove(componente);
    }

    public void realizarManutencao() {
        System.out.println("Realizando manutenção no equipamento:");
        for (Componente componente : componentes) {
            componente.realizarManutencao();
        }
    }
}

// Classe principal para testar o padrão
public class Main {
    public static void main(String[] args) {
        // Criando partes do equipamento
        Parte motor = new Parte("Motor");
        Parte compressor = new Parte("Compressor");
        Parte esteira = new Parte("Esteira");

        // Criando subconjuntos do equipamento
        EquipamentoComposite conjunto1 = new EquipamentoComposite();
        conjunto1.adicionarComponente(motor);
        conjunto1.adicionarComponente(compressor);

        EquipamentoComposite conjunto2 = new EquipamentoComposite();
        conjunto2.adicionarComponente(esteira);

        // Criando equipamento completo
        EquipamentoComposite equipamento = new EquipamentoComposite();
        equipamento.adicionarComponente(conjunto1);
        equipamento.adicionarComponente(conjunto2);

        // Realizando manutenção no equipamento completo
        equipamento.realizarManutencao();
    }
}
