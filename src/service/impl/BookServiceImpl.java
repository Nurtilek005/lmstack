package service.impl;

import models.Book;
import models.DataBase;
import models.Library;
import service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    DataBase dataBase = new DataBase();

    @Override
    public Book saveBook(Long libraryId, Book book) {
        for (Library library : dataBase.libraries) {
            if (library.getId().equals(libraryId)) {
                library.getBooks().add(book);
            }else
                System.out.println("Library Not-Found!");
        }

        return book;
    }

    @Override
    public List<Book> getAllBooks(Long libraryId) {

        return dataBase.books;
    }

    @Override
    public Book getBookById(Long libraryId, Long bookId) {
      for (Library library: dataBase.libraries) {
          for (Book book : dataBase.books)

              if (library.getId().equals(libraryId) && book.getId().equals(bookId)) {
                  return book;

              } else
                  System.out.println("Not Found");

      }
        return null;
    }

    @Override
    public String deleteBook(Long libraryId, Long bookId) {
for(Library library: dataBase.libraries){
    for (Book book:dataBase.books )
        if (library.getId().equals(libraryId)&&book.getId().equals(bookId)){
            library.getBooks().remove(book);
        }
}
        return null;
    }

    @Override
    public void clearBooksByLibraryId(Long libraryId) {
        for (Library library : dataBase.libraries) {
            if (library.getId().equals(libraryId)) {
                library.getBooks().clear();
            }
        }
    }
}
