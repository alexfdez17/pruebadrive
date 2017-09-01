
package aiss.model.googlemaps;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Viewport {

    private Northeast_ northeast;
    private Southwest_ southwest;

    public Northeast_ getNortheast() {
        return northeast;
    }

    public void setNortheast(Northeast_ northeast) {
        this.northeast = northeast;
    }

    public Southwest_ getSouthwest() {
        return southwest;
    }

    public void setSouthwest(Southwest_ southwest) {
        this.southwest = southwest;
    }

}
