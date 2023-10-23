package People;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;

public class Groups {
    public static void main(String[] args) {
        String csvFile = "MOCK_DATA.csv";
        List<Person> people = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    String number = data[0];
                    String firstName = data[1];
                    String lastName = data[2];
                    String email = data[3];
                    people.add(new Person(number, firstName, lastName, email));
                }
            }
        } catch (IOException e) {
        }

        // Shuffle
        long seed = 12345;
        Collections.shuffle(people, new Random(seed));

        // Create a list of names for the teams
        List<String> teamNames = new ArrayList<>();
        
            teamNames.add("Titanic");
            teamNames.add("Gravity");
            teamNames.add("Inception");
            teamNames.add("Barbie");
            teamNames.add("Psycho");
            teamNames.add("Transformer");
            teamNames.add("Jaws");
            teamNames.add("ET");
            teamNames.add("Interstella");
            teamNames.add("Coco");
            teamNames.add("Gladiator");
            teamNames.add("Grease");
            teamNames.add("Chicago");
            teamNames.add("Mamamia");
            teamNames.add("Casablanca");
            teamNames.add("Godfather");
            teamNames.add("Aliens");
            teamNames.add("Terminator");
            teamNames.add("Avatar");
            teamNames.add("Deadpool");
            


        // Create a map to store teams and their members
        Map<String, List<Person>> teams = new HashMap<>();


        // Create 20 teams with random names
        for (int i = 0; i < 20; i++) {
            String teamName = teamNames.get(i % teamNames.size());
            List<Person> teamMembers = new ArrayList<>();
            for (int j = i * 5; j < (i + 1) * 5; j++) {
                if (j < people.size()) {
                    teamMembers.add(people.get(j));
                }
            }
            teams.put(teamName, teamMembers);
        }

        // Print each team's name and members
        for (Map.Entry<String, List<Person>> entry : teams.entrySet()) {
            String teamName = entry.getKey();
            List<Person> teamMembers = entry.getValue();
            
            System.out.println("------------------------");
            System.out.println("Team Name: " + teamName);
            System.out.println();
            printTeamMembers(teamMembers);
        }
    }

    private static void printTeamMembers(List<Person> teamMembers) {
        for (Person person : teamMembers) {
            
            System.out.println("Name: " + person.getFirstName() + " " + person.getLastName());
           
        }
    }
}
class Person {
    private String number;
    private String firstName;
    private String lastName;
    private String email;

    public Person(String number, String firstName, String lastName, String email) {
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}

