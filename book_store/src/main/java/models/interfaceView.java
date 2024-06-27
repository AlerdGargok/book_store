package models;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import controllers.Cadastro;

public interface interfaceView {

    Cadastro cadastro = new Cadastro();
    Scanner scanner = new Scanner(System.in);

    public default void Flush() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
