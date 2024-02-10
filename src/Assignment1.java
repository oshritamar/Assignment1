import java.util.Scanner;
public class Assignment1 {
    public static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        int menuOption;
        do {
            System.out.println("Please choose an option:");
            displayOptions();
            menuOption = scanner.nextInt();
            switch (menuOption) {
                case 1 -> {
                    System.out.println("Enter circle radius");
                    double radius = scanner.nextDouble();
                    double area = calculateCircleArea(radius);
                    System.out.println("The area of the circle is" + " " + area);
                    double circumference = calculateCircleCircumference(radius);
                    System.out.println("The circumference of the circle is" + " " + circumference);
                }
                case 2 -> {
                    System.out.println("To convert Celsius to Fahrenheit- press 1, to convert Fahrenheit to Celsius press 2.");
                    int baseChoice = scanner.nextInt();
                    convertTemperature(baseChoice);
                }
                case 3 -> {
                    System.out.println("Enter an integer higher than zero");
                    int inputNum = scanner.nextInt();
                    int factorialResult = calculateFactorial(inputNum);
                    System.out.println("The factorial of your number is" + " " + factorialResult);
                }
                case 4 -> {
                    System.out.println("Enter a start number of a range");
                    int startingNum = scanner.nextInt();
                    System.out.println("Enter an end number of a range");
                    int endingNum = scanner.nextInt();
                    int sumNaturalNums = calculateSumOfNaturalsInRange(startingNum, endingNum);
                    System.out.println("The sum of the natural nums between this range is:" + " " + sumNaturalNums);
                }
                case 5 -> {
                    System.out.println("Enter a positive integer");
                    int positiveIntegerInput = scanner.nextInt();
                    if (checkIfPrime(positiveIntegerInput)) {
                        System.out.println("The number is prime");
                    } else {
                        System.out.println("The number is not prime");
                    }
                }
                case 6 -> {
                    System.out.println("Enter a positive 5 digit num");
                    int userInput = scanner.nextInt();
                    int validatedNum=validateInputNum(userInput);
                    if (reverseMyNum(validatedNum) != validatedNum) {
                        System.out.println("The number is not a palindrome");
                    } else {
                        System.out.println("The number is a palindrome");
                    }
                }
                case 7 -> {
                    System.out.println("Enter start number: ");
                    int start = scanner.nextInt();
                    System.out.println("Enter end number: ");
                    int end = scanner.nextInt();
                    printPrimeNumsInRange(start,end);
                    }
                case 8 -> {
                    System.out.println("Enter first integer");
                    int firstInteger = scanner.nextInt();
                    System.out.println("Enter second integer");
                    int secondInteger = scanner.nextInt();
                    int gcd = calculateGcd(firstInteger, secondInteger);
                    System.out.println("The gcd is:" + gcd);
                }
                case 9 -> {
                    System.out.println("Enter value for a in equation");
                    double a = scanner.nextDouble();
                    System.out.println("Enter value for b in equation");
                    double b = scanner.nextDouble();
                    System.out.println("Enter value for c in equation");
                    double c = scanner.nextDouble();
                    calculateSolutionsOfQuadraticEquation(a, b, c);
                }
                case 10 -> {
                    System.out.println("Enter your initial investment amount : ");
                    double initialFundAmount = scanner.nextDouble();
                    System.out.println("Enter your revolving interest amount : ");
                    double revolvingInterest = scanner.nextDouble();
                    revolvingInterest /= 100;
                    System.out.println("Simulation amount in withdrawal after a period of time by months: ");
                    double fundAmount;
                    double exitAmount;
                    double profit = initialFundAmount * revolvingInterest;
                    for (int months = 3; months <= 36; months += 3) {
                        double exitProfit = calculateExitProfit(profit, months);
                        exitAmount = initialFundAmount + exitProfit;
                        fundAmount = initialFundAmount + profit;
                        System.out.println("After " + months + " months , the withdrawal amount is " + exitAmount);
                        profit += fundAmount * revolvingInterest;
                    }
                }
                case 11 -> {
                    System.out.println("Enter a number: ");
                    int number = scanner.nextInt();
                    if (checkIfNumberIsFibonacci(number)) {
                        System.out.println("The number is part of Fibonacci sequence");
                    } else {
                        System.out.println("The number is not part of Fibonacci sequence");
                    }
                }
                case 12 -> {
                    System.out.println("Enter a positive integer");
                    int integerPositive = scanner.nextInt();
                    int closestNarcissistic = findClosestNarcissistic(integerPositive);
                    System.out.println("The closest narcissistic num is " + closestNarcissistic);
                }
                case 0 -> System.out.println("End");
                default -> System.out.println("No such option");
            }
        }
        while (menuOption != 0);
    }
    public static void displayOptions() {
        System.out.println("Option 1-Calculate the circumference and area of a circle");
        System.out.println("Option 2-convert temp from fahrenheit to celsius or the other way around");
        System.out.println("Option 3-Calculate factorial of a number");
        System.out.println("Option 4-Calculate the sum of natural numbers in a range");
        System.out.println("Option 5-Checking if a number is a prime number");
        System.out.println("Option 6-Checking if a 5 digit number is a palindrome");
        System.out.println("Option 7-Printing prime numbers in a range");
        System.out.println("Option 8-Calculation of GCD");
        System.out.println("Option 9-Calculate results of quadratic equation");
        System.out.println("Option 10-Calculation of compound interest");
        System.out.println("Option 11-Checking if a number is a part of Fibonacci sequence");
        System.out.println("Option 12-Printing the closest higher/lower narcissistic number to the input number ");
        System.out.println("Press zero to end the program");
    }
    public static double calculateCircleArea(double radius) {
        double pie = 3.14;
        return radius * radius * pie;
    }
    public static double calculateCircleCircumference(double radius) {
        double pie = 3.14;
        return pie * radius * 2;
    }
    public static int calculateFactorial(int inputNum) {
        while (inputNum <= 0) {
            System.out.println("Enter an integer higher than zero");
            inputNum = scanner.nextInt();
        }
        int factorial = 1;
        for (int i = 1; i <= inputNum; i++) {
            factorial *= i;
        }
        return factorial;
    }
    public static int calculateGcd(int numberOne, int numberTwo) {
        int gcd;
        if (numberTwo == 0) {
            gcd = numberOne;
        } else if (numberOne == 0) {
            gcd = numberTwo;
        } else {
            gcd = 1;
            for (int i = 1; (i <= numberOne && i <= numberTwo); i++) {
                if (numberOne % i == 0 && numberTwo % i == 0) {
                    gcd = i;
                }
            }
        }
        return gcd;
    }
    public static int validateInputNum(int number) {
        while (getNumOfDigits(number) != 5) {
            System.out.println("The num is not a 5 digits one. Enter a positive 5 digit num");
            number = scanner.nextInt();
        }
        return number;
    }
    public static int reverseMyNum(int inputNum) {
        int reverse = 0;
        int remain;
        while (inputNum != 0) {
            remain = inputNum % 10;
            reverse = reverse * 10 + remain;
            inputNum /= 10;
        }
        return reverse;
    }
    public static void calculateSolutionsOfQuadraticEquation(double a, double b, double c) {
        double discriminant = b * b - 4 * a * c;
        double result1, result2;
        if (a != 0) {
            if (discriminant > 0) {
                result1 = ((-b + Math.sqrt(discriminant)) / (2 * a));
                result2 = ((-b - Math.sqrt(discriminant)) / (2 * a));
                System.out.println("2 different roots:" + result1 + "," + " " + result2);
            } else if (discriminant == 0) {
                result1 = (-b / (2 * a));
                System.out.println("One root " + result1);
            } else {
                System.out.println("No roots");
            }
        } else {
            System.out.println("Value of a can not be zero, therefore no roots.");
        }
    }
    public static boolean checkIfPrime(int number) {
        boolean isTheNumPrime = true;
        if (number <= 1) {
            isTheNumPrime = false;
        } else {
            for (int i = 2; i <= number / 2; i++) {
                if (number % i == 0) {
                    isTheNumPrime = false;
                    break;
                }
            }
        }
        return isTheNumPrime;
    }
    public static boolean checkIfNumberIsFibonacci(int userInput) {
        int numInPlace1 = 0;
        int numInPlace2 = 1;
        int numInPlace3 = 0;
        while (numInPlace3 < userInput) {
            numInPlace3 = numInPlace1 + numInPlace2;
            numInPlace1 = numInPlace2;
            numInPlace2 = numInPlace3;
        }
        return numInPlace3 == userInput;
    }
    public static double calculateExitProfit(double exitProfit, int months) {
        if (months % 12 != 0) {
            exitProfit *= 0.5;
        }
        return exitProfit;
    }
    public static void convertTemperature(int baseChoice) {
        float fahrenheitTemp, celsiusTemp;
        if (baseChoice == 1) {
            System.out.println("Enter temp in Celsius");
            celsiusTemp = scanner.nextFloat();
            System.out.println("Your temp in Fahrenheit is" + " " + celsiusTemp * 1.8 + 32);
        } else if (baseChoice == 2) {
            System.out.println("Enter temp in Fahrenheit");
            fahrenheitTemp = scanner.nextFloat();
            System.out.println("Your temp in celsius is" + " " + (fahrenheitTemp - 32) / 1.8);
        } else {
            System.out.println("Choice error");
        }
    }
    public static int findClosestNarcissistic(int num) {
        int closestUp, closestDown = 0;
        int closestNarcissistic;
        int i = num + 1;
        while (true) {
            if (isNarcissisticCheck(i, getNumOfDigits(i))) {
                closestUp = i;
                break;
            }
            i++;
        }
        for (int j = num - 1; j > 0; j--) {
            if (isNarcissisticCheck(j, getNumOfDigits(j))) {
                closestDown = j;
                break;
            }
        }
        if ((num - closestDown) > (closestUp - num)) {
            closestNarcissistic = closestUp;
        } else {
            closestNarcissistic = closestDown;
        }
        return closestNarcissistic;
    }
    public static boolean isNarcissisticCheck(int num, int numOfDigits) {
        int sum = 0;
        int digitPower = 1;
        int unitDigit;
        int originalNum = num;
        while (num != 0) {
            unitDigit = num % 10;
            for (int i = 0; i < numOfDigits; i++) {
                digitPower *= unitDigit;
            }
            sum += digitPower;
            digitPower = 1;
            num /= 10;
        }
        return sum == originalNum;
    }
    public static int getNumOfDigits(int num) {
        int count = 0;
        while (num != 0) {
            num /= 10;
            count++;
        }
        return count;
    }
    public static int calculateSumOfNaturalsInRange(int startingNum, int endingNum) {
        int sum = 0;
        while (startingNum == endingNum) {
            System.out.println("Start and end nums can not be equal. please enter start num and end num again");
            startingNum = scanner.nextInt();
            endingNum = scanner.nextInt();
        }
        if (startingNum < endingNum) {
            for (int i = startingNum; i <= endingNum; i++) {
                if (checkIfNumIsPositive(i)) {
                    sum += i;
                }
            }
        } else {
            for (int i = endingNum; i <= startingNum; i++) {
                if (checkIfNumIsPositive(i)) {
                    sum += i;
                }
            }
        }
        return sum;
    }
    public static boolean checkIfNumIsPositive(int number) {
        return number > 0;
    }
    public static void printPrimeNumsInRange(int start, int end) {
        boolean hasPrimesInRange = false;
        for (int i = start; i <= end; i++) {
            if (checkIfPrime(i)) {
                System.out.print(i + ", ");
                System.out.println();
                hasPrimesInRange = true;
            }
        }
        if (!hasPrimesInRange) {
            System.out.println("No prime numbers in the range " + " " + start + " " + " to " + " " + end);
        }
    }
}
