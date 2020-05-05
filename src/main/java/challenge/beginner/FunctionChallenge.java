package challenge.beginner;

import java.util.function.Function;

public class FunctionChallenge {

    public static void main(String... doYourBest) {
        Function<Integer, Integer> add = x -> x + 2;
        Function<Integer, Integer> sub = x -> x - 2;
        Function<Integer, Integer> div = x -> x / 2;

        Function<Integer, Integer> func = add.andThen(sub).andThen(div);

        System.out.println(func.apply(2));
    }

}




















/*
The interface Function in Java basically specify the logic of functions you want to be executed in your program.

You can realize that this interface contains two generic types and in our case we are receiving an Integer and returning an Integer.

Lets first understand lambda expression given below

x -> x+1

The above given lambda expression (an anonymous function ) takes an argument and return result after increment by one if x is type of Integer value. We can give type of input value and return value by using Function<Integer, Integer> .

In the Lambda expression the x would be the type of the received parameter and there will be the logic we defined. It's basically adding 2 to the x variable.

Function<Integer, Integer> add = x -> x + 2;
Here we are subtracting 2 from the x variable.

Function<Integer, Integer> sub = x -> x - 2;
Finally here we are dividing the x by 2.

Function<Integer, Integer> div = x -> x / 2;
In below line of code, we are joining all logics to be executed in a row. That means that we are going to add, then subtract and divide.

Function<Integer, Integer> func = add.andThen(sub).andThen(div);
With all functions in the func variable we are going to use the apply method passing 2.

Then in the add method it will be 2 + 2 = 4.

Subtract method = it will be 4 - 2 = 2.

Divide method = it will be 2 / 2 = 1.

System.out.println(func.apply(2));
 */