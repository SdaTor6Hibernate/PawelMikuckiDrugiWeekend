import model.Address;
import model.Country;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

public class przyklad6 {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Address> query = builder.createQuery(Address.class);
        Root<Address> addressRoot = query.from(Address.class);
        Join<Address, Country> country = addressRoot.join("country");
        query.select(addressRoot).where(builder.like(country.get("alias"),"PL"));


        TypedQuery<Address> q = session.createQuery(query);
        List<Address> addressList = q.getResultList();
        addressList.forEach(address -> System.out.println(address.getCity()));
        session.close();
    }
}
