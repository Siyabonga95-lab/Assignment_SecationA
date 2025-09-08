// File: SeriesTest.java

/*
*Student Number:ST10488360
*Student Name:Siyabonga Msimango
*/
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class SeriesTest {

    private SeriesModel series1;
    private SeriesModel series2;
    private ArrayList<SeriesModel> seriesList;

    @Before
    public void setUp() {
        // Initialize series objects
        series1 = new SeriesModel("S001", "Breaking Bad", 18, 62);
        series2 = new SeriesModel("S002", "Stranger Things", 16, 34);

        // Initialize a mock series list
        seriesList = new ArrayList<>();
        seriesList.add(series1);
        seriesList.add(series2);
    }

    @Test
    public void testCreateSeries() {
        SeriesModel newSeries = new SeriesModel("S003", "The Witcher", 18, 16);
        seriesList.add(newSeries);

        // Check that series list size 
        assertEquals(3, seriesList.size());
        // Check that the last series added matches
        assertEquals("The Witcher", seriesList.get(2).getSeriesName());
    }

    @Test
    public void testUpdateSeries() {
        // Change name of series1
        series1.setSeriesName("Better Call Saul");
        assertEquals("Better Call Saul", series1.getSeriesName());

        // Update age restriction
        series1.setSeriesAge(15);
        assertEquals(15, series1.getSeriesAge());
    }

    @Test
    public void testDeleteSeries() {
        seriesList.remove(series2);
        assertEquals(1, seriesList.size());
        assertFalse(seriesList.contains(series2));
    }

    @Test
    public void testSearchSeries() {
        // Simple search by ID
        SeriesModel found = null;
        for (SeriesModel s : seriesList) {
            if (s.getSeriesId().equals("S001")) {
                found = s;
            }
        }
        assertNotNull(found);
        assertEquals("Breaking Bad", found.getSeriesName());
    }

    @Test
    public void testToStringMethod() {
        String expected = "ID: S001, Name: Breaking Bad, Age Restriction: 18, Episodes: 62";
        assertEquals(expected, series1.toString());
    }
}
