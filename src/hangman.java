import java.util.ArrayList;
import java.util.Scanner;

public class hangman {


    private ArrayList<Character> arrayHidden;
    private ArrayList<Character> guiDisplay;
    private ArrayList<Character> alreadyGuessed;

    private int stringLength;
    private String tempVar = "test";
    private int guess = 5;

    private boolean userRedo ;

    //
    public hangman() {
        stringLength = tempVar.length();
        storeArrays();
        Scanner in = new Scanner(System.in);
        alreadyGuessed = new ArrayList<>();
        while (guess > 0 && !isSolved()) {

            System.out.println("Enter a character\n");
            String currentGuess = in.nextLine();
            char charVariant = currentGuess.toLowerCase().charAt(0);

            if (currentGuess.matches("^[a-zA-Z]*$") && (currentGuess.length() == 1)) {
                if (arrayHidden.contains(charVariant)) {
                    if (!alreadyGuessed.contains(currentGuess)) {
                        for (int i = 0; i < arrayHidden.size(); i++) {
                            if (arrayHidden.get(i) == (charVariant)) {
                                guiDisplay.set(i, charVariant);
                                alreadyGuessed.add(charVariant);
                                if (isSolved()){
                                    System.out.println("You Win");
                                    break;

                                }


                            }
                        }

                        System.out.println(currentGuess + " is in the word!");


                    }

                } else {
                    if(guess>1) {
                        System.out.println("Try again");
                        guess--;
                        alreadyGuessed.add(currentGuess.charAt(0));
                    }
                    else{
                        System.out.println("ran out of guesses");
                        break;


                    }


                }
            } else {
                System.out.println("invalid input");

            }

            System.out.println(guiDisplay.toString());

        }

        System.out.println("\n\n");

        do {
           System.out.println("1 to play again, anything else to exit");
           int answer = in.nextInt();
           if(answer == 1){
               System.out.println("\n");
               new hangman();
           }
           else{
               System.exit(0);

           }

        }while(userRedo == false);


    }



    public void storeArrays(){

        arrayHidden = new ArrayList<>(stringLength);
        guiDisplay = new ArrayList<>(stringLength);

        for(int i=0; i<stringLength; i++){
            arrayHidden.add(tempVar.charAt(i));

            guiDisplay.add('_');



        }

    }

    private boolean isSolved(){
        if(guiDisplay.toString().contains("_")){
            return false;
        }
        return true;

    }
    public static void main(String[] args) {
    hangman e = new hangman();


    }
}
