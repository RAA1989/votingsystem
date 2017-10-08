package com.projects.votingsystem.model;


public class Restaurant extends NamedEntity {

    private Menu menu;

    private Integer votesCount;

    protected Restaurant(Integer id, String name, Menu menu, Integer votes) {
        super(id, name);
        this.menu = menu;
        this.votesCount = votes;
    }

    public Integer getVotesCount() {
        return votesCount;
    }

    public void setVotesCount(Integer votesCount) {
        this.votesCount = votesCount;
    }

    public Restaurant(){
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "menu=" + menu +
                '}';
    }
}
