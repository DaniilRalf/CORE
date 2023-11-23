package com.example.core.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@Entity
@Table(name = "user_tg_bots")
public class UserTgBotModel {

    @Id
    @Column(name = "uuid", nullable = false)
    private UUID uuid;

    @Column(name = "index", nullable = false)
    private Long index;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "create_at", nullable = false)
    private Timestamp createdAt;

    @Column(name = "update_at", nullable = false)
    private Timestamp updatedAt;

    @Column(name = "specification_uuid", nullable = false)
    private UUID specificationUuid;

}
