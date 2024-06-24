/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observer;

/**
 *
 * @author thiag
 */
import java.util.ArrayList;
import java.util.List;

public class Equipamento {
    private int mes;
    private List<ManutencaoObserver> observers = new ArrayList<>();

    public void addObserver(ManutencaoObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ManutencaoObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (ManutencaoObserver observer : observers) {
            observer.update(mes);
        }
    }

    public void setMes(int mes) {
        this.mes = mes;
        notifyObservers();
    }
}
