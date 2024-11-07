package springboot.springbootdemo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import springboot.springbootdemo.model.User;


public interface UserRepository extends JpaRepository<User, Long>{

}
