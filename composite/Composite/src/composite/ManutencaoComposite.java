/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package composite;

/**
 *
 * @author thiag
 */
import java.util.ArrayList;
import java.util.List;

public class ManutencaoComposite implements ManutencaoComponent {
    private String nome;
    private List<ManutencaoComponent> components = new ArrayList<>();

    public ManutencaoComposite(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void add(ManutencaoComponent component) {
        components.add(component);
    }

    public void remove(ManutencaoComponent component) {
        components.remove(component);
    }

    @Override
    public void mostrarManutencao() {
        System.out.println("Manutenção composta: " + nome);
        for (ManutencaoComponent component : components) {
            component.mostrarManutencao();
        }
    }
}
