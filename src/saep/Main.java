package saep;

import Model.Professor;
import view.Login;

public class Main {
    public static Professor professor = null;
    
    public static void logout() {
        Main.professor = null;
        new Login().setVisible(true);
    }
    

    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}
