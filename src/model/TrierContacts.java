package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class TrierContacts {
    private static Scanner _scan = new Scanner(System.in);
    public static void sortmenu(String[] args) throws Exception {

}
    public static void MenuTrieur(){
        ArrayList<String> menuSort=new ArrayList<>();
        menuSort.add("==== SORTING ====");
        menuSort.add("1- Sort by name");
        menuSort.add("2- Sort by date of birth");
        menuSort.add("3- Sort by email");
        menuSort.add("0- Return to main menu");
        menuSort.add("===============");
        for(String menusort:menuSort){
            System.out.println(menusort);
        }
    }


    // Récuperer la liste de contacts puis la trier par nom et prénom (si ils ont le même nom). Vous devrez obligatoirement utiliser la méthode sort de la classe Collections pour faire le tri. Vous devrez également utiliser l'interface Comparable pour créer le comparateur par défaut de la class Contact.
    public static void SortContactsName() {
        ArrayList<Contact> list = new ArrayList<>();
        Collections.sort(list, new Comparator<Contact>() {
            @Override
            public int compare(Contact o1, Contact o2) {
                return o1.getNom().compareTo(o2.getNom());
            }
        });
        System.out.println("Liste triée par nom");
    }
}