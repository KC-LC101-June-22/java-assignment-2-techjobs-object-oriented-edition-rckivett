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

    //implement a resetJobId to call in JobTest because the unit tests kept incrementing in number which kept throwing off my tests.  Why this isn't part of the actual assignment is obnoxious and should be included.
    public static void resetJobId(){
        nextId = 1;
    }

    //implement a method to test if a field for the toString method is null or empty and then set it to a value if true
    private boolean jobFieldIsNotEmpty(String inputString) {
        return inputString != null && !inputString.isEmpty();
    }
    //implement defaultString method to take in a string input with a default string call that is run through a ternary operator.
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


    //putting the defaultString method from above into use in combination with using the java string format() method to format the printout that the book is asking for.
    //I'm using a variable dataNotAvailable and setting "Data not available" to call within this method.
    //I'm formatting the printout using the shorthand Java String Format Specifiers from https://www.javatpoint.com/java-string-format
    //%d is used for id for integer, %s is for strings
    //so what we're also doing is we're calling id, which is guaranteed due to how it's written, so we don't need to do anything else with it
    //name is already a string, so I don't need to test if an object is null. it's just getting the defaultString call.  if there is a name given, it will use the name, else it will go to the default dataNotAvailable variable
    //employer, location, position, and coreCompetency are objects and can be null.  anything an object ends up as null you get a NullReferenceException and should always be tested against.  what this is doing is testing the objects and seeing if they are null.  if the null check returns true, they are told to return the dataNotAvailable error.
    //if the null check does not return true, they are told to use the defaultString method from above which is using an additional ternary operator to determine if the field is empty or null.  if the return is not empty or null, it uses the object.getValue(), but it will go back to dataNotAvailable if it is empty or null
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
