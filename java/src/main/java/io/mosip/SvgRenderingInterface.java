package io.mosip;

import java.util.Map;

public interface SvgRenderingInterface {
    String replaceSVGTemplatePlaceholders(String template, Map<String, Object> data);
}
