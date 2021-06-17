import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.simple.parser.ParseException;

public class app {

    public static void main(String[] args)
            throws ParseException, JsonParseException, JsonMappingException, IOException {

        FileResourcesUtils fileRead = new FileResourcesUtils();
        ObjectMapper mapper = new ObjectMapper();
        Map<Integer, List<Room>> dataset = new HashMap<>();
        CustomerRequest request = new CustomerRequest();

        dataset = fileRead.getDataSet();
        String fileNameRequest = "request.json";
        InputStream req = fileRead.getFileFromResourceAsStream(fileNameRequest);
        request = mapper.readValue(req, CustomerRequest.class);

        checkAvailability(dataset, request);

    }

    private static List<Room> checkAvailability(Map<Integer, List<Room>> dataset, CustomerRequest request) {

        List<Room> resultList = new ArrayList<>();
        List<List<Room>> availableRoomsList = new ArrayList<List<Room>>();

        final List<String> features = request.features;
        final int rooms = request.rooms;

        // filter 1
        Predicate<Room> isFeaturesAvailable = e -> e.getFeatures().containsAll(features);
        // filter2
        Predicate<Room> isRoomsAvailable = e -> e.availability >= rooms;

        for (int i = request.checkin; i < request.checkout; i++) {
            List<Room> availableRooms = new ArrayList<>();
            List<Room> temp = dataset.get(i);
            availableRooms = temp.stream().filter(isRoomsAvailable).filter(isFeaturesAvailable)
                    .collect(Collectors.toList());
            availableRoomsList.add(availableRooms);
        }

        for (int j = 0; j < availableRoomsList.size(); j++) {
            List<Room> tempList = new ArrayList<>();
            if (j == 0) {
                resultList.addAll(availableRoomsList.get(0));
            } else {
                for (int k = 0; k < availableRoomsList.get(j).size(); k++) {
                    for (int l = 0; l < resultList.size(); l++) {
                        Room room = new Room(resultList.get(l));
                        room.merge(availableRoomsList.get(j).get(k));
                        tempList.add(room);
                    }
                }
                resultList.clear();
                resultList.addAll(tempList);
                tempList.clear();
            }
        }

        // to print output
        for (Room room : resultList) {
            System.out.println("price " + room.price);
            room.features.forEach(System.out::println);
            System.out.println("availability " + room.availability);
            System.out.println("####");
        }

        return resultList;
    }
}