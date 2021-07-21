package com.example.springioc.event;

public class AnotherEvent {
    private Integer id;
    private String title;

    public AnotherEvent(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "AnotherEvent{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
