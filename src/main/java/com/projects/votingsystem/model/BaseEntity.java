package com.projects.votingsystem.model;


import com.projects.votingsystem.HasId;

public abstract class BaseEntity implements HasId{

    public static final int START_SEQ = 100000;

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    protected BaseEntity(Integer id) {
        this.id = id;
    }

    protected BaseEntity() {
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                '}';
    }
}
