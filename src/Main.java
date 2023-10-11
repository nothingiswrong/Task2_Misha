import Repository.FileUserRepository;

public class Main {
   public static void main(String[] args) {
        var users = new FileUserRepository("src/Util/Users.csv").getAll();
        for (var u : users) {
           System.out.printf("\n%s %s %s\n", u.id, u.name, u.age);
        } 

   }
}
