package mvc;

import mvc.controller.Controller;
import mvc.model.ManutencaoModel;
import mvc.view.ManutencaoView;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author thiag
 */

public class Main {
    public static void main(String[] args) {
        ManutencaoModel model = new ManutencaoModel();
        ManutencaoView view = new ManutencaoView(model, null);
        Controller controller = new Controller(view, model);
        view.createView();
        model.setNews("Manutenção preventiva necessária");
    }
}