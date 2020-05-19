package pl.info.czerniak.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.*;

@XmlRootElement(name = "Contacts")
public class ContactList {
    @XmlElement(name = "Account")
    private String accountJID;
    @XmlElement(name = "Contact")
    private Set<Contact> contacts;
    @XmlElement(name = "Group")
    private List<ContactGroup> contactGroups;
    @XmlElement(name = "Bookmark URLs")
    private Set<BookmarkURL> bookmarkURLS;
    @XmlElement(name = "Bookmark Conferences")
    private Set<BookmarkConference> bookmarkConferences;

    public ContactList(){}

    public ContactList(String accountJID) {
        this.accountJID = accountJID;
        this.contacts = new HashSet<>();
        this.contactGroups = new LinkedList<>();
        this.bookmarkURLS = new HashSet<>();
        this.bookmarkConferences = new HashSet<>();
    }

    @XmlTransient
    public String getAccountJID() {
        return accountJID;
    }

    public void setAccountJID(String accountJID) {
        this.accountJID = accountJID;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public boolean addContactToList(Contact contact){
        if(contact != null && !this.contacts.contains(contact)){
            this.contacts.add(contact);
            return true;
        }
        return false;
    }

    public boolean addGroupToList(ContactGroup contactGroup){
        if(!this.contactGroups.contains(contactGroup)){
            this.contactGroups.add(contactGroup);
            return true;
        }
        return false;
    }

    public boolean addContactToGroup(Contact contact, ContactGroup contactGroup){
        if(contactGroup != null && contact != null){
            if(!this.contactGroups.contains(contactGroup)){
                contactGroup.addContact(contact);
                this.contactGroups.add(contactGroup);
                return true;
            }else if(this.contactGroups.contains(contactGroup)){
                this.contactGroups.get(contactGroups.indexOf(contactGroup)).addContact(contact);
                return true;
            }
        }
        return false;
    }

    public boolean removeContact(Contact contact){
        if(this.contacts.contains(contact)){
            return this.contacts.remove(contact);
        }
        return false;
    }

    public boolean removeContactGroup(ContactGroup contactGroup){
        if(this.contactGroups.contains(contactGroup)){
            return this.contactGroups.remove(contactGroup);
        }
        return false;
    }

    public boolean contains(Contact contact){
        return this.contacts.contains(contact);
    }

    public int getContactCount(){
        return this.contacts.size();
    }

    public int getGroupCount(){
        return this.contactGroups.size();
    }

    public Contact getContactByJID(String jid){
        for(Contact contact : contacts){
            if(contact.getJid().equals(jid)){
                return contact;
            }
        }
        return null;
    }

    public List<Contact> getContactsByName(String name){
        List<Contact> result = new LinkedList<>();
        for(Contact contact : contacts){
            if(contact.getName().contains(name)){
                result.add(contact);
            }
        }
        return result;
    }

    public List<ContactGroup> getGroups(){
        return this.contactGroups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactList that = (ContactList) o;
        return accountJID.equals(that.accountJID) &&
                Objects.equals(contacts, that.contacts) &&
                Objects.equals(bookmarkURLS, that.bookmarkURLS) &&
                Objects.equals(bookmarkConferences, that.bookmarkConferences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountJID, contacts, bookmarkURLS, bookmarkConferences);
    }
}
