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

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
      User user5 = new User("User5", "Lastname5", "user5@mail.ru");
      user5.setCar(new Car("Pegeon", 2));
      userService.add(user5);

      User user6 = new User("User6", "Lastname6", "user6@mail.ru");
      user6.setCar(new Car("Renault", 6));
      userService.add(user6);

      User user7 = new User("User7", "Lastname7", "user7@mail.ru");
      user7.setCar(new Car("Ferary", 4));
      userService.add(user7);

      User user8 = new User("User8", "Lastname8", "user8@mail.ru");
      user8.setCar(new Car("Ferary", 4));
      userService.add(user8);

      User user9 = new User("User9", "Lastname9", "user9@mail.ru");
      user9.setCar(new Car("Ferary", 4));
      userService.add(user9);


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCar().getCar());
         System.out.println();
      }

      List<User> userAuto = userService.getUserModSer("Ferary", 4);

      for(User u: userAuto){
         System.out.println(u.getFirstName() + "  " + u.getLastName());
      }
      context.close();
   }
}
