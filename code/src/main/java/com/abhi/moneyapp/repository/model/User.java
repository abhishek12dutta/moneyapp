package com.abhi.moneyapp.repository.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "app_users",uniqueConstraints = {
        @UniqueConstraint(columnNames = "user_username"),
        @UniqueConstraint(columnNames = "user_email") })
public class User {

    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "user_email", nullable = false)
    private String email;

    @Column(name = "user_username", nullable = true)
    private String username;

    @Column(name = "user_password", nullable = false)
    private String password;

    @Column(name = "created_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "user_active_status", columnDefinition = "TINYINT(1)")
    private boolean isActive;

//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY, optional = false)

//    @OneToOne(cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY, optional = false)
//    @JoinTable(name = "mapping_user_details",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_details_id"))
@OneToOne(cascade = CascadeType.ALL)
@JoinTable(name="app_user_details_mapping", joinColumns = @JoinColumn(name="USER_ID"), inverseJoinColumns = @JoinColumn(name="USER_DETAILS_ID"))
    private UserDetail userDetail;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "mapping_user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
