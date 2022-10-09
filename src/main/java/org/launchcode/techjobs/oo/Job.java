package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {
    private int id;
    private static int nextId = 1;
    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;


    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency){
        this();
        this.name=name;
        this.employer=employer;
        this.location=location;
        this.positionType=positionType;
        this.coreCompetency=coreCompetency;
    }

    public static void resetJobId(){
        nextId = 1;
    }

    private boolean jobFieldIsNotEmpty(String inputString) {
        return inputString != null && !inputString.isEmpty();
    }
    private String defaultString(String inputString, String defaultString) {
        return jobFieldIsNotEmpty(inputString) ? inputString : defaultString;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id && Objects.equals(name, job.name) && Objects.equals(employer, job.employer) && Objects.equals(location, job.location) && Objects.equals(positionType, job.positionType) && Objects.equals(coreCompetency, job.coreCompetency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, employer, location, positionType, coreCompetency);
    }


    @Override
    public String toString(){
        String dataNotAvailable = "Data not available";
        return String.format("\nID: %d\nName: %s\nEmployer: %s\nLocation: %s\nPosition Type: %s\nCore Competency: %s\n",
            id,
            defaultString(name, dataNotAvailable),
            employer==null ? dataNotAvailable : defaultString(employer.getValue(), dataNotAvailable),
            location==null ? dataNotAvailable : defaultString(location.getValue(), dataNotAvailable),
            positionType==null ? dataNotAvailable : defaultString(positionType.getValue(), dataNotAvailable),
            coreCompetency==null ? dataNotAvailable : defaultString(coreCompetency.getValue(), dataNotAvailable)
            );


       // return "\nID: "+id+"\nName: "+name+"\nEmployer: "+employer.getValue()+"\nLocation: "+location.getValue()+"\nPosition Type: "+positionType.getValue()+"\nCore Competency: "+coreCompetency.getValue()+"\n";
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }

    public String getName() { return name;}

    public Employer getEmployer() { return employer;}

    public Location getLocation() { return location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
