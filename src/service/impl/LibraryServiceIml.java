package service.impl;

import models.DataBase;
import models.GenericId;
import models.Library;
import service.LibraryService;

import java.util.List;
import java.util.Scanner;

public class LibraryServiceIml implements LibraryService {
    Scanner scanner = new Scanner(System.in);
    DataBase dataBase1 = new DataBase();

    @Override
    public List<Library> saveLibrary(List<Library> libraries) {
        dataBase1.libraries.addAll(libraries);
        return libraries;
    }

    @Override
    public List<Library> getAllLibraries() {
        return dataBase1.libraries;
    }

    @Override
    public Library getLibraryById(Long id) {
        for (Library library : dataBase1.libraries) {
            if (library.getId().equals(id)) {
                return library;
            } else
                System.out.println("notFound");

        }
        return null;
    }

    @Override
    public Library updateLibrary(Long id, Library library) {
        for (Library getLibrary : DataBase.libraries) {
            if (getLibrary.getId().equals(id)){
                System.out.println("Enter new Library name: ");
                String name = scanner.nextLine();
                library.setName(name);
                System.out.println("Enter new Library Address: ");
                String addres = scanner.nextLine();
                library.setAddress(addres);
                return library;
            }else
                System.out.println("Ne naydeno!");

        }
        return null;
    }

    @Override
    public String deleteLibrary(Long id) {
        for (Library library : dataBase1.libraries) {
            if (library.getId().equals(id)) {
                dataBase1.libraries.remove(library);
                return "Success deleted";
            }else
                System.out.println("notFound");
        }
        return null;
    }
}
