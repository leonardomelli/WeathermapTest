package WeathermapTest.com.weathermap.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public record Quote(String type, Value value) {
}
