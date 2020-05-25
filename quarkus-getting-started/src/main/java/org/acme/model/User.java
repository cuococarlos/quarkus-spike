package org.acme.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;

import static javax.persistence.GenerationType.SEQUENCE;

import io.quarkus.elytron.security.common.*;

@Entity
@Table(name = "test_user")
public class User extends PanacheEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name="SEQ_PROD", sequenceName = "SEQ_PROD", allocationSize = 1)
    @Column(name = "id")
    private Long id;
    
    @Column
    public String username;
    @Column 
    public String password;
    @Column
    public String role;
    @Email
    public String email;
    @Column
    public String phone;
    @Column
    public String position;
    @Column 
    public String entity;
    @Column 
    public String town;

    /**
     * Adds a new user in the database
     * @param username the user name
     * @param password the unencrypted password (it will be encrypted with bcrypt)
     * @param role the comma-separated roles
     */

    public User() {
    }

    public User(final String username, final String password, final String role,final String email) {
        
        this.username = username;
        this.password = BcryptUtil.bcryptHash(password);
        this.email = email;
    }
}
    
