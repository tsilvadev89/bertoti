/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

/**
 *
 * @author thiag
 */
import java.util.ArrayList;
import java.util.List;

public class ManutencaoModel implements ManutencaoSubject {
    private List<ManutencaoObserver> observers;
    private String noticia;

    public ManutencaoModel() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(ManutencaoObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ManutencaoObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (ManutencaoObserver observer : observers) {
            observer.update(noticia);
        }
    }

    @Override
    public void setNews(String noticia) {
        this.noticia = noticia;
        notifyObservers();
    }

    public String getNews() {
        return noticia;
    }
}