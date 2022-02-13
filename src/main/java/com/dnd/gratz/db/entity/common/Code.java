package com.dnd.gratz.db.entity.common;

import com.dnd.gratz.db.entity.event.Event;
import com.dnd.gratz.db.entity.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "commonCode")
@Table(name="code", schema = "gratsz")
public class Code {

    @Id
    @Column(name="code", length=3)
    String code;

    @Column(name="name")
    String name;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="common_code")
    CommonCode commonCode;

    @Column(name="user_yn")
    boolean useYn;

    @JsonManagedReference
    @OneToMany(mappedBy="code", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    List<Gift> gift;

    @JsonManagedReference
    @OneToMany(mappedBy="code", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    List<User> user;

    @JsonManagedReference
    @OneToMany(mappedBy="code", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    List<Event> event;
}
