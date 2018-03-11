/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yue.lms.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import yue.lms.entity.Task;

/**
 *
 * @author Yue
 */
public interface TaskRepository extends CrudRepository<Task, Long> {
    
    @Query("select t from Task t where t.uusername like ? and t.status = 'active'")
    List<Task> findByUsername(String un);
    
    @Modifying
    @Transactional
    @Query("update Task t set t.status = 'inactive' where t.id = ?")
    void findById(long i);
    
    @Modifying
    @Transactional
    @Query("update Task t set t.name = ?, t.description = ?, t.datefrom = ?, t.dateto = ? where t.id = ?")
    void edit(String name, String desc, String from, String to, long id);
    
    @Query("select t from Task t where t.id = ? ")
    Task findTask(long id);
}

