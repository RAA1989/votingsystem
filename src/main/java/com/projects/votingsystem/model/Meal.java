package com.projects.votingsystem.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;

@Entity
@Table(name = "meals")
public class Meal extends NamedEntity {

    @Column(name = "value")
    @Range(min = 5, max = 1000)
    private int value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    @JsonIgnore
    private Menu menu;

    public Meal(){
    }

    public Meal(Integer id, String name, int value) {
        super(id, name);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
