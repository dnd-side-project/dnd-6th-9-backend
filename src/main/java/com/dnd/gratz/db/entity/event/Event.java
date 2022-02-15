package com.dnd.gratz.db.entity.event;

import com.dnd.gratz.db.entity.BaseEntity;
import com.dnd.gratz.db.entity.common.Code;
import com.dnd.gratz.db.entity.message.Message;
import com.dnd.gratz.db.entity.user.User;
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
@Table(name="event", schema="gratz")
public class Event extends BaseEntity {

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="code")
    Code code;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="user")
    User user;

    @Column(name="event_name", length = 45)
    String eventName;

    @Column(name="event_description", length = 200)
    String eventDescription;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="event_date")
    java.util.Date eventDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_date")
    java.util.Date createdDate;

    @JsonManagedReference
    @OneToMany(mappedBy="event", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    List<Scrap> scrap;

    @JsonManagedReference
    @OneToMany(mappedBy="event", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    List<Message> message;
}
