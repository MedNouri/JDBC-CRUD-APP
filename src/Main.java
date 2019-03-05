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

            functionDisplayMenu();
        }catch (SQLException e){
            System.out.print(e);
        }finally {
            if (connection != null){
               // connection.close();
            }
        }

    }


    public static void functionDisplayMenu(){
        System.out.print("\n---------------------Menu---------------------\n");
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
        System.out.println("---------------------Gestion des Clients---------------------");
        System.out.println("1- Ajouter un Client");
        System.out.println("2- Chercher Client par id ");
        System.out.println("3- Chercher Client par Nom");
        System.out.println("4- Modiffier un Client");
        System.out.println("5- Supprimer Client par id ");
        System.out.println("6- Affichier la liste des clients");
        System.out.println("7- Afficher nobmbre de Commande par Client");
        System.out.println("8- Suppreimer Client qui n'ont pas des commande ");
        System.out.println("9- Afficher Client par idd Commande");

        System.out.println("10- Aller au MENU PRINCIPAL");

        int text= scan.nextInt();
        do {
            if (text == 1){
                //Ajouter un Client
                AjouterunClient();

            }else if (text == 2) {
                SearchClient();
            }
            else if (text == 3) {
                ChercherClientNom();
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
    public static  void AjouterunClient(){
        ClientDAOImpl clientDAO = new ClientDAOImpl();
          Scanner scan = new Scanner(System.in);
        System.out.println("Ajouter un Client ");

        System.out.println("Ecrire nom ");
        String name = scan.nextLine();
        System.out.println("Ecrire adresse ");
        String adresse = scan.nextLine();
        System.out.println("Ecrire telephone ");
        String telephone = scan.nextLine();
        Client newclient = new Client(name,adresse,telephone);
        clientDAO.insert(newclient);
        System.out.println("Done 100% success");
        GestionDesClient();
    }


    public static  void SearchClient(){
        ClientDAOImpl clientDAO = new ClientDAOImpl();
        Scanner scan = new Scanner(System.in);
        System.out.println("Chercher Client   ");

        System.out.println("Ecrire id ");
        int id = scan.nextInt();

    Client RecivedCleint =  clientDAO.findById(id);
        System.out.println("*************Result 100% success**************");
        if (RecivedCleint != null) {
            System.out.println("client Name " + RecivedCleint.getNom());
            System.out.println("client Adr " + RecivedCleint.getNom());
            System.out.println("client tel " + RecivedCleint.getTelephone());
            System.out.println("**********************************************");
        }else{
            System.out.println("Sorry Not Found ");
        }
        GestionDesClient();
    }

    public static  void ChercherClientNom(){
        ClientDAOImpl clientDAO = new ClientDAOImpl();
        Scanner scan = new Scanner(System.in);
        System.out.println("Chercher Client   ");

        System.out.println("Ecrire nom ");
        String nom = scan.nextLine();

        Client RecivedCleint =  clientDAO.findByName(nom);
        System.out.println("*************Result 100% success**************");
        if (RecivedCleint != null) {
            System.out.println("client Name " + RecivedCleint.getNom());
            System.out.println("client Adr " + RecivedCleint.getNom());
            System.out.println("client tel " + RecivedCleint.getTelephone());
            System.out.println("**********************************************");
        }else{
            System.out.println("Sorry Not Found ");
        }
        GestionDesClient();
    }





}
