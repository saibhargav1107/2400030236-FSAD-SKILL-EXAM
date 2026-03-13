package com.klef.fsad.exam.skill;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="library_data")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;

    @Column(name="issue_date")
    private Date issuedate;

    public Library() {
    }

    public Library(String name, String description, Date date) {
        this.name = name;
        this.description = description;
        this.issuedate = issuedate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getIssuedate() {
        return issuedate;
    }
}