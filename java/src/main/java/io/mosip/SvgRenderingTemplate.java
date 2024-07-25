package io.mosip;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SvgRenderingTemplate implements SvgRenderingInterface {

     public String replaceSVGTemplatePlaceholders(String template, Map<String, Object> data) {
        // Regular expression pattern to match placeholders like {{key1/key2/...}}
        Pattern pattern = Pattern.compile("\\{\\{(.*?)}}");

        // Use Matcher to find and replace placeholders in the template
        Matcher matcher = pattern.matcher(template);
        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            String key = matcher.group(1).trim(); // Extract the key inside {{...}}
            key = key.replaceAll("^/|/$", ""); // Remove leading and trailing slashes

            // Split the key into parts
            String[] keys = key.split("/");

            // Traverse through the data map based on keys
            Object value = data;
            for (String k : keys) {
                if (value instanceof Map) {
                    value = ((Map<?, ?>) value).get(k);
                } else {
                    value = null; // If not a map, break out of the loop
                    break;
                }
            }

            // Format date if the value is a valid date/time object
            if (value instanceof String && DateUtils.isValidDateTime((String) value)) {
                value = DateUtils.formatDate((String) value);
            }

            // Replace the placeholder with the value (or empty string if value is null)
            matcher.appendReplacement(result, value != null ? String.valueOf(value) : "");
        }
        matcher.appendTail(result);

        return result.toString();
    }
}