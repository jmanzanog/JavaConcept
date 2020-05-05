package challenge.intermediate;

public class GarbageCollectorTest {

    public static void main(String[] args) {

        HowManyObjectsWillBeCleanedByTheGarbageCollector gc = new GarbageCollectorTest()
                .new HowManyObjectsWillBeCleanedByTheGarbageCollector();

        gc.executeAction();

        System.out.println("How many objects are eligible be collected by "
                + "the Garbage Collector after "
                + "the executeAction() method invokation?" + gc.toString());

    }

    private class HowManyObjectsWillBeCleanedByTheGarbageCollector {

        private Character homer = new Character("Dooh");

        private Character misterBurns = new Character("you are fired");

        private Character bart = new Character("eat my shorts");

        private Character elBarto;

        public void executeAction() {
            homer.talk();
            misterBurns.talk();
            makeTwoCharactersTalk(misterBurns, homer);
            misterBurns = null;
            elBarto = bart;
            bart = null;
            elBarto.talk();
        }

        private void makeTwoCharactersTalk(Character misterBurns, Character homer) {
            misterBurns.talk();
            homer.talk();
            misterBurns = null;
            homer = null;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("HowManyObjectsWillBeCleanedByTheGarbageCollector{");
            sb.append("homer=").append(homer);
            sb.append(", misterBurns=").append(misterBurns);
            sb.append(", bart=").append(bart);
            sb.append(", elBarto=").append(elBarto);
            sb.append('}');
            return sb.toString();
        }
    }
}

class Character {

    private String talk;

    public Character(String talk) {
        this.talk = talk;
    }


    public void talk() {
        System.out.println(this.talk);
    }
}

/*
Choice 1
2

Choice 2 (Correct)
1

Choice 3
None

Choice 4
3

 */

/*
Background
Java programs perform automatic memory management through a process known as garbage collection. Java programs compile to bytecode, which is then run on a Java Virtual Machine (JVM). As programs run on the JVM, objects are created on the heap (the memory dedicated to that program). At some point, some or all of these objects are longer be needed. The garbage collector detects this situation and deletes them to free up memory.

There will be just one object, misterBurns! When we invoke the makeTwoCharactersTalk we pass the objects by reference and not by value.This means the object is still in the Heap. We also pass the reference of bart to elBarto. When we pass null to bart, we still have the object of Bart into elBarto.

There was a discussion about this challenge with the String in misterBurns object. Developers were saying that this String should be collected by the garbage collector as well. This would be true if the String was being used as new String(); but we are using the String as literal, that means that we are assigning a value directly to the String:

public Character(String talk) { this.talk = talk; }

By doing that, the String will be in the String pool, therefore it won't be eligible to the garbage collector.
 */
