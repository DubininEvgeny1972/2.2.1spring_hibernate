package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      User user4 = new User("User4", "Lastname4", "user4@mail.ru");

      Car car1 = new Car("Pegeon", 2);
      Car car2 = new Car("Renault", 6);
      Car car3 = new Car("Ferrary", 4);
      Car car4 = new Car("Audi", 5);

      user1.setCar(car1);
      user2.setCar(car2);
      user3.setCar(car3);
      user4.setCar(car4);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         if(user.getCar() != null) {
            System.out.println("Car = "+user.getCar().getCar());
         }

         System.out.println();
      }

      User userAuto = userService.getUserModSer("Ferrary", 4);

      System.out.println("Id = "+userAuto.getId());
      System.out.println("First Name = "+userAuto.getFirstName());
      System.out.println("Last Name = "+userAuto.getLastName());
      System.out.println("Email = "+userAuto.getEmail());
      System.out.println();
      context.close();
   }
}
