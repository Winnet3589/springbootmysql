package com.springbootmysql.repositories;

import com.springbootmysql.entity.AccountEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {


  List<AccountEntity> findByFirstNameStartsWith(String firstName);
}
