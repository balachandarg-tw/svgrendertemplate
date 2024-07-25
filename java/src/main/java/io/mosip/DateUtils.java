package io.mosip;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtils {
    public static String formatDate(String dateString) {
        try {
            LocalDate date = LocalDate.parse(dateString);
            return date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        } catch (DateTimeParseException e) {
            // Handle parsing exception (e.g., invalid date format)
            return ""; // Return empty string or throw exception as needed
        }
    }

    public static boolean isValidDateTime(String dateString) {
        try {
            LocalDate date = LocalDate.parse(dateString);
            int year = date.getYear();
            // Validate year within a reasonable range (e.g., between 0 and 9999)
            return year >= 0 && year <= 9999;
        } catch (DateTimeParseException e) {
            return false; // Return false if parsing fails
        }
    }
}
