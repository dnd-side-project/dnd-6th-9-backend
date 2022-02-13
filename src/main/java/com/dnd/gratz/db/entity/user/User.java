package com.dnd.gratz.db.entity.user;

import com.dnd.gratz.db.entity.common.Code;
import com.dnd.gratz.db.entity.event.Event;
import com.dnd.gratz.db.entity.event.Scrap;
import com.dnd.gratz.db.entity.message.Message;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user", schema = "gratsz")
public class User {

    @Id
    @Column(name="user_id")
    String userId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="code")
    Code code;

    @Column(name="email", length = 20)
    String email;

    @Column(name="nick_name", length = 8)
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
}
