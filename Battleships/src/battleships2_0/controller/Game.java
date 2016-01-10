package battleships2_0.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import battleships2_0.model.Enemy;
import battleships2_0.model.Player;

/**
 * The Class ShipController.
 *
 * @author Tim Gustaw 4691684 Gruppe 4b
 * @author Lukas Michaelis 4699916 Gruppe 4b 13.12.2015 ShipController.java
 */
public class Game {
    private Scanner sc = new Scanner(System.in);
    /** The player. */
    private Player player;
    private Enemy enemy;
    /** The enemies hp. */
    private int enemiesHP;

    /**
     * Instantiates a new ship controller.
     */
    public Game() {
        // Generate Grids
        // Someday there will be a name input but this is going to be a problem
        // for future me
        this.player = new Player("Just a player :>", 30, "a1");
        this.enemy = new Enemy(10, 10);
        // Someday i will make this calculate itself

    }

    /**
     * Attack.
     */
    private void attack() {
        try {
            System.out.println(this.enemy.toString());
            System.out.println("You are attacking");
            System.out.println("Please enter coordinates");
            String userinput = this.sc.nextLine();

            System.out.println("Please enter 'X' for a hit or 'O' for no hit");
            String hit = this.sc.next();

            if (!Character.isAlphabetic(userinput.charAt(1))) {
                char cRow = userinput.charAt(0);
                int column = Character.getNumericValue(userinput.charAt(1));
                int row = enemy.detectChar(cRow);
                if (!(column > 10) || !(row > 10) || column < 0 || row < 0) {
                    if ((Character.toUpperCase((hit.charAt(0))) == 'X')) {
                        this.enemy.set(row, column, true);
                        this.attack();
                    } else if ((Character.toUpperCase((hit.charAt(0))) == '0')) {
                        this.enemy.set(row, column, false);
                    } else {
                        System.out.println("You have entered a wrong symbol");
                    }

                } else {
                    System.out.println("You entered a wrong value please redo!");

                }

            }
        } catch (InputMismatchException e) {
            System.out.println("You may have entered a wrong value. Please try again");
            this.attack();
        }
    }

    /**
     * Defend.
     */
    private void defend() {
        try {
            System.out.println(this.player.toString());
            System.out.println("You are defending");
            System.out.println("Please enter coordinates");
            String userinput = this.sc.nextLine();
            if (!Character.isAlphabetic(userinput.charAt(1))) {
                char cRow = userinput.charAt(0);
                int column = Character.getNumericValue(userinput.charAt(1));
                int row = player.detectChar(cRow);
                if (!(column > 10) || !(row > 10) || column < 0 || row < 0) {
                    if (this.player.takeHit(row, column)) {
                        System.out.println("Hit");
                        this.defend();
                    } else {
                        System.out.println("Miss");
                    }

                }

            } else {
                System.out.println("You entered a wrong value please redo!");

            }

        } catch (InputMismatchException e) {
            System.out.println("You may have entered a wrong value. Please try again");
            this.defend();
        }
    }

    /**
     * Reset hp.
     */
    private void resetHP() {
        this.enemiesHP = 30;
        this.player.setHitPoints(30);
    }

    /**
     * Play tha game. Method which runs the game, handles user input and decides
     * which methods are going to be used and how the game progresses.
     */
    public void start() {
        this.resetHP();
        boolean game = true;
        while (game) {
            if (this.player.getHitPoints() < 1) {
                System.out.println("You lost. Wanna play again? Y|N");
                String input = sc.nextLine();
                switch (input) {
                case "Y":
                    this.start();
                    break;
                case "N":
                    System.exit(0);
                    break;
                default:
                    System.out.println(
                            "You may have entered a wrong value." + " The programm will close now due to the coder "
                                    + "being lazy to implement a way to restart!");

                    break;
                }
            } else if (enemiesHP < 1) {
                System.out.println("You win. Wanna play again? Y|N");
                String input = sc.nextLine();
                switch (input) {
                case "Y":
                    this.start();
                    break;
                case "N":
                    System.exit(0);
                    break;
                default:
                    System.out.println(
                            "You may have entered a wrong value." + " The programm will close now due to the coder "
                                    + "being lazy to implement a way to restart!");
                    break;
                }
            } else {
                System.out.println("Please enter what you are going to do next:");
                System.out.println("Attack (A)| Defend (D) | EXIT (E)");
                String input = sc.nextLine();
                input = input.toUpperCase();
                switch (input) {
                case "ATTACK":
                case "A":
                    attack();
                    break;
                case "DEFEND":
                case "D":
                    defend();
                    break;
                case "EXIT":
                case "E":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong value!");
                    break;
                }
            }
        }
    }

}
