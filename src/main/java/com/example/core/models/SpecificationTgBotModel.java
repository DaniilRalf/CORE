package com.example.core.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "specification_tg_bots")
public class SpecificationTgBotModel {

    @Id
    @Column(name = "uuid", nullable = false)
    private String uuid;

    @Column(name = "name_bot", nullable = false)
    private String nameBot;

}
