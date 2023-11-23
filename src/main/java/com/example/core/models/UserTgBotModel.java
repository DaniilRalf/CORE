package com.example.core.models;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@Entity
@Table(name = "user_tg_bots")
public class UserTgBotModel {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "uuid")
    private UUID uuid;

    @NotNull
    @Column(name = "index")
    private Long index;

    @NotNull
    @Column(name = "is_active")
    private Boolean isActive;

    @NotNull
    @Column(name = "create_at")
    private Timestamp createdAt;

    @NotNull
    @Column(name = "update_at")
    private Timestamp updatedAt;

    @NotNull
    @Column(name = "specification_uuid")
    private UUID specificationUuid;

}
