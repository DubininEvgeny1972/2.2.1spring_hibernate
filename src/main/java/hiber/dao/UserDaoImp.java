package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      if(user.getCar() != null) {
         sessionFactory.getCurrentSession().save(user.getCar());
      }
      sessionFactory.getCurrentSession().save(user);

   }


   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public List<User> getUserModSer(String mod, int ser) {
      List<User> users = new ArrayList<>();
      Query query = sessionFactory.getCurrentSession()
              .createQuery("FROM Car where car = :param1 and series = :param2");
      query.setParameter("param1", mod);
      query.setParameter("param2", ser);
      List<Car> cars = query.getResultList();
      Query query1 = sessionFactory.getCurrentSession()
              .createQuery("FROM User where car_id = :param1");
      for (Car c: cars){
         query1.setParameter("param1", c.getId());
         users.add((User) query1.getResultList().get(0));
      }
      return users;
   }
}
