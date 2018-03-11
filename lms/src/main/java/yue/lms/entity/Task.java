/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yue.lms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Yue
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    
    @NotBlank
    @Column(name = "name")
    private String name;
    
    @NotBlank
    @Column(name = "description")
    private String description;
    
    @NotBlank
    @Column(name = "datefrom")
    private String datefrom;
    
    @NotBlank
    @Column( name = "dateto")
    private String dateto;
    
    @NotBlank
    @Column(name = "uusername")
    private String uusername; 
    
    @NotBlank
    @Column(name = "status")
    private String status = "active";
    
}
