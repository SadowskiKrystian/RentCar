package com.ksprogramming;

import com.ksprogramming.model.Model;

public class Header {
    public static void showMenu() {
        System.out.println("Witamy w aplikacji do wynajmowania samochodow");
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("Wybierz z menu co chcesz zrobić:");
        System.out.println("1 - Dodaj samochód\n" +
                "2 - Znajdź samochód po danych\n" +
                "3 - Znajdz samochód po Id\n" +
                "4 - Zaktualizuj samochód\n" +
                "5 - Usun samochód\n" +
                "6 - Pokaż wszystkie samochody\n" +
                "------------------------\n" +
                "7 - Dodaj markę\n" +
                "8 - Znajdź markę po danych\n" +
                "9 - Znajdz markę po Id\n" +
                "10 - Zaktualizuj markę\n" +
                "11 - Usun markę\n" +
                "12 - Pokaż wszystkie marki\n" +
                "------------------------\n" +
                "13 - Dodaj model\n" +
                "14 - Znajdź model po danych\n" +
                "15 - Znajdz model po Id\n" +
                "16 - Zaktualizuj model\n" +
                "17 - Usun model\n" +
                "18 - Pokaż wszystkie modele\n" +
                "------------------------\n" +
                "19 - Dodaj pracownika\n" +
                "20 - Znajdź pracownika po danych\n" +
                "21 - Znajdz pracownika po Id\n" +
                "22 - Zaktualizuj pracownika\n" +
                "23 - Usun pracownika\n" +
                "24 - Pokaż wszystkich pracowników\n" +
                "------------------------\n" +
                "25 - Dodaj klienta\n" +
                "26 - Znajdź klienta po danych\n" +
                "27 - Znajdz klienta po Id\n" +
                "28 - Zaktualizuj klienta\n" +
                "29 - Usun klienta\n" +
                "30 - Pokaż wszystkich klientów\n" +
                "------------------------\n" +
                "31 - Dodaj informacje o wypożyczeniu\n" +
                "32 - Znajdź informacje o wypożyczeniu po danych\n" +
                "33 - Znajdz informacje o wypożyczeniu po Id\n" +
                "34 - Zaktualizuj informacje o wypożyczeniu\n" +
                "35 - Usun informacje o wypożyczeniu\n" +
                "36 - Pokaż wszystkie wypożyczenia\n" +
                "------------------------\n" +
                "37 - Zamknij aplikacje");
    }
    public static void displayRentInformation() {
        System.out.printf("%-15s", "Id:");
        System.out.printf("%-15s", "Id Auta:");
        System.out.printf("%-30s", "Start wynaj:");
        System.out.printf("%-30s", "Koniec wynaj:");
        System.out.printf("%-15s", "Id prac.:");
        System.out.printf("%-15s", "Id klienta:");
        System.out.printf("%-15s", "Typ:");
        System.out.printf("%-30s", "Nazwa firmy");
        System.out.printf("%-15s", "Numer tax");
        System.out.printf("%-15s", "Imię:");
        System.out.printf("%-15s", "Nazwisko:");
        System.out.printf("%-15s", "Pesel:");
        System.out.printf("%-15s", "Nr domu:");
        System.out.printf("%-15s", "Nr miesz.:");
        System.out.printf("%-25s", "Ulica:");
        System.out.printf("%-15s", "Miasto:");
        System.out.printf("%-15s", "Kod pocztowy:");
        System.out.println("");
    }
    public static void displayCustomer() {
        System.out.printf("%-15s", "Id:");
        System.out.printf("%-15s", "Typ:");
        System.out.printf("%-30s", "Nazwa firmy");
        System.out.printf("%-15s", "Numer tax");
        System.out.printf("%-15s", "Imię:");
        System.out.printf("%-15s", "Nazwisko:");
        System.out.printf("%-15s", "Pesel:");
        System.out.printf("%-15s", "Nr domu:");
        System.out.printf("%-15s", "Nr miesz.:");
        System.out.printf("%-25s", "Ulica:");
        System.out.printf("%-15s", "Miasto:");
        System.out.printf("%-15s", "Kod pocztowy:");
        System.out.println("");
    }
    public static void displayEmployee() {
        System.out.printf("%-15s", "Id:");
        System.out.printf("%-15s", "Imię:");
        System.out.printf("%-15s", "Nazwisko:");
        System.out.printf("%-15s", "Pesel:");
        System.out.printf("%-15s", "Nr domu:");
        System.out.printf("%-15s", "Nr miesz.:");
        System.out.printf("%-25s", "Ulica:");
        System.out.printf("%-15s", "Miasto:");
        System.out.printf("%-15s", "Kod pocztowy:");
        System.out.println("");
    }
    public static void displayCar() {
        System.out.printf("%-5s", "Id:");
        System.out.printf("%-15s", "Reg nr:");
        System.out.printf("%-30s", "Numer Vin:");
        System.out.printf("%-15s", "Data zakupu:");
        System.out.printf("%-15s", "Marka:");
        System.out.printf("%-15s", "Model:");
        System.out.println("");
    }
    public static void displayBrand() {
        System.out.printf("%-15s", "Id:");
        System.out.printf("%-15s", "Marka:");
        System.out.println("");
    }
    public static void displayModels() {
        System.out.printf("%-15s", "Id:");
        System.out.printf("%-15s", "Marka id:");
        System.out.printf("%-15s", "Model:");
        System.out.println("");
    }
}
