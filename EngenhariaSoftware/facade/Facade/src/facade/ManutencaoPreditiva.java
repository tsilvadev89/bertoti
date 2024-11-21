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

public class ManutencaoPreditiva implements ManutencaoComponent {
    private List<String> tipo;
    private int random;

    public ManutencaoPreditiva() {
        this.tipo = Arrays.asList("Análise de vibração", "Monitoramento contínuo");
        this.random = 3;
    }

    @Override
    public List<String> getTipo() {
        return tipo;
    }
}