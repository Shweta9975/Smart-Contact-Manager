package com.scm.scm20.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.*;

@Entity(name= "user")
@Table(name="users")
//Lombok annotation
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
  
    @Id
    private String userId;
    @Column(name="user_name",nullable=false)
    private String name;
    @Column(unique=true,nullable=false)
    private String email;
    private String password;
    @Column(length=1000)
     private String about;
     @Column(length=1000)
     private String profilePic;
     private String phoneNumber;
     //information
     private boolean enable=false;
     private boolean emailVerified=false;
     private boolean phoneVerified=false;

     //SELF,GOOGLE,FACEBOOK,TWITTER,LINKEDIN,GITHUB
     private Providers provider=Providers.SELF;
     private String providerUserId;

     @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval = true)
     private List<Contact> contacts=new ArrayList<>();

    public static Object builder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'builder'");
    }

    
}
