package demo;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

class user_profile {
    String password;
    String gmail;
    String bio;

    user_profile(String password, String gmail, String bio) {
        this.password = password;
        this.gmail = gmail;
        this.bio = bio;
    }
}

public class Dictionary {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Map<String, user_profile> sample_user = new HashMap<>();
        sample_user.put("admin", new user_profile("admin","admin@gmail.com","a round fruit with red, green, or yellow skin and firm white flesh"));
        //sample_user.put("banana", "a long curved fruit with a yellow skin and soft sweet flesh");
        
        
        File userdata = new File( "userdata/dictionary.txt" );
        userdata.getParentFile().mkdirs();
        //write folder
        try (RandomAccessFile writer = new RandomAccessFile(userdata, "rw")) {
            
            for (Map.Entry<String, user_profile> entry : userdata.entrySet()) {
                writer.writeBytes(entry.getKey() + ": " + entry.getValue() + "\n");
            }
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        /*
        Map<String, user_profile> empty_user = new HashMap<>();
        // read folder
        try (RandomAccessFile reader = new RandomAccessFile(new File( "dictionarys.txt" ), "rw")) {
        //}
        //try (BufferedReader reader = new BufferedReader(new FileReader("dictionary.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                
                String[] parts = line.split(": ");
                empty_user.put(parts[0], parts.getValue().password, );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
*/

        System.out.println(sample_user.get("admin"));
    }
}