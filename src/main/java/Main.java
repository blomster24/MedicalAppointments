import model.Doctor;
import model.ISchedulable;
import model.Patient;
import model.User;

import java.util.*;

import static ui.UIMenu.showMenu;

public class Main {

    public static void main(String[] args) {

        showMenu();
//        Doctor doctor = new Doctor("Mathias","mathias@m.com");
//        doctor.addAvailableAppointment(new Date(),"4pm");
//        doctor.addAvailableAppointment(new Date(),"1pm");
//        doctor.addAvailableAppointment(new Date(),"10am");
        //System.out.println(doctor);

//        for (model.Doctor.AvailableAppointment aA: doctor.getAvailableAppointments()
//             ) {
//            System.out.println(aA.getDate() + " " + aA.getTime());
//        }

//        Patient patient = new Patient("Alejandra","alejandra@gmail.com");
        //System.out.println(patient);

        /*User user = new Doctor("Miguel","m@m.com");
        user.showDataUser();

        user = new Patient("Luis","l@l.com");
        user.showDataUser();

        User user1 = new User("Mathias","m@m.com") {
            @Override
            public void showDataUser() {
                System.out.println("Doctor");
                System.out.println("Hospital: Cruz Verde");
                System.out.println("Departamento: Geriatría");
            }
        };
        user1.showDataUser();*/

    }

    public static int maxProfit(int[] prices) {
        //int[] prices = {2, 4, 1};

        //System.out.println(maxProfit(prices));
        int min = 0;
        int output = 0;
        int index = 0;
        if (prices.length != 0) {
            min = prices[0];
        }
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                index = i;
            }
        }
        for (int i = index; i < prices.length; i++) {
            if (prices[i] > min) {
                if (prices[i] > output) {
                    output = prices[i];
                }
            }
        }
        if ((output - min) < 0) {
            return 0;
        }

        return output - min;
    }

    public static boolean isValid(String s) {
        /*String s = "(])";
        System.out.println(isValid(s));*/

        ArrayList<Character> brackets = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            String s1 = String.valueOf(s.charAt(i));
            if (s1.equals("(") || s1.equals("[") || s1.equals("{")) {
                brackets.add(s.charAt(i));
            } else if (s1.equals(")") || s1.equals("]") || s1.equals("}")) {
                if (brackets.size() == 0) {
                    return false;
                }
                Character character = brackets.get(brackets.size() - 1);
                if (character.equals('(') && s1.equals(")")) {
                    brackets.remove(brackets.size() - 1);
                } else if (character.equals('[') && s1.equals("]")) {
                    brackets.remove(brackets.size() - 1);
                } else if (character.equals('{') && s1.equals("}")) {
                    brackets.remove(brackets.size() - 1);
                } else {
                    brackets.add(s.charAt(i));
                }
            }
        }
        return brackets.isEmpty();
    }

    public static int lengthOfLongestSubstring(String s) {
/*
        String s = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(s));
*/

        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }

    public static int[] twoSum(int[] nums, int target) {
//        int[] nums = {3,2,4};
//        int target = 6;
//
//        System.out.println(twoSum(nums, target));


        int[] output = new int[2];
        boolean find = false;

        for (int i = 0; i < nums.length; i++) {
            if (!find) {
                for (int j = 0; j < nums.length; j++) {
                    int num1 = nums[i];
                    int num2 = nums[j];
                    if ((num1 + num2) == target && i != j) {
                        output[0] = i;
                        output[1] = j;
                        find = true;
                    }
                }
            }

        }

        return output;
    }

    /*public static String validate(String s, List<List<String>> knowledge) {
//      ESTO VA EN EL MAIN
        //        String s;
//        List<List<String>> knowledge = new ArrayList<>();
//        List<String> part1 = new ArrayList<>();
//        List<String> part2 = new ArrayList<>();
//
//        s = "(name)is(age)yearsold";
//        part1.add("name");
//        part1.add("bob");
//        part2.add("age");
//        part2.add("two");
//
//        knowledge.add(part1);
//        knowledge.add(part2);
//
//
//        System.out.println(evaluate(s, knowledge));

        String print = "";
        //print += k + "\n";

        int inicio = 0;
        int fin;

        List<String> valores = new ArrayList<>();
        while ((inicio = s.indexOf('(', inicio)) != -1) {
            fin = s.indexOf(')', inicio);
            if (fin == -1) {
                break;
            }
            String valor = s.substring(inicio + 1, fin);
            valores.add(valor);
            System.out.println(valor);
            inicio = fin + 1;
        }

        HashMap<String, String> mapKnowledge = new HashMap<>();
        for (List<String> k : knowledge) {
            for (int i = 0; i < k.size(); i += 2) {
                String clave = k.get(i);
                String valor = k.get(i + 1);
                mapKnowledge.put(clave, valor);
            }
        }

        for (int i = 0; i < valores.size(); i++) {
            String target = valores.get(i);
            if (mapKnowledge.containsKey(target)) {
                String replacement = mapKnowledge.get(target);
                s = s.replace("(" + target + ")", replacement);
            } else {
                s = s.replace("(" + target + ")", "?");
            }
        }

        return s;
    }*/

}
