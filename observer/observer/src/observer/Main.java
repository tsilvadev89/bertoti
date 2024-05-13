/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package observer;

/*
Subject representa o equipamento industrial que pode realizar manutenção. O EquipamentoObserver é o 
observador que será notificado quando a manutenção for realizada. A notificação é feita quando o 
método realizarManutencao() é chamado no Subject
*/

import java.util.ArrayList;
import java.util.List;

// Observador
interface Observer {
    void update(String message);
}

// Sujeito Observado
class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void realizarManutencao() {
        System.out.println("Realizando manutenção...");
        notifyObservers("Manutenção realizada.");
    }
}

// Observador Concreto
class EquipamentoObserver implements Observer {
    public void update(String message) {
        System.out.println("Equipamento: observei - - > " + message);
    }
}

// Classe principal para testar o padrão
public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();
        Observer observer = new EquipamentoObserver();
        subject.attach(observer);

        subject.realizarManutencao();
    }
}