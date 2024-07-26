package io.mosip.svgrender

interface SvgRenderingInterface {
    fun replaceSVGTemplatePlaceholders(template: String, data: Map<String, Any>): String
}