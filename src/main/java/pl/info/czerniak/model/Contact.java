package pl.info.czerniak.model;

import java.util.List;
import java.util.Objects;

public class Contact {
    private String name;
    private String jid;

    public Contact(String name, String jid) {
        this.name = name;
        this.jid = jid;
    }

    public Contact(Contact contact) {
        this.jid = contact.getJid();
        this.name = contact.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJid() {
        return jid;
    }

    public void setJid(String jid) {
        this.jid = jid;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return name.equals(contact.name) &&
                jid.equals(contact.jid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, jid);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", jid='" + jid + '\'' + '}';
    }
}
