package Repository;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Entities.User;

public class FileUserRepository implements IUserRepository {
    private Scanner _scanner;
    private FileWriter _writer;
    private File _file;

    public FileUserRepository(String path) {
        _file = new File(path);

    }

    public void setFile(String path) {
        _file = new File(path);
    }

    private void initializeScanner() {
        try {

            _scanner = new Scanner(_file);
        } catch (Exception e) {
            System.out.println("File not found, try again!");
        }
    }

    private void initializeWriter() {
        try {

            _writer = new FileWriter(_file);
        } catch (Exception e) {
            System.out.println("File not found, try again!");
        }
    }

    @Override
    public void add(User user) {
        initializeWriter();
        var sb = new StringBuilder();
        sb.append(user.id);
        sb.append(',');
        sb.append(user.age);
        sb.append(',');
        sb.append(user.name);
        try {
            _writer.write(sb.toString());
        } catch (Exception ex) {
            ///
        }
    }

    @Override
    public List<User> getAll() {
        initializeScanner();
        var users = new ArrayList<User>();
        while (_scanner.hasNextLine()) {
            var fields = _scanner.nextLine().split(",");
            var user = new User();
            user.id = Integer.parseInt(fields[0]);
            user.name = fields[1];
            user.age = Integer.parseInt(fields[2]);
            users.add(user);
        }

        return users;
    }

}
