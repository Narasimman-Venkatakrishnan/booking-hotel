import java.util.*;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Room {

    int price;
    List<String> features;
    int availability;

    public Room(int price, List<String> features, int availability) {
        this.price = price;
        this.features = features;
        this.availability = availability;
    }

    public Room(Room another) {
        this.price = another.price;
        this.features = another.features;
        this.availability = another.availability;
    }

    public Room merge(Room another) {
        this.price = this.price + another.price;
        this.availability = this.availability < another.availability ? this.availability : another.availability;
        // this.features.retainAll(another.features);
        this.features = this.features.stream().distinct().filter(another.features::contains)
                .collect(Collectors.toList());
        return this;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }
}
