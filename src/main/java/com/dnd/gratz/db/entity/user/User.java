package com.dnd.gratz.db.entity.user;

import com.dnd.gratz.db.entity.BaseEntity;
import com.dnd.gratz.db.entity.common.Code;
import com.dnd.gratz.db.entity.event.Event;
import com.dnd.gratz.db.entity.event.Scrap;
import com.dnd.gratz.db.entity.message.Message;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user", schema = "gratsz")
public class User extends BaseEntity {

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="code")
    Code code;

    @Column(name="email", length = 45)
    String email;

    @Column(name="nick_name", length = 15)
    String nickName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_date")
    java.util.Date createdDate;

    @JsonManagedReference
    @OneToMany(mappedBy="user", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    List<LoginLog> loginLog;

    @JsonManagedReference
    @OneToMany(mappedBy="user", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    List<Event> event;

    @JsonManagedReference
    @OneToMany(mappedBy="user", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    List<Scrap> scrap;

    @JsonManagedReference
    @OneToMany(mappedBy="user", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    List<Message> message;

    @Builder
    public User(String email, String nickName) {
        Date now = new Date();
        this.email = email;
        this.nickName = nickName;
        this.createdDate = now;
    }

    public User update(String nickName) {
        this.nickName = nickName;
        return this;
    }
}
