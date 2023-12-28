public class PalPrime {
    private int number;

    public PalPrime(int number) {
        this.number = number;
        printMessage();
    }

    private void printMessage() {
        String message = "Number " + number + " is ";

        if (isPalindrome(number)) {
            message += "Palindrome";
            if (isPrime(number)) {
                message += "/Prime";
            }
        } else if (isPrime(number)) {
            message += "Prime";
        } else {
            message += "neither Palindrome nor Prime";
        }

        System.out.println(message);
    }

    private boolean isPalindrome(int num) {
        int original = num;
        int reversed = 0;

        while (num > 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }

        return original == reversed;
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] numbers = {121, 131, 23, 7, 10};

        for (int number : numbers) {
            new PalPrime(number);
        }
    }
}
