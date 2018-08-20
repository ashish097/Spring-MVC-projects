package com.javarticles.spring.integration.jdbc;

public class Article {
    private int id;
    private String name;
    private String tags;
    private String category;
    private String author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("id: ");
        sb.append(id).append(", name: ").append(name).append(", tags: ")
                .append(tags).append(", category: ").append(category)
                .append(", author").append(author);
        return sb.toString();
    }
}
