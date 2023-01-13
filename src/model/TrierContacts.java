package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class TrierContacts {
    public static void sortmenu(String[] args) throws Exception {

    }

    public static void MenuTrieur() {
        ArrayList<String> menuSort = new ArrayList<>();
        menuSort.add("==== SORTING ====");
        menuSort.add("1- Sort by name");
        menuSort.add("2- Sort by date of birth");
        menuSort.add("3- Sort by email");
        menuSort.add("0- Return to main menu");
        menuSort.add("===============");
        for (String menusort : menuSort) {
            System.out.println(menusort);
        }
    }

    // Récuperer la liste de contacts puis la trier par nom et prénom (si ils ont le
    // même nom). Vous devrez obligatoirement utiliser la méthode sort de la classe
    // Collections pour faire le tri. Vous devrez également utiliser l'interface
    // Comparable pour créer le comparateur par défaut de la class Contact.
    /**
     *
     */
    public static void SortContactsName() {
        ArrayList<Contact> contacts = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("contacts.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] contact = line.split(";");
                Contact c = new Contact();
                c.setNom(contact[0]);
                c.setPrenom(contact[1]);
                c.setMail(contact[2]);
                c.setTelephone(contact[3]);
                c.setDateNaissance(contact[4]);
                contacts.add(c);
            }
            Collections.sort(contacts, new Comparator<Contact>() {
                @Override
                public int compare(Contact c1, Contact c2) {
                    return c1.getNom().toLowerCase().compareTo(c2.getNom().toLowerCase());
                }
            });
            br.close();
            System.out.println("Contacts triés par nom :");
            for (Contact contact : contacts) {
                System.out.println(contact.getNom()
                        + "; " + contact.getPrenom()
                        + "; " + contact.getMail()
                        + "; " + contact.getTelephone()
                        + "; " + contact.getDateNaissance());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(" ");
        System.out.println("Choisissez une option disponible dans le menu suivant petit malin :");
    }

    /**
     *
     */
    public static void SortContactsDateOfBirth() {

        ArrayList<Contact> contacts = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("contacts.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] contact = line.split(";");
                Contact c = new Contact();
                c.setNom(contact[0]);
                c.setPrenom(contact[1]);
                c.setMail(contact[2]);
                c.setTelephone(contact[3]);
                c.setDateNaissance(contact[4]);
                contacts.add(c);
            }
            extracted(contacts);
            br.close();
            // Tri par date de naissance
            contacts.sort(Comparator.comparing(Contact::getDateNaissance).reversed());
            // Affichage trié par date de naissance
            System.out.println("Contacts triés par date de naissance :");
            for (Contact contact : contacts) {
                System.out.println("Nom : " + contact.getNom() + ", Prénom : " + contact.getPrenom() +
                        " Date de naissance : " + contact.getDateNaissance());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(" ");
        System.out.println("Choisissez une option disponible dans le menu suivant petit malin :");

    }

    public static void SortContactsEmail() {
        ArrayList<Contact> contacts = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("contacts.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] contact = line.split(";");
                Contact c = new Contact();
                c.setNom(contact[0]);
                c.setPrenom(contact[1]);
                c.setMail(contact[2]);
                c.setTelephone(contact[3]);
                c.setDateNaissance(contact[4]);
                contacts.add(c);
            }
            Collections.sort(contacts, new Comparator<Contact>() {
                @Override
                public int compare(Contact c1, Contact c2) {
                    return c1.getMail().toLowerCase().compareTo(c2.getMail().toLowerCase());
                }
            });
            br.close();
            System.out.println("Contacts triés par email :");
            for (Contact contact : contacts) {
                System.out.println(contact.getNom()
                        + "; " + contact.getPrenom()
                        + "; " + contact.getMail()
                        + "; " + contact.getTelephone()
                        + "; " + contact.getDateNaissance());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(" ");
        System.out.println("Choisissez une option disponible dans le menu suivant petit malin :");

    }

    private static void extracted(ArrayList<Contact> contacts) {
        Collections.sort(contacts, new Comparator<Contact>() {
            @Override
            public int compare(Contact c1, Contact c2) {
                return c1.getDateNaissance().compareTo(c2.getDateNaissance());
            }
        });
    }

}