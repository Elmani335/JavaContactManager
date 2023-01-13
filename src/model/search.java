package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
// file to search in contacts.csv
public class search {
    public static void sortsearch(String[] args) throws Exception {

    }

    public static void searchmenu() {
        ArrayList<String> menuSort = new ArrayList<>();
        menuSort.add("==== SEARCH ====");
        menuSort.add("1- Search by name");
        menuSort.add("2- Search by last name");
        menuSort.add("3- Search by date of birth");
        menuSort.add("4- Search by email");
        menuSort.add("5- Search by phone number");
        menuSort.add("0- Return to main menu");
        menuSort.add("===============");
        for (String menusort : menuSort) {
            System.out.println(menusort);
        }
    }
// make 5 search methods
public static ArrayList<String> searchByName(String name) {
    ArrayList<String> results = new ArrayList<>();
    try {
        BufferedReader csvReader = new BufferedReader(new FileReader("contacts.csv"));
        String row;
        while ((row = csvReader.readLine()) != null) {
            if (row.contains(name)) {
                results.add(row);
            }
        }
        csvReader.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return results;
}

    public static ArrayList<String> searchByLastName(String lastname) {
        ArrayList<String> results = new ArrayList<>();
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader("contacts.csv"));
            String row;
            while ((row = csvReader.readLine()) != null) {
                if (row.contains(lastname)) {
                    results.add(row);
                }
            }
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }

    public static ArrayList<String> searchByDOB(String dob) {
        ArrayList<String> results = new ArrayList<>();
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader("contacts.csv"));
            String row;
            while ((row = csvReader.readLine()) != null) {
                if (row.contains(dob)) {
                    results.add(row);
                }
            }
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }

}



