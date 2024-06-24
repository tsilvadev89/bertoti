/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singleton;

/**
 *
 * @author thiag
 */
public class Manutencao {
    private static Manutencao instance;
    private String tipo;

    // Construtor privado para impedir instância externa
    private Manutencao() {}

    // Método estático para obter a instância única da classe
    public static Manutencao getInstance() {
        if (instance == null) {
            instance = new Manutencao();
        }
        return instance;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void iniciarManutencao() {
        System.out.println("Iniciando manutenção do tipo: " + tipo);
    }

    public void finalizarManutencao() {
        System.out.println("Finalizando manutenção do tipo: " + tipo);
    }
}
