/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.view;

/**
 *
 * @author thiag
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mvc.controller.ManutencaoControllerInterface;
import mvc.model.ManutencaoObserver;
import mvc.model.ManutencaoSubject;

public class ManutencaoView implements ManutencaoObserver, ActionListener {
    private ManutencaoSubject model;
    private ManutencaoControllerInterface controller;
    private String noticia;

    public ManutencaoView(ManutencaoSubject model, ManutencaoControllerInterface controller) {
        this.model = model;
        this.controller = controller;
        model.registerObserver(this);
    }

    @Override
    public void update(String noticia) {
        this.noticia = noticia;
        display();
    }

    public void createView() {
        // Implementação para criar a interface gráfica
    }

    public void display() {
        System.out.println("Notícia de manutenção: " + noticia);
    }

    public void habilitarBotaoAssinar() {
        // Implementação para habilitar botão
    }

    public void desabilitarBotaoAssinar() {
        // Implementação para desabilitar botão
    }

    public void habilitarBotaoCancelar() {
        // Implementação para habilitar botão
    }

    public void desabilitarBotaoCancelar() {
        // Implementação para desabilitar botão
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        switch (action) {
            case "assinar":
                controller.assinar();
                break;
            case "cancelar":
                controller.cancelar();
                break;
            case "sair":
                controller.sair();
                break;
        }
    }
}