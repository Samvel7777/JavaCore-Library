package sample;


import sample.model.Book;
import sample.storage.DataStorage;

import java.util.Scanner;

public class BookTest implements Commands{
    private static Scanner scanner = new Scanner(System.in);
    private static DataStorage dataStorage = new DataStorage();

    public static void main(String[] args) {

        boolean isRun = true;
        while (isRun) {
            showCommand();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_BOOK:
                    addBook();
                    break;
                case SEARCH_BY_TITLE:
                    searchBookByTitle();
                    break;
                default:
                    System.out.println("Wrong command!");
                    break;

            }
        }
    }

    private static void showCommand() {
        System.out.println("Please input " + EXIT + " for EXIT");
        System.out.println("Please input " + ADD_BOOK + " for ADD BOOK");
        System.out.println("Please input " + SEARCH_BY_TITLE + " for SEARCH BOOK BY TITLE");
    }

    private static void addBook() {
        System.out.println("Please input Book data:");
        System.out.println("Title");
        String title = scanner.nextLine();
        System.out.println("Author Name");
        String authorName = scanner.nextLine();
        System.out.println("Price");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Count");
        int count = Integer.parseInt(scanner.nextLine());
        Book book = new Book(title, authorName, price, count);
        dataStorage.add(book);
        System.out.println("Book was added");
    }

    private static void searchBookByTitle() {
        System.out.println("Please input title for search");
        String searchTitle = scanner.nextLine();
        Book searchBook = dataStorage.getBookByTitle(searchTitle);
        if (searchBook == null) {
            System.out.println("Book with " + searchTitle + " title does not exists");
        } else {
            System.out.println(searchBook);
        }
    }

}



