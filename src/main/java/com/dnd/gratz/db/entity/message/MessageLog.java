package com.dnd.gratz.db.entity.message;

import com.dnd.gratz.db.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "message")
@Table(name="message_log", schema = "gratsz")
public class MessageLog extends BaseEntity {

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="message")
    Message message;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="reg_date")
    java.util.Date regDate;
}
