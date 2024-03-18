import models.*;
import service.BookService;
import service.LibraryService;
import service.ReaderService;
import service.impl.BookServiceImpl;
import service.impl.LibraryServiceIml;
import service.impl.ReaderServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nurtilek
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        DataBase dataBase = new DataBase();
        List<Book> books = new ArrayList<>(Arrays.asList(
                new Book(GenericId.genericBookId(), "Russki", "Nurmuhammed", Genre.MILITARY),
                new Book(GenericId.genericBookId(), "Dene tarbiya", "Nurmuhammed", Genre.ROMANTIC),
                new Book(GenericId.genericBookId(), "fizika", "Nurmuhammed", Genre.ROMANTIC),
                new Book(GenericId.genericBookId(), "Zima ne budet", "Arstan Alay", Genre.SPORT),
                new Book(GenericId.genericBookId(), "Chyk eshike", "Soke", Genre.SPORT)
        ));
        List<Reader> readers = new ArrayList<>(Arrays.asList(
                new Reader(GenericId.genericreaderId(), "Nurmuhammed", "nur@gmail.com", "+996220180752", Gender.MALE),
                new Reader(GenericId.genericreaderId(), "Nurtilek", "nurti@gmail.com", "+996998868622", Gender.FEMALE)
        ));
        List<Library> libraryList = new ArrayList<>(Arrays.asList(
                new Library(GenericId.genericlibraryId(), "Java 13", "Peaksoft", books),
                new Library(GenericId.genericlibraryId(), "Nur", "Dordoy", books),
                new Library(GenericId.genericlibraryId(), "Nurti", "kyzyl Asker", books),
                new Library(GenericId.genericlibraryId(), "Staff", "grajdanskaya 119", books)
        ));
       DataBase .libraries.addAll(libraryList);
       DataBase.books.addAll(books);
       DataBase.readers.addAll(readers);

        LibraryService libraryService = new LibraryServiceIml();
        BookService bookService = new BookServiceImpl();
        ReaderService readerService = new ReaderServiceImpl();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome!");
        boolean mainwhile = true;
        while (mainwhile) {
            System.out.println("""
                    1.Library
                    2.Book
                    3.Reader
                    """);
            int main = scanner.nextInt();
            switch (main) {
                case 1:
                    boolean whilee = true;
                    while (whilee) {
                        System.out.println("""
                                1.Add Library
                                2.Get all Library
                                3.Get Library by Id
                                4.Update Library
                                5.Delete Library
                                6.Exit
                                """);
                        int libraryscanner = scanner.nextInt();
                        switch (libraryscanner) {
                            case 1 -> {
                                Library library = new Library(books);
                                System.out.println("Enter Name: ");
                                String name = scanner.next();
                                library.setName(name);
                                System.out.println("Enter Address: ");
                                String address = scanner.next();
                                library.setAddress(address);
                                System.out.println(libraryService.saveLibrary(List.of(library)));
                            }
                            case 2 -> System.out.println(libraryService.getAllLibraries());

                            case 3 -> {
                                System.out.println("Enter id Libraries: ");
                                Long id = scanner.nextLong();
                                System.out.println(libraryService.getLibraryById(id));
                            }
                            case 4 -> {
                                System.out.println("Enter id Library");
                                Long id = scanner.nextLong();
                                System.out.println(libraryService.updateLibrary(id, new Library(books)));
                            }
                            case 5 -> {
                                System.out.println("Enter id Library: ");
                                Long id = scanner.nextLong();
                                System.out.println(libraryService.deleteLibrary(id));
                            }
                            case 6 -> whilee = false;

                            default -> System.out.println("Takoe chislo net!");
                        }
                    }
                    break;


                case 2:
                    boolean whileBook = true;
                    while (whileBook) {
                        System.out.println("""
                                1.Add Book
                                2.Get all Books
                                3.Get Book By id
                                4.Delete Books
                                5.Clear Books
                                6.Exit
                                """);
                        int bookscanner = scanner.nextInt();
                        switch (bookscanner) {
                            case 1 -> {
                                System.out.println("Enter id Library: ");
                                Long id = scanner.nextLong();
                                Book book = new Book(GenericId.genericBookId(), "Matematika", "Nurmuhammed", Genre.MILITARY);
                                book.setId(GenericId.genericBookId());
                                System.out.println("Enter Name Book: ");
                                String name = scanner.next();
                                book.setName(name);
                                System.out.println("Enter Author Book: ");
                                String author = scanner.next();
                                book.setAuthor(author);
                                System.out.println("       Gende: ");
                                System.out.println("romance/voina/novosti");
                                Genre genre = Genre.valueOf(scanner.next());
                                book.setGenre(genre);
                                System.out.println(bookService.saveBook(id, book));
                            }
                            case 2 -> {
                                System.out.println("Enter id Library: ");
                                Long id = scanner.nextLong();
                                System.out.println(bookService.getAllBooks(id));
                            }
                            case 3 -> {
                                System.out.println("Enter id Library: ");
                                Long id = scanner.nextLong();
                                System.out.println("Enter id Books");
                                Long id2 = scanner.nextLong();
                                System.out.println(bookService.getBookById(id, id2));
                            }
                            case 4 -> {
                                System.out.println("Enter id Library: ");
                                Long id = scanner.nextLong();
                                System.out.println("Enter id Books");
                                Long id2 = scanner.nextLong();
                                System.out.println(bookService.deleteBook(id, id2));
                            }
                            case 5 -> {
                                System.out.println("Ты точно хочешь удалить все книги?");
                                System.out.println("Enter Library id: ");
                                Long id = scanner.nextLong();
                                bookService.clearBooksByLibraryId(id);
                            }
                            case 6 -> whileBook = false;
                            default -> System.out.println("Aka mynday san jok!");

                        }
                    }
                    break;
                case 3:
                    boolean whilereader = true;
                    while (whilereader) {
                        System.out.println("""
                         1.Add Reader
                         2.Get All Readers
                         3.Get Reader By Id
                         4.Update Reader
                         5.Exit
                         """);
                        int readerscanner = scanner.nextInt();
                        switch (readerscanner) {
                            case 1 -> {
                                Reader reader = new Reader(readers);
                                reader.setId(GenericId.genericreaderId());
                                System.out.println("Enter Full Name: ");
                                String name = scanner.next();
                                reader.setFullName(name);
                                System.out.println("Enter E-mail: ");
                                String email = scanner.next();
                                reader.setEmail(email);
                                System.out.println("Enter Phone Number: (+996---)");
                                String ph = scanner.next();
                                reader.setPhoneNumber(ph);
                                System.out.println("Enter Gender: (Male/Female)");
                                Gender gender = Gender.valueOf(scanner.next());
                                reader.setGender(gender);
                                readerService.saveReader(reader);
                            }
                            case 2 -> System.out.println(readerService.getAllReaders());
                            case 3 -> {
                                System.out.println("Enter Reader Id: ");
                                Long id = scanner.nextLong();
                                System.out.println(readerService.getReaderById(id));
                            }
                            case 4 -> {
                                System.out.println("Enter Reader Id: ");
                                Long id = scanner.nextLong();
                                System.out.println(readerService.updateReader(id, new Reader(readers)));
                            }
                            case 5 -> whilereader = false;
                        }
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Надо выбрать цифры которые указаны!:");
            }
            }

        }
    }


