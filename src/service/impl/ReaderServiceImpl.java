package service.impl;

import models.DataBase;
import models.GenericId;
import models.Reader;
import service.ReaderService;

import java.util.List;
import java.util.Scanner;

public class ReaderServiceImpl implements ReaderService {
  Scanner scanner = new Scanner(System.in);
   DataBase dataBase = new DataBase();
    @Override
    public void saveReader(Reader reader) {
dataBase.readers.add(reader);
    }

    @Override
    public List<Reader> getAllReaders() {

        return dataBase.readers;
    }

    @Override
    public Reader getReaderById(Long id) {
        for (Reader reader: dataBase.readers) {
            if (reader.getId().equals(id)){
                return reader;
            }

        }  return null;
    }

    @Override
    public Reader updateReader(Long id, Reader reader) {
        for (Reader reader1 : dataBase.readers){
            if (reader1.getId().equals(id)){
                System.out.println("new Reader name");
                String name = scanner.next();
                reader1.setFullName(name);
                System.out.println("new email ");
                String email = scanner.next();
                reader1.setEmail(email);
                System.out.println("new phone Number");
                String number = scanner.next();
                reader1.setPhoneNumber(number);


            }
        }

        return null;
    }

    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {


    }
}
