package com.scg.domain;

/**
 * Created with IntelliJ IDEA.
 * User: dcostinett
 * Date: 1/19/13
 * Time: 11:23 AM
 * <p/>
 * Encapsulates the concept of a non-billable account, such as sick leave, vacation,
 * or business development.
 */
public enum NonBillableAccount implements Account, Comparable<NonBillableAccount> {
    SICK_LEAVE("Sick Leave"),
    VACATION("Vacation"),
    BUSINESS_DEVELOPMENT("Business Development");


    private NonBillableAccount(String name) {
        this.name = name;
    }

    private final String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isBillable() {
        return false;
    }


    @Override
    public String toString() {
        return getName();
    }
}
