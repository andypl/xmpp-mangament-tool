package pl.info.czerniak.model;

import java.util.Objects;

public class BookmarkURL {
    private String name;
    private String url;

    public BookmarkURL(String name, String url) {
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
        if (o == null || getClass() != o.getClass()) return false;
        BookmarkURL that = (BookmarkURL) o;
        return name.equals(that.name) &&
                url.equals(that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url);
    }

    @Override
    public String toString() {
        return "BookmarkURL{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
