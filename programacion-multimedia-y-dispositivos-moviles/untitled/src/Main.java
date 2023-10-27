import Interface.Presenter;
import Interface.MyInterface;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("Hello world!");

        MyInterface miPresentador = new Presenter();

        Thread thread = new Thread() {
            Scanner input = new Scanner(System.in);
            int inputValue = 0;
            while(true)

            {
                System.out.println("Simula un 0 - correcto");
                System.out.println("Simula un 1 - incorrecto");
                System.out.println("Dame un valor:");
                if (inputValue == 0) {
                    System.out.println("Success");
                    miPresentador.mostrarLoginCorrecto();
                } else {
                    System.out.println("Failure");
                    miPresentador.mostrarLoginIncorrecto();
                }
            }


        };
    }
}
