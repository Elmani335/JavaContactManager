import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Contact;
import model.TrierContacts;



public class App {

    private static Scanner _scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        while (true) {
            afficherMenu();
            String choix = _scan.nextLine();
            switch (choix) {
                case "1":
                    ajouterContact();
                    break;
                case "2":
                    listerContacts();
                    break;
                case "3":
                    trierContacts();
                    break;
                case "q", "Q":  
                    return;
                default:
                    System.out.println("Bro this is not an option you dumb or what ?");
                    break;
            }
        }
    }

    private static void trierContacts() throws IOException {
        TrierContacts c = new TrierContacts();
        while (true) {
            TrierContacts.MenuTrieur();
            String choix = _scan.nextLine();
            switch (choix) {
                case "1":
                    TrierContacts.SortContactsName();
                    break;
                case "2":
                    TrierContacts.SortContactsDateOfBirth();
                    break;
                case "3":
                    TrierContacts.SortContactsEmail();
                    break;
                case "0":
                    //
                   System.out.println("Returning to main menu");
                    return;
                default:
                    System.out.println("Bro this is not an option you dumb or what ?");
                    break;
            }
        }

    }

    private static void listerContacts() {
        ArrayList<Contact> list = new ArrayList<>();// récupérer les contacts avec la méthode lister de la class contact
        for (Contact contact : list) {
            System.out.println(contact.getNom() + " " + contact.getPrenom());
        }
    }

    private static void ajouterContact() throws IOException {
        Contact c = new Contact();
        System.out.println("Type last name");
        c.setNom(_scan.nextLine());

        System.out.println("Type first name");
        c.setPrenom(_scan.nextLine());

        while (true) {
            try {
                System.out.println("Type the email");
                c.setMail(_scan.nextLine());
                break;
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Type the phone number");
                c.setTelephone(_scan.nextLine());
                break;
            } catch (ParseException e) {
                System.out.println("Invalid number");
            }
        }

        while (true) {
            try {
                System.out.println("Type the date of birth");
                c.setDateNaissance(_scan.nextLine());
                break;
            } catch (ParseException e) {
                System.out.println("Wrong birthdate!");
            }
        }
        c.enregistrer();

        System.out.println("Contact saved");

    }

    private static void afficherMenu() {
        ArrayList<String> menus = new ArrayList<>();
        menus.add("==== MENU ====");
        menus.add("1- Add a contact");
        menus.add("2- List all contacts");
        menus.add("3- Sort contacts");
        menus.add("q- Quit");
        menus.add("===============");
        for (String menu : menus) {
            System.out.println(menu);
        }
    }


}