/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yue.lms.repository;

import org.springframework.data.repository.CrudRepository;
import yue.lms.entity.User;

/**
 *
 * @author Yue
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}

