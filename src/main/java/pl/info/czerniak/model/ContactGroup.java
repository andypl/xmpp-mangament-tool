package pl.info.czerniak.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.*;

public class ContactGroup {
    @XmlAttribute(name = "Name")
    private String name;
    @XmlElement(name = "Contact")
    private List<Contact> contacts;

    public ContactGroup(String name) {
        this.name = name;
        this.contacts = new LinkedList<>();
    }

    public Collection<Contact> getContacts() {
        return contacts;
    }

    public String getName() {
        return name;
    }

    public boolean removeContact(Contact contact){
        return this.contacts.remove(contact);
    }

    public boolean addContact(Contact contact){
        if(!this.contacts.contains(contact)){
            this.contacts.add(contact);
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactGroup that = (ContactGroup) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "ContactGroup{" +
                "name='" + name + '\'' +
                ", contacts=" + contacts +
                '}';
    }
}
