package ui;

import java.util.List;

public class Menu {
    private List<String> content;

    public Menu(List<String> content) {
        this.content = content;
    }

    public void displayMenu() {
        for (int i = 0; i < content.size(); i++) {
            System.out.println((i + 1) + ". " + content.get(i));
        }
        System.out.println("Please enter a number that corresponds with one of the choices");
    }
}
