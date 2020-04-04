package dao;

import model.User;
import model.User_;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.List;

//       criteriaQuery.select(root).where(cb.gt(root.get("itemPrice"), 1000));
//       criteriaQuery.select(root).where(cb.lt(root.get("itemPrice"), 1000));
//       criteriaQuery.select(root).where(cb.like(root.get("itemName"), "%chair%"));
//       criteriaQuery.select(root).where(cb.between(root.get("itemPrice"), 100, 200));
//       criteriaQuery.select(root).where(cb.isNull(root.get("itemDescription")));
//       criteriaQuery.select(root).where(cb.isNotNull(root.get("itemDescription")));
public class UserCriteriaDao {
    Session session;
    CriteriaQuery<User> criteriaQuery;
    CriteriaBuilder criteriaBuilder;
    Root<User> user;

    private void confogureFrom() {
        session = HibernateUtil.getSessionFactory().openSession();
        criteriaBuilder = session.getCriteriaBuilder();
        criteriaQuery = criteriaBuilder.createQuery(User.class);
        user = criteriaQuery.from(User.class);

    }

    public List<User> findAllBornBetween(LocalDateTime date1, LocalDateTime date2) {
        confogureFrom();
        criteriaQuery.select(user).where(criteriaBuilder.between(user.get(User_.birthDate), date1, date2));
        TypedQuery<User> query = session.createQuery(criteriaQuery);
        List<User> users = query.getResultList();
        session.close();
        return users;

    }
}