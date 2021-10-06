package se.fredrik;

import static com.diogonunes.jcolor.Ansi.*;
import static com.diogonunes.jcolor.Attribute.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
       
public class BankSystem {
    
    
    String senasteTransaktionUt = "";
    String senasteTransaktionIn = "";
    String email = "";
    String email1 = "";
    String out = colorize("Uttag", RED_TEXT());
    String in = colorize("Insättning", GREEN_TEXT());
    int pin2 = 0;
    int saldo = 0;
    int taUt = 0;
    int sattIn = 0;
 
    public void visaMeny() {

        while (true) {
            System.out.println(colorize("\n*** INLOGGAD ***", YELLOW_TEXT()));
            System.out.println("\n1. Ta ut pengar.");
            System.out.println("2. Sätt in pengar.");
            System.out.println("3. Kolla saldo.");
            System.out.println("4. Visa transaktioner.");
            System.out.println("0. Logga Ut/huvudmeny.");
            System.out.println(colorize("\nVad vill du göra: ", GREEN_TEXT()));
            int choice = Integer.parseInt(System.console().readLine());

            if (choice == 1) {

                if (saldo <= 0) {
                    System.out.println("Du har inga pengar på kontot. Sätt in pengar först");
                } else {
                    System.out.print("Hur mycket vill du ta ut? ");
                    taUt = Integer.parseInt(System.console().readLine());
                    System.out.println("Uttag: " + taUt + "kr");
                    senasteTransaktionUt = new SimpleDateFormat("yyyy-MM-dd  HH:mm.ss")
                            .format(Calendar.getInstance().getTime());
                    if (taUt > saldo) {
                        System.out.println("Du har inte tillräckligt med pengar");
                    } else {
                        saldo = saldo - taUt;
                    }
                }
            }

            else if (choice == 2)

                while (true) {
                    System.out.println("Hur mycket pengar vill du sätta in: ");
                    sattIn = Integer.parseInt(System.console().readLine());
                    senasteTransaktionIn = new SimpleDateFormat("yyyy-MM-dd  HH:mm.ss")
                            .format(Calendar.getInstance().getTime());

                    if (sattIn <= 0) {
                        System.out.println("Du kan inte sätta in 0kr.");
                        System.out.println("Försök igen!.");

                    } else {
                        saldo = saldo + sattIn;
                        System.out.println("Insättning: " + saldo + "kr");
                        break;
                    }

                }
            else if (choice == 3) {
                System.out.println(colorize("*** SALDO ***", YELLOW_TEXT()));

                System.out.println("Ditt saldo är: " + saldo);

            } else if (choice == 4) {

                System.out.println(colorize("*** TRANSAKTIONER ***", YELLOW_TEXT()));
                System.out.println("\nDin email: " + email1 + "\nTyp: " + in + "\nKronor " + sattIn + "\nTid: "
                        + senasteTransaktionIn);
                System.out.println("\nDin email: " + email1 + "\nTyp: " + out + "\nKronor " + taUt + "\nTid: "
                        + senasteTransaktionUt);

            } else if (choice == 0) {
                break;
            } else {
                System.out.println(colorize("\nFelaktig inmatat val!", RED_TEXT()));
                System.out.println(colorize("Försök igen!", RED_TEXT()));
            }

        }
    }

    public void skapaNyttKonto() {

        System.out.println("\n*** NYTT KONTO ***");
        System.out.print("\nEmail: ");
        String mail = (System.console().readLine());
        System.out.print("Password: ");
        int password = Integer.parseInt(System.console().readLine());

        email1 = mail;
        pin2 = password;
        return;

    }

    public void login() {

        while (true) {
            System.out.println(colorize("\n*** Login ***", YELLOW_TEXT()));
            System.out.print("\nEmail: ");
            String userName = (System.console().readLine());
            System.out.print("Pincode: ");
            int pinCode = Integer.parseInt(System.console().readLine());

            if (!userName.equals(email1) && pinCode != pin2) {
                System.out.println(colorize("Felaktig, du måste skapa ett konto först.", RED_TEXT()));
                skapaNyttKonto();

            } else {
                System.out.println(colorize("Välkommen!", GREEN_TEXT()));
                break;
            }

        }

    }

    public void run() {

        while (true) {
            System.out.println(colorize("\n*** HUVUDMENY ***", YELLOW_TEXT()));
            System.out.println("\n1. Login");
            System.out.println("2. Skapa konto");
            System.out.println("3. Avsluta programmet");
            System.out.print(colorize("\nVad vill du göra: ", GREEN_TEXT()));
            int userInput = Integer.parseInt(System.console().readLine());

            if (userInput == 3) {
                System.out.println(colorize("\nVälkommen tillbaka!", RED_TEXT()));
                break;
            }

            if (userInput == 1) {
                login();
                visaMeny();
            }
            if (userInput == 2) {
                skapaNyttKonto();
            }

        }
    }

}