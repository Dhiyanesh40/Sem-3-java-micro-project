import java.util.Scanner;
import java.text.DecimalFormat;
import java.lang.Math;

class UserProfile {
    String name;
    double height; // in meters
    double weight; // in kilograms
    int age;
    String gender;
    String activityLevel;
    boolean athlete;

    // Constructor
    public UserProfile(String name, double height, double weight, int age, String gender, String activityLevel, boolean athlete) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.gender = gender;
        this.activityLevel = activityLevel;
        this.athlete = athlete;
    }

    // Method to calculate BMI
    public double calculateBMI() {
        return weight / Math.pow(height, 2);
    }

    // Overloaded method for calculating BMI for athletes
    public double calculateBMI(boolean athlete) {
        if (athlete) {
            return calculateBMI() - 1.0; // Adjustment for athletes
        } else {
            return calculateBMI();
        }
    }

    // Method to provide health advice based on BMI and other parameters
    public String getHealthAdvice(double bmi) {
        StringBuilder advice = new StringBuilder();

        if (bmi < 18.5) {
            advice.append("\u001B[33mYou are underweight.\u001B[0m\n\n");
            advice.append("\n\u001B[34mYour Health Advice:\u001B[0m\n\n");
            advice.append("It's important to gain weight in a healthy way to improve your overall health.\n\n");
            advice.append("\u001B[34mSuggested Schedule: \u001B[0m\n\n");
            advice.append("1. Increase your calorie intake with healthy foods like nuts, avocados, and whole grains.\n");
            advice.append("2. Add protein-rich foods like lean meats, eggs, and beans to help with muscle building.\n");
            advice.append("3. Engage in strength training exercises 3-4 times a week to build muscle mass.\n");
            advice.append("4. Consider speaking to a nutritionist to ensure you're gaining weight safely.\n\n");
        } else if (bmi >= 18.5 && bmi < 24.9) {
            advice.append("\u001B[32mYou have a normal weight.\u001B[0m\n");
            advice.append("\n\u001B[34mYour Health Advice:\u001B[0m\n\n");
            advice.append(" Keep maintaining a healthy lifestyle to stay fit.\n\n");
            advice.append("\u001B[34mSuggested Schedule: \u001B[0m\n\n");
            advice.append("1. Continue with a balanced diet of lean proteins, fruits, vegetables, and whole grains.\n");
            advice.append("2. Maintain your physical activity with a mix of cardio (3-4 times a week) and strength training (2-3 times a week).\n");
            advice.append("3. Stay hydrated and get enough sleep to support your active lifestyle.\n");
            advice.append("4. Keep monitoring your health with regular checkups and stay consistent with your routine.\n\n");
        } else if (bmi >= 25 && bmi < 29.9) {
            advice.append("\u001B[33mYou are overweight.\u001B[0m\n");
            advice.append("\n\u001B[34mYour Health Advice:\u001B[0m\n\n");
            advice.append("Consider making some changes to reduce weight in a healthy and sustainable way.\n\n");
            advice.append("\u001B[34mSuggested Schedule: \u001B[0m\n\n");
            advice.append("1. Reduce calorie intake by focusing on nutrient-dense foods like vegetables, fruits, and lean proteins.\n");
            advice.append("2. Increase cardiovascular exercises (e.g., walking, jogging, cycling) to burn fat and improve heart health.\n");
            advice.append("3. Include strength training twice a week to build lean muscle and increase metabolism.\n");
            advice.append("4. Aim for at least 150 minutes of moderate-intensity activity per week.\n");
            advice.append("5. Consult with a fitness coach or dietitian to create a personalized workout and meal plan.\n\n");
        } else {
            advice.append("\u001B[31mYou are obese.\u001B[0m\n");
            advice.append("\n\u001B[34mYour Health Advice:\u001B[0m\n\n");
            advice.append("It's important to start making changes for your health.\n\n");
            advice.append("\u001B[34mSuggested Schedule: \u001B[0m\n\n");
            advice.append("1. Focus on creating a calorie deficit by reducing processed foods, sugary drinks, and unhealthy snacks.\n");
            advice.append("2. Incorporate daily walks or light exercises, gradually increasing the intensity as you build endurance.\n");
            advice.append("3. Aim for at least 30 minutes of moderate-intensity exercise most days of the week.\n");
            advice.append("4. Work on improving your eating habits by choosing whole foods, avoiding overeating, and controlling portion sizes.\n");
            advice.append("5. Consider consulting with a doctor before starting a weight loss plan for personalized advice.\n\n");
        }

        if (age >= 40) {
            advice.append("As you are over 40, make sure to monitor your health regularly and adjust your exercise intensity as needed.\n");
        }

        if (gender.equalsIgnoreCase("female") && bmi < 18.5) {
            advice.append("For women with low BMI, ensure that you are also focusing on bone health by including calcium and vitamin D in your diet.\n");
        }

        if (activityLevel.equalsIgnoreCase("high")) {
            advice.append("Since you have a high activity level, you should focus on recovery as much as the exercise itself. Incorporate rest days and active recovery activities like yoga or stretching.\n");
        }

        return advice.toString();
    }
}

