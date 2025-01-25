package lesson_8;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, ArrayList<String>> phoneNumbers;
    public PhoneBook(){
        phoneNumbers = new HashMap<>();
}
public void add(String LastName,String phoneNumber) {
    if (phoneNumbers.containsKey(LastName)) {
        phoneNumbers.get(LastName).add(phoneNumber);
    } else {
        ArrayList<String> numbers = new ArrayList<>();
        numbers.add(phoneNumber);
        phoneNumbers.put(LastName, numbers);
    }
}

        public ArrayList<String> get(String LastName){
            return phoneNumbers.get(LastName);
    }

}


