package com.scg.domain;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: dcostinett
 * Date: 1/19/13
 * Time: 11:14 AM
 * <p/>
 * A consultants time, maintains date, skill, account and hours data.
 */
public class ConsultantTime {
    /**
     * The date this instance occurred.
     */
    private Date date;

    /**
     * The account to charge the hours to; either a Client or a NonBillableAccount.
     */
    private Account account;

    /**
     * The skill type.
     */
    private Skill skill;

    /**
     * The number of hours, which must be positive.
     */
    private int hours;

    /**
     * Determines if the account is billable.
     */
    private boolean billable;


    public ConsultantTime(Date date, Account account, Skill skill, int hours) {
        this.date = date;
        this.account = account;
        this.skill = skill;

        if (hours <= 0) {
            throw new IllegalArgumentException("Hours must be positive.");
        }
        this.hours = hours;

        billable = account.isBillable();
    }

    public Date getDate() {
        return date;
    }

    /**
     * @param date - New value of the property date.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) throws IllegalArgumentException {

        if (hours <= 0) {
            throw new IllegalArgumentException("Hours must be positive.");
        }
        this.hours = hours;
    }

    public boolean isBillable() {
        return billable;
    }

    /**
     * Determines if time is billable
     *
     * @param billable - set the billable amount
     */
    public void setBillable(boolean billable) {
        this.billable = billable;
    }

    @Override
    public String toString() {
        return String.format("%-26s  %2$tm/%2$td/%2$tY  %3$5d  %4$s%n",
                account.getName(), date, hours, skill);
    }
}
