package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    public Job jobA;
    public Job jobB;
    public Job jobC;
    public Job jobD;
    public Job jobE;
    public Job jobF;
    public Job jobG;

    @Before
    public void init(){
        Job.resetJobId();
        jobA = new Job();
        jobB = new Job();
        jobC = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        jobD = new Job("Junior Developer", new Employer("TruckMovers.com, Inc."), new Location("Kansas City"), new PositionType("Web - Full Stack"), new CoreCompetency("Python"));
        jobE = new Job("Junior Developer", new Employer("TruckMovers.com, Inc."), new Location("Kansas City"), new PositionType("Web - Full Stack"), new CoreCompetency("Python"));
        jobF = new Job("Technical Help Desk", new Employer("DataServ"), new Location(""), new PositionType("Technical Assistant / User Support"), new CoreCompetency("Non-coding"));
        jobG = new Job("", new Employer(""), new Location("South Florida"), new PositionType(""), new CoreCompetency(""));
    }
    @Test
    public void testSettingJobId(){
        assertNotEquals(jobA.getId(), jobB.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields() {
        assertEquals(jobC.getName(),"Product tester");
        assertEquals(jobC.getEmployer().getValue(),"ACME");
        assertEquals(jobC.getLocation().getValue(), "Desert");
        assertEquals(jobC.getPositionType().getValue(),"Quality control");
        assertEquals(jobC.getCoreCompetency().getValue(), "Persistence");
        assertTrue(jobC instanceof Job);
        assertTrue(jobC.getEmployer() instanceof Employer);
        assertTrue(jobC.getLocation() instanceof Location);
        assertTrue(jobC.getPositionType() instanceof PositionType);
        assertTrue(jobC.getCoreCompetency() instanceof CoreCompetency);
    }
    @Test
    public void testJobsForEquality(){
        assertFalse(jobD.equals(jobE));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        assertEquals(jobC.toString().charAt(0), '\n');
        assertEquals(jobC.toString().charAt(jobC.toString().length()-1), '\n');
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        assertTrue(jobC.toString().contains("ID: 3\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n"));
    }

    @Test
    public void testTestToStringHandlesEmptyFieldCallsToString(){
        assertTrue(jobF.toString().contains("ID: 6\nName: Technical Help Desk\nEmployer: DataServ\nLocation: Data not available\nPosition Type: Technical Assistant / User Support\nCore Competency: Non-coding\n"));
        assertTrue(jobG.toString().contains("ID: 7\nName: Data not available\nEmployer: Data not available\nLocation: South Florida\nPosition Type: Data not available\nCore Competency: Data not available"));
    }
}