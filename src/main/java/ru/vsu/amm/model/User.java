package ru.vsu.amm.model;

import java.io.Serializable;
import java.util.Set;

/**
 * Class of users
 *{@value} count - general number of existing instances of this class
 *@author Alena Pominova
 *@version 1.0
 */

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private int user_id;
    private String fio;
    private String email;
    private String password;
    private String confirmPassword;
    private String description;
    private Role role;
    private Set<ParkingPlace> favoritePlaces;

    public User() {
    }

    public User(int user_id, String fio, String email, String password, String description) {
        this.user_id = user_id;
        this.fio = fio;
        this.email = email;
        this.password = password;
        this.description = description;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int id) {
        this.user_id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<ParkingPlace> getFavoritePlaces() {
        return favoritePlaces;
    }

    public void setFavoritePlaces(Set<ParkingPlace> favoritePlaces) {
        this.favoritePlaces = favoritePlaces;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (user_id != user.user_id) return false;
        if (!fio.equals(user.fio)) return false;

        return email.equals(user.email);
    }

    @Override
    public int hashCode() {
        int result = user_id;
        result = 31 * result + fio.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format(
                User.class.getSimpleName() + "[user_id=%d, fio='%s', email='%s']",
                user_id, fio, email);
    }
}