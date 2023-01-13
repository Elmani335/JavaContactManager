import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import model.ModifierContacts;
import model.Contact;
import model.TrierContacts;
import model.search;

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
                case "4":
                    ModifierContacts.test();
                    break;
                case "5":
                    search();
                    break;
                case "q", "Q":
                    return;
                default:
                    System.out.println("Bro this is not an option you dumb or what ?");
                    break;
            }
        }
    }

    private static void trierContacts() throws Exception {
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

    private static void search() throws Exception {
        while (true) {
            search.searchmenu();
            String choix = _scan.nextLine();
            switch (choix) {
                case "1":

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":

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
        // code pour lister les contact de contacts.csv avec prenom: nom: date de naissance: email: tel: ajouter un compteur pour afficher le nombre de contacts
        try {
            BufferedReader br = new BufferedReader(new FileReader("contacts.csv"));
            String line;
            int compteur = 0;
            while ((line = br.readLine()) != null) {
                String[] contact = line.split(";");
                System.out.println("Name: " + contact[1] + " lastname: " + contact[0] + " Birthdate: " + contact[4]
                        + " Email: " + contact[2] + " Phone: " + contact[3]);
                compteur++;
            }
            System.out.println("Number of contacts: " + compteur);
            br.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

        }
    }

    private static void ajouterContact() throws IOException {
        //
            Contact c = new Contact();
            while (true) {
                System.out.println("Type last name");
                String lastName = _scan.nextLine();
                if (lastName.matches("^[A-Za-z]{3,20}$")) {
                    c.setNom(lastName);
                    break;
                } else {
                    System.out.println("Invalid last name! Last name should only contain letters");
                }
            }

        while (true) {
            System.out.println("Type first name");
            String firstName = _scan.nextLine();
            if (firstName.matches("^[A-Za-z]{3,20}$")) {
                c.setPrenom(firstName);
                break;
            } else {
                System.out.println("Invalid first name! First name should only contain letters");
            }
        }

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
        menus.add("4- Edit Contact");
        menus.add("5- Search Contact");
        menus.add("q- Quit");
        menus.add("===============");
        for (String menu : menus) {
            System.out.println(menu);
        }
    }

}