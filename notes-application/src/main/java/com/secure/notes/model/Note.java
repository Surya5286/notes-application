package com.secure.notes.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Note {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text")
    private String content;

    private String ownerUsername;
}
