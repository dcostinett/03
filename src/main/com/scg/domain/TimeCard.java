package com.scg.domain;

import com.scg.util.StringUtils;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: dcostinett
 * Date: 1/19/13
 * Time: 11:53 AM
 * Encapsulates a time card capable of storing a consultant's billable and non-billable hours for a week.
 */
public class TimeCard {
    private final Consultant consultant;
    private final Date weekStartingDay;
    private final List<ConsultantTime> consultingHours;
    private final List<ConsultantTime> nonBillableHours;
    private int billableHours = 0;
    private int totalNonBillableHours = 0;

    public TimeCard(Consultant consultant, Date weekStartingDay) {
        this.consultant = consultant;
        this.weekStartingDay = weekStartingDay;
        consultingHours = new ArrayList<ConsultantTime>();
        nonBillableHours = new ArrayList<ConsultantTime>();
    }

    /**
     * Add a consultantTime object to this Time Card
     *
     * @param consultantTime - consultant time
     */
    public void addConsultantTime(ConsultantTime consultantTime) {
        if (consultantTime.isBillable()) {
            consultingHours.add(consultantTime);
            billableHours += consultantTime.getHours();
        } else {
            nonBillableHours.add(consultantTime);
            totalNonBillableHours += consultantTime.getHours();
        }
    }

    /**
     * Returns the billable hours (if any) in this TimeCard for the specified client.
     *
     * @param clientName - client name
     * @return List<ConsultantTime> of hours for given client name
     */
    public List<ConsultantTime> getBillableHoursForClient(String clientName) {
        List<ConsultantTime> clientHours = new ArrayList<ConsultantTime>();

        for (ConsultantTime consultantTime : consultingHours) {
            if (consultantTime.getAccount().getName().compareToIgnoreCase(clientName) == 0) {
                if (consultantTime.isBillable()) {
                    clientHours.add(consultantTime);
                }
            }
        }

        return clientHours;
    }

    public Consultant getConsultant() {
        return consultant;
    }

    public Date getWeekStartingDay() {
        return weekStartingDay;
    }

    public List<ConsultantTime> getConsultingHours() {
        return consultingHours;
    }

    public int getBillableHours() {
        return billableHours;
    }

    public int getTotalHours() {
        return billableHours + totalNonBillableHours;
    }

    public int getTotalNonBillableHours() {
        return totalNonBillableHours;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("====================================================================").append("\n");
        Calendar cal = new GregorianCalendar();
        cal.setTime(weekStartingDay);
        sb.append(String.format("Consultant: %-18s %10s Week Starting: %3$tb %3$te,%3$tY",
                consultant.toString(), " ", cal)).append("\n");
        sb.append("\n");
        sb.append("Billable Time:\n");
        sb.append(String.format("%-26s  %-10s  %-5s  %-20s", "Account", "Date", "Hours", "Skill")).append("\n");
        sb.append(StringUtils.pad('-', 26)).append("  ")
                .append(StringUtils.pad('-', 10)).append("  ")
                .append(StringUtils.pad('-', 5)).append("  ")
                .append(StringUtils.pad('-', 20))
                .append("\n");
        for (ConsultantTime hours : consultingHours) {
            if (hours.isBillable()) {
                sb.append(hours.toString());
            }
        }
        if (!nonBillableHours.isEmpty()) {
            sb.append("\n");
            sb.append("Non-billable Time:\n");
            sb.append(String.format("%-26s  %-10s  %-5s  %-20s", "Account", "Date", "Hours", "Skill")).append("\n");
            sb.append(StringUtils.pad('-', 26)).append("  ")
                    .append(StringUtils.pad('-', 10)).append("  ")
                    .append(StringUtils.pad('-', 5)).append("  ")
                    .append(StringUtils.pad('-', 20))
                    .append("\n");
            for (ConsultantTime hours : nonBillableHours) {
                if (!hours.isBillable()) {
                    sb.append(hours.toString());
                }
            }
        }
        sb.append("\n");
        sb.append("Summary: \n");
        sb.append(String.format("Total %s: %29d\n", "Billable", billableHours));
        sb.append(String.format("Total Non-Billable: %25d\n", totalNonBillableHours));
        sb.append(String.format("Total Hours: %32d\n", getTotalHours()));
        sb.append("====================================================================").append("\n");
        return sb.toString();
    }
}
