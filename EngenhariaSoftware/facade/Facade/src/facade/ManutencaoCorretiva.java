/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

/**
 *
 * @author thiag
 */

import java.util.Arrays;
import java.util.List;

public class ManutencaoCorretiva implements ManutencaoComponent {
    private List<String> tipo;
    private int random;

    public ManutencaoCorretiva() {
        this.tipo = Arrays.asList("Reparo de falhas", "Troca de componentes danificados");
        this.random = 2;
    }

    @Override
    public List<String> getTipo() {
        return tipo;
    }
}