public class BMI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");

        // Welcoming the user
        System.out.println("**************************************************************");
        System.out.println("*           Welcome to the BMI Calculation System!           *");
        System.out.println("*    Calculate your BMI here and improve your lifestyle!     *");
        System.out.println("**************************************************************");
        System.out.println("*   Let's get started on your journey to a healthier life!   *");
        System.out.println("**************************************************************");

        System.out.println("\n\u001B[34mPlease enter your details to get started:\u001B[0m\n");

        // Gathering user inputs with exception handling

        // Input for name
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // Input validation for age
        int age = -1;
        while (age <= 0) {
            try {
                System.out.print("Enter your age: ");
                age = Integer.parseInt(scanner.nextLine());
                if (age <= 0) {
                    System.out.println("\u001B[31mInvalid input. Age must be a positive integer.\u001B[0m");
                }
            } catch (NumberFormatException e) {
                System.out.println("\u001B[31mInvalid input. Please enter a valid age.\u001B[0m");
            }
        }

        // Input validation for gender
        String gender = "";
        while (true) {
            System.out.print("Enter your gender (Male/Female): ");
            gender = scanner.nextLine();
            if (gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female")) {
                break;
            } else {
                System.out.println("\u001B[31mInvalid input. Please enter either 'Male' or 'Female'.\u001B[0m");
            }
        }

        // Input validation for height
        double height = -1;
        while (height <= 0) {
            try {
                System.out.print("Enter your height in meters (e.g., 1.75): ");
                height = Double.parseDouble(scanner.nextLine());
                if (height <= 0) {
                    System.out.println("\u001B[31mHeight must be a positive number.\u001B[0m");
                }
            } catch (NumberFormatException e) {
                System.out.println("\u001B[31mInvalid input. Please enter a valid height.\u001B[0m");
            }
        }

        // Input validation for weight
        double weight = -1;
        while (weight <= 0) {
            try {
                System.out.print("Enter your weight in kilograms (e.g., 70): ");
                weight = Double.parseDouble(scanner.nextLine());
                if (weight <= 0) {
                    System.out.println("\u001B[31mWeight must be a positive number.\u001B[0m");
                }
            } catch (NumberFormatException e) {
                System.out.println("\u001B[31mInvalid input. Please enter a valid weight.\u001B[0m");
            }
        }

        // Input validation for activity level
        String activityLevel = "";
        while (true) {
            System.out.print("Enter your activity level (low/medium/high): ");
            activityLevel = scanner.nextLine();
            if (activityLevel.equalsIgnoreCase("low") || activityLevel.equalsIgnoreCase("medium") || activityLevel.equalsIgnoreCase("high")) {
                break;
            } else {
                System.out.println("\u001B[31mInvalid input. Please enter 'low', 'medium', or 'high'.\u001B[0m");
            }
        }

        // Input validation for athlete status
        boolean athlete = false;
        while (true) {
            System.out.print("Are you an athlete? (true/false): ");
            String input = scanner.nextLine().trim().toLowerCase();  // Get the input and trim any leading/trailing spaces
        
            if (input.equals("true") || input.equals("false")) {
                athlete = Boolean.parseBoolean(input);  // Only set the athlete variable if input is valid
                break;
            } else {
                System.out.println("\u001B[31mInvalid input. Please enter 'true' or 'false'.\u001B[0m");
            }
        }
        

        // Creating UserProfile object
        UserProfile user = new UserProfile(name, height, weight, age, gender, activityLevel, athlete);

        // Calculating BMI based on athlete status
        double bmi = user.calculateBMI(athlete);

        // Displaying the BMI result
        System.out.printf("\n\nYour BMI is: %.2f%n\n\n", bmi);

        // Providing detailed health advice
        String advice = user.getHealthAdvice(bmi);
        System.out.println(advice);

        scanner.close();  // Closing the scanner
    }
}
