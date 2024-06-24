/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.controller;

import mvc.model.ManutencaoSubject;
import mvc.view.ManutencaoView;

/**
 *
 * @author thiag
 */
public class ControllerTrial implements ManutencaoControllerInterface {
    private ManutencaoView view;
    private ManutencaoSubject model;

    public ControllerTrial(ManutencaoView view, ManutencaoSubject model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void assinar() {
        model.setNews("Assinatura de teste realizada");
        view.habilitarBotaoCancelar();
        view.desabilitarBotaoAssinar();
    }

    @Override
    public void cancelar() {
        model.setNews("Assinatura de teste cancelada");
        view.habilitarBotaoAssinar();
        view.desabilitarBotaoCancelar();
    }

    @Override
    public void sair() {
        System.exit(0);
    }
}