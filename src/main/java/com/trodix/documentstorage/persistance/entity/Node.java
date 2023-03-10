package com.trodix.documentstorage.persistance.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "node")
public class Node {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long dbId;

    @NotNull
    private String uuid;

    @NotNull
    private String bucket;

    @NotNull
    private String directoryPath;

    @NotNull
    @Column(columnDefinition = "integer default 1")
    private int versions;

    @OneToOne(cascade = CascadeType.ALL)
    private Type type;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "node_aspect")
    private List<Aspect> aspects;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "node_property")
    private List<Property> properties;

}
