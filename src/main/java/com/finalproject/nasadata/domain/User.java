package com.finalproject.nasadata.domain;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    private String id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private Boolean enabled;


    public User() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    @Column(name = "first_name")
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    @Column(name = "last_name")
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    @Column(name="username")
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    @Column(name="password")
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    @Column(name="email")
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Column(name = "enabled")
    public Boolean getEnabled() { return enabled; }
    public void setEnabled(Boolean enabled) { this.enabled = enabled; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
