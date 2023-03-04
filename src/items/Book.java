package items;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Book {
    private String title;
    private String authorFullName;
    private int publishYear;
    private String publisherName;
    private Genre genre;
    private int countOfPages;

    public Book(String title, String authorFullName, int publishYear, String publisherName, Genre genre, int countOfPages) {
        this.title = title;
        this.authorFullName = authorFullName;
        this.publishYear = publishYear;
        this.publisherName = publisherName;
        this.genre = genre;
        this.countOfPages = countOfPages;
    }
    public Book() {
        var in = new Scanner(System.in);
        System.out.printf("Enter title:\t");
        this.title =  in.nextLine();
        System.out.printf("Enter authorFullName:\t");
        this.authorFullName =  in.nextLine();
        System.out.printf("Enter publishYear:\t");
        this.publishYear = Integer.parseInt(in.nextLine());
        System.out.printf("Enter publisherName:\t");
        this.publisherName =  in.nextLine();
        System.out.printf("Enter genre:\t");
        this.genre = new Genre(in.nextLine());
        System.out.printf("Enter countOfPages:\t");
        this.countOfPages =  in.nextInt();
    }

    public void print(PrintStream ps) {
        ps.print(this.toString());
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorFullName() {
        return authorFullName;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public final String getGenre() {
        return genre.getName();
    }

    public int getCountOfPages() {
        return countOfPages;
    }

    @Override
    public String toString() {
        return String.format("""
                Title =\t%s
                Author =\t%s
                Publisher =\t%s
                Publish year =\t%s
                Genre =\t%s
                Count pages =\t%s
                """, title, authorFullName, publisherName, publishYear, genre.name, countOfPages);
    }
}


