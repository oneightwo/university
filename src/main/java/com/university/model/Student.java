package com.university.model;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fullName")
    private String fullName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id", nullable = true)
    private Group group;

    @Column(name = "typeScholarship")
    private String typeScholarship;

    @Column(name = "dateReceipt")
    private String dateReceipt;

    @Transient
    private Long idGroup;

    public Student() {
    }

    public Student(String fullName, Group group, String typeScholarship, String dateReceipt) {
        this.fullName = fullName;
        this.group = group;
        this.typeScholarship = typeScholarship;
        this.dateReceipt = dateReceipt;
    }

    public Long getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Long idGroup) {
        this.idGroup = idGroup;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getTypeScholarship() {
        return typeScholarship;
    }

    public void setTypeScholarship(String typeScholarship) {
        this.typeScholarship = typeScholarship;
    }

    public String getDateReceipt() {
        return dateReceipt;
    }

    public void setDateReceipt(String dateReceipt) {
        this.dateReceipt = dateReceipt;
    }
}
