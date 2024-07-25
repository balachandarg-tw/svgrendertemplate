import io.mosip.DateUtils;
import io.mosip.SvgRenderingTemplate;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class SvgRenderingTemplateTest {
    @Test
    public void testReplaceSVGTemplatePlaceholders() {
        String template = "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"250\" height=\"400\" viewBox=\"0 0 250 400\">\n" +
                "<text x=\"20\" y=\"60\" fill = \"#0000ff\" font-size=\"18\" font-weight=\"bold\">Hi {{user/name}}</text>\n" +
                "</svg>";
        Map<String, Object> data = new HashMap<>();
        data.put("user", Map.of("name", "John Doe"));

        String expectedResult = "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"250\" height=\"400\" viewBox=\"0 0 250 400\">\n" +
                "<text x=\"20\" y=\"60\" fill = \"#0000ff\" font-size=\"18\" font-weight=\"bold\">Hi John Doe</text>\n" +
                "</svg>";
        String result = new SvgRenderingTemplate().replaceSVGTemplatePlaceholders(template, data);

        assertEquals(expectedResult, result);
    }




}
