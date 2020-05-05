package challenge.beginner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings({"rawtypes", "unchecked"})
public class GenericsChallenge {
    public static void main(String... doYourBest) {
        SimpsonFactory<Simpson> simpsonFactory = new SimpsonFactory<>(new Simpson("Homer"));

        List list = simpsonFactory.addToList(new ArrayList<>(), new LinkedList<>());

        System.out.println(((List<Simpson>) list).get(0).name);
    }

    static class Simpson {
        String name;

        public Simpson(String name) {
            this.name = name;
        }
    }

    static class SimpsonFactory<T> {
        T t;

        public SimpsonFactory(T t) {
            this.t = t;
        }

        public List<T> addToList(List<T> simpson1, List<? super Simpson> simpson2) {
            simpson1.add(t);
            simpson2.add(new Simpson("Maggie")); // 35
            return simpson1;
        }
    }
}
















/*
Choice 1 (Correct)
Homer

Choice 2
ClassCastException at line 35

Choice 3
Maggie

Choice 4
It will not compile
 */

/*
Background
Let's analyze the code, in the first line:

SimpsonFactory<Simpson> simpsonFactory = new SimpsonFactory<>(new Simpson("Homer"));
We are passing the Simpson instance to the T generic type, T will become Simpson type.

Then we are going to invoke this method:

simpsonFactory.addToList(new ArrayList<>(), new LinkedList());
Since we already passed the generic type in the constructor before it doesn't matter that we are not passing the type in the ArrayLists. The elements will be added into the list normally. In simpson1 there will be only "Homer" and in simpson2 "Maggie".

Finally, "Homer" will be shown since simpson1 only element contains "Homer".
 */