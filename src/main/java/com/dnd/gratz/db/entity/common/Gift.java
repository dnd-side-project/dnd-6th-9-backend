package com.dnd.gratz.db.entity.common;


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
@Table(name="gift", schema="gratz")
public class Gift {

    @Id
    @Column(name="gift_id", length = 3)
    String giftId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="code")
    Code code;

    @Column(name="gift_name")
    String giftName;

    @Column(name="gift_image")
    String giftImage;

    @JsonManagedReference
    @OneToMany(mappedBy="gift", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    List<Message> message;
}
