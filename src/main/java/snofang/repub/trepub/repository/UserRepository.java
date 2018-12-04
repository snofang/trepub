package snofang.repub.trepub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import snofang.repub.trepub.entity.UserEntity;


@Transactional
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	UserEntity findByUsername(String username);

	UserEntity findByEmail(String email);

}
