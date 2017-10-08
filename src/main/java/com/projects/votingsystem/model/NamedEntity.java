package com.projects.votingsystem.model;

public class NamedEntity extends BaseEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected NamedEntity(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public NamedEntity(){
    }

    @Override
    public String toString() {
        return "NamedEntity{" +
                "name='" + name + '\'' +
                '}';
    }
}
