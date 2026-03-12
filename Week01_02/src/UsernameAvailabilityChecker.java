import java.util.Scanner;
import java.util.HashMap;

public class UsernameAvailabilityChecker {
    HashMap<String, Integer> user = new HashMap<>();
    HashMap<String, Integer> attemptFrequency = new HashMap<>();


    public boolean checkAvailability(String userName){
        if(user.containsKey(userName)){
            attemptFrequency.put(userName, attemptFrequency.getOrDefault(userName,0)+1);
            return false;
        }
        else{
            attemptFrequency.put(userName, 1);
        }
        return true;
    }

    public String[] suggestAlternatives(String userName){
        String[] list = new String[3];
        list[0]= userName+"123";
        list[1]= userName+"5722";
        list[2]= userName.replace("_", ".");
        return list;
    }

    public String getMostAttempted(){
        String maxUser = "";
        int maxValue = 0;
        for(String key : attemptFrequency.keySet()){
            if(attemptFrequency.get(key) > maxValue ){
                maxValue = attemptFrequency.get(key);
                maxUser = key;
            }
        }
        return (maxUser + " (" + maxValue + " attempts)");
    }

    public static void main(String args[]){
        UsernameAvailabilityChecker system = new UsernameAvailabilityChecker();
        system.user.put("shrey_sharma",1);
        system.user.put("prisha_k",2);
        String userName = "aditya123";
        boolean isAvailable = system.checkAvailability(userName);
        if(!isAvailable){
            System.out.println(isAvailable + "(already taken)");
            String[] alt = system.suggestAlternatives(userName);
            System.out.println("Alternative suggestions you can use: ");
            for (int i = 0; i < alt.length; i++) {
                System.out.println(alt[i]);
            }
        }else{
            System.out.println(isAvailable + "(available)");
        }
        system.checkAvailability("shrey_sharma");
        system.checkAvailability("shrey_sharma");
        system.checkAvailability("shrey_sharma");
        System.out.print("Most Attempted Username: ");
        System.out.println(system.getMostAttempted());
    }
}