package com.projects.votingsystem.model;

import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant extends NamedEntity {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    private List<Menu> menu;

    @Column(name = "enabled")
    private boolean enabled;

    protected Restaurant(Integer id, String name) {
        super(id, name);
    }

    public Restaurant(){
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "menu=" + menu +
                '}';
    }
}
