package com.dnd.gratz.db.entity.event;

import com.dnd.gratz.db.entity.BaseEntity;
import com.dnd.gratz.db.entity.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="scrap", schema="gratz")
public class Scrap extends BaseEntity {

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="event")
    Event event;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="user")
    User user;
}
