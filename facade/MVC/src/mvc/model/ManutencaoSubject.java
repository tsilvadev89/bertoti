/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

/**
 *
 * @author thiag
 */
public interface ManutencaoSubject {
    void registerObserver(ManutencaoObserver observer);
    void removeObserver(ManutencaoObserver observer);
    void notifyObservers();
    void setNews(String noticia);
}