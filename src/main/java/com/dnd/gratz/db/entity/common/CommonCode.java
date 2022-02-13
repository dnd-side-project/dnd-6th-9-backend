package com.dnd.gratz.db.entity.common;

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
@Table(name="common_code", schema="gratz")
public class CommonCode {

    @Id
    @Column(name="common_code", length=3)
    String commonCode;

    @Column(name="common_name")
    String commonName;

    @JsonManagedReference
    @OneToMany(mappedBy="commonCode", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    List<Code> code;
}
