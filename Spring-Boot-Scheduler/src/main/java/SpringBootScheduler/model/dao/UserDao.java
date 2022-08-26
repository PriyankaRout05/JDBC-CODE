package SpringBootScheduler.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBootScheduler.model.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
