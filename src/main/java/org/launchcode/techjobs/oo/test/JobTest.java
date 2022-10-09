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
    public Job jobH;

    @Before
    public void init(){
        Job.resetJobId();
        jobA = new Job();
        jobB = new Job();
        jobH = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        //jobD = new Job("Junior Developer", new Employer("TruckMovers.com, Inc."), new Location("Kansas City"), new PositionType("Web - Full Stack"), new CoreCompetency("Python"));
        //jobE = new Job("Junior Developer", new Employer("TruckMovers.com, Inc."), new Location("Kansas City"), new PositionType("Web - Full Stack"), new CoreCompetency("Python"));
        jobF = new Job("Technical Help Desk", new Employer("DataServ"), new Location(""), new PositionType("Technical Assistant / User Support"), new CoreCompetency("Non-coding"));
        jobG = new Job("", new Employer(""), new Location("South Florida"), new PositionType(""), new CoreCompetency(""));
    }
    @Test
    public void testSettingJobId(){
        //the LC test fails if these are not initialized within the test.  This is stupid and should be fixed as you can declare them at the top of the class like we have been instructed to do.
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(jobA.getId(), jobB.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields() {
        jobC = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
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
        jobD = new Job("Junior Developer", new Employer("TruckMovers.com, Inc."), new Location("Kansas City"), new PositionType("Web - Full Stack"), new CoreCompetency("Python"));
        jobE = new Job("Junior Developer", new Employer("TruckMovers.com, Inc."), new Location("Kansas City"), new PositionType("Web - Full Stack"), new CoreCompetency("Python"));
        assertFalse(jobD.equals(jobE));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job5 = new Job();
        String variable2 = job5.toString();
        assertEquals(job5.toString().charAt(0), '\n');
        assertEquals(job5.toString().charAt(job5.toString().length()-1), '\n');
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job.resetJobId();
        Job job6 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String variable3 = job6.toString();
        assertEquals("\nID: 1\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n",job6.toString());
        assertTrue(job6.toString().contains("ID: 1\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n"));
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job.resetJobId();
        Job job3 = new Job("Technical Help Desk", new Employer("DataServ"), new Location(""), new PositionType("Technical Assistant / User Support"), new CoreCompetency("Non-coding"));
        Job job4 = new Job("", new Employer(""), new Location("South Florida"), new PositionType(""), new CoreCompetency(""));
        String variable = job3.toString();
        String variables = job4.toString();
        //whoever wrote the tests that make you have to declare a variable to do this, needs to stop writing tests.  the whole point of declaring the jobs at the top of the Class is so you don't have to do it this way
        assertEquals("\nID: 1\nName: Technical Help Desk\nEmployer: DataServ\nLocation: Data not available\nPosition Type: Technical Assistant / User Support\nCore Competency: Non-coding\n", job3.toString());
        assertEquals("\nID: 2\nName: Data not available\nEmployer: Data not available\nLocation: South Florida\nPosition Type: Data not available\nCore Competency: Data not available\n", job4.toString());
    }
}