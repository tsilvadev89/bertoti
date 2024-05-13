package view;

import java.util.Scanner;

public class MainView {
    private Scanner scanner;

    public MainView() {
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("===== Sistema de Manutenção de Equipamentos Industriais =====");
        System.out.println("Selecione uma opção:");
        System.out.println("1. Realizar Manutenção Preventiva");
        System.out.println("2. Realizar Manutenção Corretiva");
        System.out.println("3. Realizar Manutenção Preditiva");
        System.out.println("4. Sair");
    }

    public int getUserChoice() {
        System.out.print("Opção: ");
        return scanner.nextInt();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}