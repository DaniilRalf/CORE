package com.example.core.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class UserData {

    private UUID uuid;
    private Long index;
    private Boolean is_active;
    private Timestamp create_at;
    private Timestamp update_at;
}
