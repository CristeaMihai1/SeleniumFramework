//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.WebElement;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.util.HashMap;
//import java.util.List;
//
//public class Test {
//
//    public static void main(String[] args) throws IOException {
////        String pathJsonData = "C:\\Users\\mcristea\\Desktop\\Java\\TAS_Project\\src\\main\\java\\data\\EcommerceData.json";
//        String jsonContent = FileUtils.readFileToString(new File(pathJsonData), StandardCharsets.UTF_8);
//
//        //String to HashMap- Jackson Datbind
//
//        ObjectMapper mapper = new ObjectMapper();
//        java.util.List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
//        });
//        System.out.print(data);
//
//        System.out.println(data.get(1).get("password"));
//
////        HashMap<String, WebElement> hashMap = new HashMap<>();
////        hashMap.put()
//
//
//
//
//
//    }
//
//
//}
