package ui;

import model.ProblemBank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ProblemBankUi {
    private Scanner in = new Scanner(System.in);
    private boolean running = true;
    private ProblemBank problemBank;
    private static final Menu mainMenu = new Menu(Arrays.asList(
            "Add a new question",
            "Select questions",
            "exit the program"));
    private static final Menu addNewQuestionMenu = new Menu(Arrays.asList(
            "Add multiple choice question",
            "Add free response question"
    ));

    public ProblemBankUi() {
        problemBank = new ProblemBank(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        mainMenu();
    }


    private void mainMenu(){
        while(this.running){
            mainMenu.displayMenu();
            int sel = in.nextInt();
            switch(sel){
                case 1:
                    addNewQuestionMenu();
                    break;
                case 2:
                    selectQuestionsMenu();
                    break;
                case 3:
                    System.out.println("programmed exited");
                    this.running = false;
                default:
                    System.out.println("invalid entry, please try again");
            }
        }
    }

    private void addNewQuestionMenu() {
        boolean loop = true;
        while (loop) {
            loop = false;
            addNewQuestionMenu.displayMenu();
            int sel = in.nextInt();
            switch (sel) {
                case 1:
                    addNewMultipleChoiceMenu();
                    break;
                case 2:
                    addNewFreeResponseMenu();
                    break;
                default:
                    System.out.println("invalid entry, please try again");
                    loop = true;
            }
        }
    }

    private void addNewFreeResponseMenu() {
    }

    private void addNewMultipleChoiceMenu() {
    }

    private void selectQuestionsMenu() {
    }


    public static void main(String[] args) {
        new ProblemBankUi();
    }
}


