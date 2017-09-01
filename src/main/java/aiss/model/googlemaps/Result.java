
package aiss.model.googlemaps;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown=true)
public class Result {

    private List<AddressComponent> address_components;
    private String formatted_address;
    private Geometry geometry;
    private String place_id;
    private List<String> types;

    public List<AddressComponent> getAddressComponents() {
        return address_components;
    }

    public void setAddressComponents(List<AddressComponent> addressComponents) {
        this.address_components = addressComponents;
    }

    public String getFormattedAddress() {
        return formatted_address;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formatted_address = formattedAddress;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public String getPlaceId() {
        return place_id;
    }

    public void setPlaceId(String placeId) {
        this.place_id = placeId;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

}
