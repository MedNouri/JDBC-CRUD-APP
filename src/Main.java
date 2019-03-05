import java.sql.*;
import java.util.Scanner;

public class Main {

    private static final String DATABASE_URL = "jdbc:mysql://localhost/BDClient";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "FOSRoKl6pJ7VZ6ay";
    private static Scanner scan= new Scanner(System.in);
    public static void main(String[] args) throws SQLException {


        Connection connection = null;
        try {
           connection = Connexion.getInstance().getConnection();
             System.out.print("connected");
            functionDisplayMenu();
        }catch (SQLException e){
            System.out.print(e);
        }finally {
            if (connection != null){
                connection.close();
            }
        }

    }


    public static void functionDisplayMenu(){
        System.out.print("---------------------Menu---------------------\n");
        System.out.println("1- Gestion des Clients");
        System.out.println("1- Gestion des Commande");
        System.out.println("3- Quitter le programme");

        int text= scan.nextInt();
        do {
           if (text == 1){
               GestionDesClient();
           }else if (text == 2) {
               GestionDesCommande();
           }
           else if (text == 3) {
               closeout();
           }


        }while (true);
    }

    public static  void GestionDesClient(){
        System.out.print("---------------------Gestion des Clients---------------------");
        System.out.println("1- Ajouter un Client");
        System.out.println("1- Chercher Client par id ");
        System.out.println("3- Chercher Client par Nom");
        System.out.println("4- Modiffier un Client");
        System.out.println("5- Supprimer Client par id ");
        System.out.println("6- Affichier la liste des clients");
        System.out.println("7- Afficher nobmbre de Commande par Client");
        System.out.println("8- Suppreimer Client qui n'ont pas des commande ");
        System.out.println("9- Afficher Client par idd Commande");

        System.out.println("10- Aller au MENU PRINCIPAL");
        System.out.println("10- Aller au MENU PRINCIPAL");

        int text= scan.nextInt();
        do {
            if (text == 1){

            }else if (text == 2) {

            }
            else if (text == 3) {

            }


        }while (true);



    }
    public static  void GestionDesCommande(){
        System.out.print("---------------------Gestion des Commandes---------------------");
        System.out.println("1- Ajouter une Commande");
        System.out.println("1- Chercher Commande  par id ");
        System.out.println("3- Chercher Client par Nom Client");
        System.out.println("4- Modiffier une Commande");
        System.out.println("5- Supprimer une Commande");
        System.out.println("6- Affichier la liste des Commandes");
        System.out.println("10- Aller au MENU PRINCIPAL");
    }
    public static  void closeout(){

    }

}
