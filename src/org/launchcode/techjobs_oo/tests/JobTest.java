package org.launchcode.techjobs_oo.tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static junit.framework.TestCase.*;

public class JobTest {
    Job firstId;
    Job secondId;
    Job myTestJob1;
    Job myTestJob2;
    Job myTestJob3;
    Employer acme;
    Location desert;
    PositionType qualityControl;
    CoreCompetency persistence;

    @Before
    public void createJobObjects() {
        firstId = new Job();
        secondId = new Job();
        acme = new Employer("ACME");
        desert = new Location("Desert");
        qualityControl = new PositionType("Quality control");
        persistence = new CoreCompetency("Persistence");
        myTestJob1 = new Job("Product tester", acme, desert, qualityControl, persistence);
        myTestJob2 = new Job("Product tester", acme, desert, qualityControl, persistence);
        myTestJob3 = new Job("", new Employer(""), desert, qualityControl, persistence);


    }

    @Test
    public void testSettingJobId() {
        assertEquals(firstId.getId(), secondId.getId(), 1);
        assertFalse(firstId.equals(secondId));
        assertTrue(this.firstId != this.secondId);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertEquals("Product tester", myTestJob1.getName());
        assertEquals(acme, myTestJob1.getEmployer());
        assertTrue(myTestJob1.getEmployer() instanceof Employer);

        assertEquals(desert, myTestJob1.getLocation());
        assertTrue(myTestJob1.getLocation() instanceof Location);

        assertEquals(qualityControl, myTestJob1.getPositionType());
        assertTrue(myTestJob1.getPositionType() instanceof PositionType);

        assertEquals(persistence, myTestJob1.getCoreCompetency());
        assertTrue(myTestJob1.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(myTestJob1.equals(myTestJob2));

    }

    @Test
    public void testToStringBlankLines() {
        assertEquals(myTestJob1.toString().substring(0, 1), "\n");
        assertEquals(myTestJob1.toString().substring(myTestJob1.toString().length() - 1, myTestJob1.toString().length()), "\n");
    }

    @Test
    public void testEachLabelFollowedByStoredData() {
        assertTrue(myTestJob1.toString().contains("Name: Product tester"));
        assertTrue(myTestJob1.toString().contains("Employer: ACME"));
        assertTrue(myTestJob1.toString().contains("Location: Desert"));
        assertTrue(myTestJob1.toString().contains("PositionType: Quality control"));
        assertTrue(myTestJob1.toString().contains("CoreCompetency: Persistence"));
    }

    @Test
    public void testEmptyFieldMessage() {
        //System.out.println(myTestJob3.toString());
        assertFalse(myTestJob3.toString().contains("Name: Data not available"));
        assertFalse(myTestJob3.toString().contains("Employer: Data not available"));
        assertFalse(myTestJob1.toString().contains("Location: Data not available"));
        assertFalse(myTestJob1.toString().contains("PositionType: Data not available"));
        assertFalse(myTestJob1.toString().contains("CoreCompetency: Data not available"));
 }



    @Test
    public void testIdFieldOnly(){
        assertEquals(firstId.toString(), "OOPS! This job does not seem to exist");
    }
}
