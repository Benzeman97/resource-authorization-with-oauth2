package com.benz.oauth2.entity;

import com.benz.oauth2.util.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="user58",schema = Schema.HR,uniqueConstraints = @UniqueConstraint(
        columnNames = "username"
))
@Getter
@Setter
public class User {

    @Id
    @SequenceGenerator(name="user_id_gen",sequenceName = Schema.HR+".user_id_seq2",initialValue = 1003,allocationSize = 1)
    @GeneratedValue(generator = "user_id_gen",strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id")
    private int userId;
    @Column(name = "username")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "enabled")
    private int active;
    @Column(name = "accountNonExpired")
    private int accNonExpired;
    @Column(name = "credentialsNonExpired")
    private int credentialNonExpired;
    @Column(name = "accountNonLocked")
    private int accNonLocked;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "role_user",
    joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "user_id")},
    inverseJoinColumns = {@JoinColumn(name = "role_id",referencedColumnName = "id")})
    private Set<Role> roles;

}
