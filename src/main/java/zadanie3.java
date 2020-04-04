//Dopisz kolejne implementacje metod do klasy UserCriteriaDao i wyświetl ich rezultaty
// 1. findAllBornBetween()
// 2. findByEmail()
// 3. findAllByCityName(); tak aby obiekty user zawierały jednocześnie informacje o adresie
// 4. findAllByCountryAlias(); tak aby obiekty user zawierały informacje zawarte w tabeli user
// 5. TRUDNE findAllWhoBoughtProduct();

import dao.UserCriteriaDao;
import model.User;

import java.time.LocalDateTime;
import java.util.List;

public class zadanie3 {
    public static void main(String[] args) {
        UserCriteriaDao userCriteriaDao = new UserCriteriaDao();

      List<User>users = userCriteriaDao.findAllBornBetween(LocalDateTime.now().minusYears(20), LocalDateTime.now());
      users.forEach(user -> System.out.println(user.toString()));
    }
}
