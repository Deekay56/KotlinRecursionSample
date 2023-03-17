Recursion
Learn how to create recursive functions in Kotlin.

What is Recursion?
Recursion is the process in which a function calls itself until a condition is met. This concept is similar to a while loop in which a body of code will be executed repeatedly until a condition is met.

Recursion is an advanced topic when it comes to functions and programming; it often takes time and practice until a programmer is comfortable with creating and using recursive functions so don’t feel discouraged if it doesn’t all stick right away.

Breaking Down a Recursive Function
In a recursive function, a base case (usually an if expression) is created to check for a condition. If the condition is true, then the function will return a value. If the condition is false, the function will return a function call to itself with a new set of argument values; this is known as a recursive call. The function will continue to call upon itself until the base case is reached.

Let’s use a recursive function to get the sum of a group of numbers from num until 0:

fun recursiveSum(num: Int): Int {
  // base case
  if (num == 0) {
    return num
  } else { 
    // recursive call
    return num + recursiveSum(num - 1)
  }
}
If we were to call this function with an argument of 4, we would get a return value of 10. Let’s try and break down how that worked. Until the parameter num has a value of 0, the code in the else block, return num + recursiveSum(num - 1), will be executed like so:

recursiveSum(4) returns 4 + recursiveSum(3).
recursiveSum(3) returns 3 + recursiveSum(2).
recursiveSum(2) returns 2 + recursiveSum(1).
recursiveSum(1) returns 1 + recursiveSum(0).
Once we call recursiveSum(0), the base case is reached because num is 0. Now, we need to return the value from each call starting from the last call made.

recursiveSum(0) returns 0.
recursiveSum(1) returns 1 + 0 which equals 1.
recursiveSum(2) returns 2 + 1 which equals 3.
recursiveSum(3) returns 3 + 3 which equals 6.
recursiveSum(4) returns 4 + 6 which equals 10.
Note: Like a while loop, a recursive function can run infinitely if we do not create a base case that eventually stops the recursive calls.

Let’s practice creating our own recursive function:
Coding question
Happy New Year! Define a function called countDown() that accepts a single Int argument called secondsToMidnight.

Inside countDown(), create an if/else expression to represent the base case and recursive call.

Base case: If secondsToMidnight is equivalent to 0, use println() to output "Happy New Year!"
Recursive call: In the else block, use println() to output the value of secondsToMidnight. Then, on the following line, recursively call countDown() with an argument of secondsToMidnight - 1.
Inside main(), invoke countDown() with an argument value of 10.

123456789
// Write your code below



fun main() {
  // Write more code below


}
Output:
 
Run


Run your code to check your answer

Tail-Recursive Functions
Recursive functions run the risk of stack overflow. Stack overflow occurs in recursive functions when too much data is being used to store the values created in each recursive call and can cause our program to crash.

Luckily for us, Kotlin has a solution for this: tail-recursive functions. When using a tail-recursive function, the compiler can optimize the code to prevent stack overflow.

Let’s recreate the recursiveSum() function from earlier. To declare a tail recursive function, prepend tailrec to the fun keyword in the header:

tailrec fun recursiveSum(num: Int, sum: Int = 0): Int {
  return if (num == 0) sum 
  else recursiveSum(num - 1, sum + num)
}
 
fun main() {
  println(recursiveSum(num = 10)) // Prints: 55
}
We added a second argument, sum, to store the final return value. For a recursive function to be considered for tail recursion, the final operation in the function must be a call to itself. In this case, the final instruction is recursiveSum(num - 1, sum + num).

The code return if (num == 0) sum translates to the base case being num == 0 and the return value being sum. The code else recursiveSum(num - 1, sum + num) is the recursive call that changes the argument num to decrease by 1 while adding the value of num to the eventual return value sum.

Let’s practice creating tail-recursive functions:

Coding question
In math, a factorial function multiplies a positive number from its value down to 1.

For example 4! represents 4 * 3 * 2 * 1.

Define a tail-recursive function called factorial() that accepts an Int argument named num and an Int argument named product that has a default value of 1. The function will return an Int value.

Inside the function, return the value of product when the base case, num == 1, is reached. Otherwise, recursively call the function with the arguments num - 1 and num * product, respectively.

Inside the main() function, create a variable called factorialValue and set its value to factorial(10). Then, use println() to output factorialValue.

123456789
// Write your code below



fun main() {
  // Write more code below


}
Output:
 
Run


Run your code to check your answer
Wrap up
Great job reaching the end of this article. Let’s go over what we learned:

Recursion is the process of a function calling itself within the function’s code block.
Every recursive function needs a base case and a recursive call.
The base case defines what condition must be met in order to exit the recursive function while the recursive call is used to call the function with a new set of arguments.
A tail-recursive function is a more efficient way of producing a recursive function because it prevents stack overflow.
Recursion is one of the more advanced topics in this course; don’t feel discouraged if the concept didn’t click right away. Recursion isn’t a fundamental programming concept, but once you get the hang of it, it can be a valuable tool for coding projects, interview questions, and more.

