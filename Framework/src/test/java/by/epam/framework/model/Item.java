package by.epam.framework.model;

import java.util.Objects;

public class Item {
    private String name;
    private String url;

    public Item(String url) {
        this.url = url;
    }

    public Item(String url, String name ) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return Objects.equals(getName(), item.getName()) &&
                Objects.equals(getUrl(), item.getUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getUrl());
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}

