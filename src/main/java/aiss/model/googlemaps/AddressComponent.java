
package aiss.model.googlemaps;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class AddressComponent {

    private String long_name;
    private String short_name;
    private List<String> types;

    public String getLongName() {
        return long_name;
    }

    public void setLongName(String longName) {
        this.long_name = longName;
    }

    public String getShortName() {
        return short_name;
    }

    public void setShortName(String shortName) {
        this.short_name = shortName;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

}
