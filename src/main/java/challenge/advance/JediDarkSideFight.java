package challenge.advance;


import java.util.function.*;

public class JediDarkSideFight {

    public static void main(String... doYourBest) {
        String luke = "useSaber";
        Supplier<String> yoda = () -> "useForce";

        UnaryOperator<String> fightEmpire = luke::concat;
        UnaryOperator<String> fightDarkSide = String::toUpperCase;

        BiFunction<UnaryOperator<String>, UnaryOperator<String>, Function<String, String>>
                attackDarkSide = Function::andThen;

        String finalAttack = attackDarkSide.apply(fightEmpire, fightDarkSide).apply(yoda.get());

        Consumer<String> consumeForce = System.out::println;
        consumeForce.accept(finalAttack);
    }

}

/*
Choice 1
useSaberuseForce

Choice 2 (Correct)
USESABERUSEFORCE

Choice 3
useSaberUSERFORCE

Choice 4
USEFORCEUSESABER
 */


/*
Background
Let's understand what is happening in the code. Lambdas are a way to work with functions that can be stored in a variable and when suitable we can invoke or even nest functions.

At those two first lines, we are initializing a String and then we are creating a lambda for the Java functional interface Supplier that basically supplies a value:

String luke = "useSaber";
Supplier<String> yoda = () -> "useForce";

Then we are creating a UnaryOperator that receives the concat method reference from luke.
UnaryOperator<String> fightEmpire = luke::concat;

On the next UnaryOperator we are receiving a method reference with the toUpperCase method. Note that the toUpperCase doesn't receive any parameter but we also need a String to invoke the upperCase method, right? That's where the UnaryOperator will match this method reference.
UnaryOperator<String> fightDarkSide = String::toUpperCase;

Then we are going to use the method reference from the Function using the andThen method. On this BiFunction we are receiving two UnaryOperators and we are returning a Function.
BiFunction<UnaryOperator<String>, UnaryOperator<String>, Function<String, String>>
        attackDarkSide = Function::andThen;

Finally we are going to apply our BiFunction with the two BinaryOperators we created previously. Note that we are using the andThen method from the Function. The andThen method will invert the UnaryOperators, that will be translated to this code:
fightDarkSide.apply(fightEmpire.apply(yoda.get()))

Can you see that firstly we are applying the upperCase method and then concatenating the yoda String? Basically this code will be translated again to:
"useSaber".concat("useForce").toUpperCase();

All this function will be executed with the value from the yoda Supplier:
String finalAttack = attackDarkSide.apply(fightEmpire, fightDarkSide).apply(yoda.get());

This Consumer will only consume the parameter that was returned from our BiFunction:
Consumer<String> consumeForce = System.out::println;

Then we will be printing the value when we accept the function we defined on our Consumer:
consumeForce.accept(finalAttack);
 */