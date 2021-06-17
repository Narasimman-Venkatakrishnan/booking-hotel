import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class CustomerRequest {

    int checkin;
    int checkout;
    List<String> features;
    int rooms;

    public CustomerRequest(int checkin, int checkout, List<String> features, int rooms) {
        this.checkin = checkin;
        this.checkout = checkout;
        this.features = features;
        this.rooms = rooms;
    }

    public CustomerRequest() {
    }

    public int getCheckin() {
        return checkin;
    }

    public void setCheckin(int checkin) {
        this.checkin = checkin;
    }

    public int getCheckout() {
        return checkout;
    }

    public void setCheckout(int checkout) {
        this.checkout = checkout;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

}
