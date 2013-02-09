package com.scg.domain;

import com.scg.util.Address;
import com.scg.util.Name;

/**
 * Created with IntelliJ IDEA.
 * User: dcostinett
 * Date: 1/12/13
 * Time: 5:20 PM
 */
public class ClientAccount implements Account {

    /**
     * String with the name of the client,
     */
    private final String name;

    /**
     * Name of the contact person for this client.
     */
    private Name contact;

    /**
     * Client's mailing address
     */
    private Address address;

    public ClientAccount(String name, Name contact) {
        this.name = name;
        this.contact = contact;
    }

    /**
     * Creates a new instance of ClientAccount
     * @param name - String with the name of the client.
     * @param contact - Name of the contact person for this client.
     * @param address - Address of this client.
     */
    public ClientAccount(String name, Name contact, Address address) {
        this.name = name;
        this.contact = contact;
        this.address = address;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isBillable() {
        return true;
    }

    public Name getContact() {
        return contact;
    }

    public void setContact(Name contact) {
        this.contact = contact;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}


