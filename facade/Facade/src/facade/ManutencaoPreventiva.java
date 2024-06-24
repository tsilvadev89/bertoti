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

public class ManutencaoPreventiva implements ManutencaoComponent {
    private List<String> tipo;
    private int random;

    public ManutencaoPreventiva() {
        this.tipo = Arrays.asList("Verificação de sistema", "Substituição de peças");
        this.random = 1;
    }

    @Override
    public List<String> getTipo() {
        return tipo;
    }
}