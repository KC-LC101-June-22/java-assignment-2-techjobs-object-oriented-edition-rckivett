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

    @Before
    public void init(){
        jobC = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }
    @Test
    public void testSettingJobId(){
        jobA = new Job();
        jobB = new Job();
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
        jobD = new Job("Junior Developer", new Employer("TruckMovers.com, Inc."), new Location("Kansas City"), new PositionType("Web - Full Stack"), new CoreCompetency("Python"));
        jobE = new Job("Junior Developer", new Employer("TruckMovers.com, Inc."), new Location("Kansas City"), new PositionType("Web - Full Stack"), new CoreCompetency("Python"));

        assertFalse(jobD.equals(jobE));
    }
}
