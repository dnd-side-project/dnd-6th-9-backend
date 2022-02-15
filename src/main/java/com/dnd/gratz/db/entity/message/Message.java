package com.dnd.gratz.db.entity.message;

import com.dnd.gratz.db.entity.BaseEntity;
import com.dnd.gratz.db.entity.common.Gift;
import com.dnd.gratz.db.entity.event.Event;
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
@Table(name="message", schema="gratz")
public class Message extends BaseEntity {

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="event")
    Event event;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="gift")
    Gift gift;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="user")
    User user;

    @Column(name="content", columnDefinition = "TEXT")
    String content;

    @Column(name="image_url", length = 200)
    String imageUrl;

    @Column(name="public_yn")
    boolean publicYn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="open_date")
    java.util.Date openDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_date")
    java.util.Date createdDate;

    @JsonManagedReference
    @OneToMany(mappedBy="message", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    List<MessageLog> messagelog;
}
