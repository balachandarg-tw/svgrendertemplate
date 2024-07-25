import io.mosip.DateUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class DateUtilsTest {

    @Test
    public void testFormatDateValidInput() {
        String formattedDate = DateUtils.formatDate("2024-07-25");
        assertEquals("2024/07/25", formattedDate);
    }

    @Test
    public void testFormatDateInvalidInput() {
        String formattedDate = DateUtils.formatDate("invalid-date");
        assertEquals("", formattedDate);
    }

    @Test
    public void testIsValidDateTimeValidInput() {
        assertTrue(DateUtils.isValidDateTime("2024-07-25"));
    }

    @Test
    public void testIsValidDateTimeInvalidInput() {
        assertFalse(DateUtils.isValidDateTime("invalid-date"));
    }

    @Test
    public void testIsValidDateTimeOutOfRangeYear() {
        assertFalse(DateUtils.isValidDateTime("10000-01-01"));
    }
}