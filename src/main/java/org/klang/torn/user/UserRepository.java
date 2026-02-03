package org.klang.torn.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
