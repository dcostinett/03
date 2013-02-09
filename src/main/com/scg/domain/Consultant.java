package com.scg.domain;

import com.scg.util.Name;

/**
 * Created with IntelliJ IDEA.
 * User: dcostinett
 * Date: 1/12/13
 * Time: 5:38 PM
 * <p/>
 * A Consultant
 */
public class Consultant {
    private final Name name;

    /**
     * Creates a new instance of Consultant.
     *
     * @param name - consultant name
     */
    public Consultant(Name name) {
        this.name = name;
    }

    /**
     * Getter for the name property.
     *
     * @return value of consultant name
     */
    public Name getName() {
        return name;
    }

    @Override
    /**
     * Returns the string representation of the consultant's name.
     */
    public String toString() {
        return name.toString();
    }
}
