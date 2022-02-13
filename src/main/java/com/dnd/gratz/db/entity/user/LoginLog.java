package com.dnd.gratz.db.entity.user;

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
@ToString(exclude = "user")
@Table(name="login_log", schema = "gratsz")
public class LoginLog extends BaseEntity {
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="user")
    User user;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="reg_date")
    java.util.Date regDate;
}
