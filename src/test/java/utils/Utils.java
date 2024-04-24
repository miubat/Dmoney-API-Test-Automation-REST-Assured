package utils;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;

public class Utils {
    public static void setEnvVar(String key, String value) throws org.apache.commons.configuration.ConfigurationException {
        PropertiesConfiguration config = new PropertiesConfiguration("./src/test/resources/config.properties");
        config.setProperty(key,value);
        config.save();
    }

    public static void saveUsers(UserModel usersModel) throws IOException, org.json.simple.parser.ParseException {
        String fileLocation = "./src/test/resources/users.json";
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(fileLocation));

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",usersModel.getName());
        jsonObject.put("email",usersModel.getEmail());
        jsonObject.put("password",usersModel.getPassword());
        jsonObject.put("phone_number",usersModel.getPhone_number());
        jsonObject.put("nid",usersModel.getNid());
        jsonObject.put("role",usersModel.getRole());

        jsonArray.add(jsonObject);

        FileWriter writer = new FileWriter(fileLocation);
        writer.write(jsonArray.toJSONString());
        writer.flush();
        writer.close();
    }
//
//    public static JSONObject getUser() throws IOException, org.json.simple.parser.ParseException {
//        String fileLocation = "./src/test/resources/users.json";
//        JSONParser jsonParser = new JSONParser();
//        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(fileLocation));
//        JSONObject jsonObject = (JSONObject) jsonArray.get(jsonArray.size()-1);
//        return jsonObject;
//    }
//    public static JSONObject getAgent() throws IOException, org.json.simple.parser.ParseException {
//        String fileLocation = "./src/test/resources/users.json";
//        JSONParser jsonParser = new JSONParser();
//        try (Reader reader = new FileReader(fileLocation)) {
//            JSONArray jsonArray = (JSONArray) jsonParser.parse(reader);
//            JSONObject agentUser = null;
//            for (int i = jsonArray.size() - 1; i >= 0; i--) {
//                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
//                String role = (String) jsonObject.get("role");
//                if ("Agent".equals(role)) {
//                    agentUser = jsonObject;
//                    break; // Stop iteration after finding the last "agent" user
//                }
//            }
//            return agentUser;
//        }
//    }
}
