import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SimpleChatbot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello! I'm your chatbot. What's your name?");
        String userName = scanner.nextLine();

        System.out.println("Nice to meet you, " + userName + "!");
        System.out.println("You can start chatting with me. Type 'bye' to exit.");

        String userInput;
        do {
            System.out.print(userName + ": ");
            userInput = scanner.nextLine();

            String response = getResponse(userInput, userName);
            System.out.println("Chatbot: " + response);
        } while (!userInput.equalsIgnoreCase("bye"));

        System.out.println("Goodbye, " + userName + "! Have a great day!");
        scanner.close();
    }

    public static String getResponse(String userInput, String userName) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date currentDate = new Date();

        if (userInput.matches(".*[+\\-*/].*")) {
            try {
                double result = evaluateExpression(userInput);
                return "The result is: " + result;
            } catch (Exception e) {
                return "Sorry, I couldn't calculate that. Please check your input.";
            }
        }

        switch (userInput.toLowerCase()) {
            case "how are you":
            case "how are you?":
                return "I'm just a computer program, so I don't have feelings, but thanks for asking!";

            case "what is a computer?":
            case "what is a computer":
                return "A computer is an electronic device that manipulates information, or data. It has the ability to store, retrieve, and process data. You may already know that you can use a computer to type documents, send email, play games, and browse the Web.";

            case "what is java?":
            case "what is a java":
            case "explain java?":
            case "explain java":
            case "java":
                return "Java is a widely-used programming language for coding web applications. It has been a popular choice among developers for over two decades, with millions of Java applications in use today. Java is a multi-platform, object-oriented, and network-centric language that can be used as a platform in itself. It is a fast, secure, reliable programming language for coding everything from mobile apps and enterprise software to big data applications and server-side technologies.";

            case "hello":
                return "Hello, " + userName + "!";

            case "hi":
                return "Hi, " + userName + "!";

            case "date":
            case "time":
            case "date and time":
            case "tell me the date and time":
            case "tell me the date":
            case "tell me the time":
                return dateFormat.format(currentDate);

            case "what's your name?":
            case "what's your name":
            case "what is your name?":
            case "what is your name":
                return "I'm just a simple chatbot.";

            case "who created you?":
            case "who created you":
            case "who made you?":
            case "who made you":
                return "I was created by vaibhav kesarwani.";

            case "tell me a joke":
                return "Why did the computer keep freezing? Because it had too many chill-dren!";

            case "tell me a riddle":
                return "I'm tall when I'm young and short when I'm old. What am I?";

            case "tell me a fun fact":
                return "Did you know that honey never spoils? Archaeologists have found pots of honey in ancient Egyptian tombs that are over 3,000 years old and still perfectly edible!";

            case "tell me a quote":
                return "Here's a famous quote: 'The only way to do great work is to love what you do.' - Steve Jobs";

            case "what is the weather like today?":
                return "I'm sorry, I don't have access to real-time weather information.";

            case "tell me about space":
                return "Space, also known as outer space, is the vast expanse beyond Earth's atmosphere. It's nearly a perfect vacuum and contains stars, planets, moons, asteroids, comets, and more. Space is a subject of great interest for astronomers and scientists who study the universe and its mysteries.";

            case "how does photosynthesis work?":
                return "Photosynthesis is the process by which green plants and some other organisms convert carbon dioxide and water into glucose (a sugar) using sunlight. This process provides oxygen as a byproduct and is essential for the growth of plants and the production of oxygen in the atmosphere.";

            case "what are the benefits of exercise?":
                return "Exercise has numerous benefits, including improved physical fitness, increased strength, better cardiovascular health, weight management, reduced stress, enhanced mood, and a reduced risk of chronic diseases like heart disease and diabetes.";

            case "what is the capital of india?":
                return "The capital of India is New Delhi.";

            case "can you tell me a tongue twister?":
                return "Sure, here's a tongue twister: 'She sells seashells by the seashore. The shells she sells are surely seashells.'";

            case "what is the largest desert in the world?":
                return "The largest desert in the world is the Antarctic Desert, followed by the Arctic Desert. These icy regions are classified as deserts due to their low precipitation levels.";

            case "bye":
                return "Goodbye!";

            default:
                return "I didn't quite understand that. Can you please rephrase?";
        }
    }

    public static double evaluateExpression(String expression) {
        String[] parts = expression.split(" ");
        double operand1 = Double.parseDouble(parts[0]);
        double operand2 = Double.parseDouble(parts[2]);
        String operator = parts[1];

        double result;

        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                if (operand2 != 0) {
                    result = operand1 / operand2;
                } else {
                    throw new ArithmeticException("Division by zero is not allowed.");
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }

        return result;
    }
}