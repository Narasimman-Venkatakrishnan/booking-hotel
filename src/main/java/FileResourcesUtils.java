import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FileResourcesUtils {

    // get a file from the resources folder
    protected InputStream getFileFromResourceAsStream(String fileName) {

        // The class loader that loaded the class
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }

    }

    protected Map<Integer, List<Room>> getDataSet() {

        Map<Integer, List<Room>> dataset = new HashMap<>();

        // pepare dataset

        // prepare 176
        List<Room> rList = new ArrayList<>();

        List<String> feaList = new ArrayList<>();
        feaList.add("breakfast");
        feaList.add("refundable");
        Room room = new Room(120, feaList, 5);

        rList.add(room);
        dataset.put(176, rList);

        // prepare 177
        List<Room> rList1 = new ArrayList<>();

        List<String> feaList1 = new ArrayList<>();
        feaList1.add("breakfast");
        feaList1.add("refundable");
        Room room1 = new Room(120, feaList1, 1);

        List<String> feaList2 = new ArrayList<>();
        feaList2.add("breakfast");
        feaList2.add("wifi");
        Room room2 = new Room(130, feaList2, 3);

        List<String> feaList3 = new ArrayList<>();
        feaList3.add("breakfast");
        feaList3.add("wifi");
        feaList3.add("refundable");
        Room room3 = new Room(140, feaList3, 7);

        rList1.add(room1);
        rList1.add(room2);
        rList1.add(room3);
        dataset.put(177, rList1);

        // prepare 178
        List<Room> rList2 = new ArrayList<>();

        List<String> feaList4 = new ArrayList<>();
        feaList4.add("breakfast");
        feaList4.add("refundable");
        Room room4 = new Room(120, feaList4, 4);

        rList2.add(room4);
        dataset.put(178, rList2);

        return dataset;
    }

}