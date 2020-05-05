package challenge.intermediate;

import java.util.HashMap;
import java.util.Map;

public class MapEqualsChallenge {
    public static void main(String... doYourBest) {
        Map<Stark, String> map = new HashMap<>();

        map.put(new Stark("Arya"), "1");
        map.put(new Stark("Ned"), "2");
        map.put(new Stark("Sansa"), "3");
        map.put(new Stark("Bran"), "4");
        map.put(new Stark("Jaime"), "5");

        map.forEach((k, v) -> System.out.println(v));
    }

    static class Stark {
        String name;

        Stark(String name) {
            this.name = name;
        }

        public boolean equals(Object obj) {
            return ((Stark) obj).name.length() == this.name.length();
        }

        public int hashCode() {
            return 0;
        }
    }
}















/*Choice 1
1
2
3
4
5

Choice 2 (Correct)
4
2
5

Choice 3
1
2
3
*/

/*
When we use Map, overriding equals and hashcode because then it's possible to put unique keys into the Map.

In this case, equals and hashcode are being defined with the length of the String. So, objects are going to be the same if the String length is the same.

Arya has 4 characters - it will be inserted
Ned has 3 characters - it will be inserted

Sansa has 5 characters - it will be inserted
Bran has 4 characters - it will replace Arya

Jaime has 5 characters - it will replace Sansa

As Bran has 4 characters and it was the last one to be inserted, it will replace Arya. Therefore the first value is 4.
As Ned is the only one with 3 characters, his value will be printed that is 2.

Then, Sansa has 5 characters, it will be inserted and then Jaime will replace Sansa value with 5.
 */