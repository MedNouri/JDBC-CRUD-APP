import java.sql.*;
import java.util.*;
import java.util.Date;

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
        System.out.println("2- Gestion des Commande");
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
                return;

            }else if (text == 2) {
                SearchClient();
                return;
            }
            else if (text == 3) {
                ChercherClientNom();
                return;
            }else if (text == 4){
                updateClien();
                return;

            }else if (text == 5){
                Supprimer();
                return;

            }
            else if (text == 6){
               getAllUsers();
                return;

            }
            else if (text == 7){
               DisplayClientnbrCommande();
                return;

            }
            else if (text == 8){
                DeleteifnoCommande();
                return;

            }
            else if (text == 9){
                SuppreimerWithNoCommande();
                return;

            }
            else if (text == 10){
                functionDisplayMenu();
                return;

            }


        }while (true);



    }

    private static void DeleteifnoCommande() {
    }

    private static void SuppreimerWithNoCommande() {
    }

    private static void DisplayClientnbrCommande() {
    }




    private static void Supprimer() {
        System.out.println("  Supprimer un Client");
        ClientDAOImpl clientDAO = new ClientDAOImpl();

        clientDAO.delete(1221215);

    }

    public static  void updateClien(){
        System.out.println("  Modiffier un Client");
        ClientDAOImpl clientDAO = new ClientDAOImpl();
        Client RecivedCleint =  clientDAO.findById(1221215);
        System.out.print(RecivedCleint.getAdresse());
        clientDAO.update(RecivedCleint);

    }
    public static  void GestionDesCommande(){
        System.out.println("---------------------Gestion des Commandes---------------------");
        System.out.println("1- Ajouter une Commande");
        System.out.println("2- Chercher Commande  par id ");
        System.out.println("3- Chercher Client par Nom Client");
        System.out.println("4- Modiffier une Commande");
        System.out.println("5- Supprimer une Commande");
        System.out.println("6- Affichier la liste des Commandes");
        System.out.println("7- Aller au MENU PRINCIPAL");


        int text= scan.nextInt();
        do {
            if (text == 1){
                //Ajouter une Commande
                AjouterunCommande();
                return;

            }else if (text == 2) {
                SeachCommandeID();
                return;
            }
            else if (text == 3) {
                SeachCommandeWithNameClient();
                return;
            }else if (text == 4){
                updateCommande();
                return;

            }else if (text == 5){
                SupprimerCommande();
                return;

            }
            else if (text == 6){
                ShowAllcommandes();
                return;

            }
            else if (text == 7){
                functionDisplayMenu();
                return;

            }



        }while (true);


    }

    private static void updateCommande() {
    }

    private static void SeachCommandeWithNameClient() {
    }

    private static void SupprimerCommande() {
        System.out.println("   Supprimer Une Commande");
        CommandeDAOImpl commande = new CommandeDAOImpl();

        commande.delete(1);
    }

    private static void ShowAllcommandes() {
        CommandeDAOImpl commande = new CommandeDAOImpl();

        for (Commande RecivedCleint: commande.getAll()) {
            System.out.println("**********************************************");
            System.out.println(" Pttc " + RecivedCleint.getPttc());
            System.out.println("Date " + RecivedCleint.getDate());
            System.out.println("client ID " + RecivedCleint.getIdclient());
            System.out.println("**********************************************");

        }

    }

    private static void SeachCommandeID() {
        CommandeDAOImpl commande = new CommandeDAOImpl();
        Scanner scan = new Scanner(System.in);
        System.out.println("Chercher Commande   ");

        System.out.println("Ecrire id commande ");
        int id = scan.nextInt();

        Commande RecivedCleint =  commande.findById(id);
        System.out.println("*************Result 100% success**************");
        if (RecivedCleint != null) {
            System.out.println(" Pttc " + RecivedCleint.getPttc());
            System.out.println("Date " + RecivedCleint.getDate());
            System.out.println("client ID " + RecivedCleint.getIdclient());
            System.out.println("**********************************************");
        }else{
            System.out.println("Sorry Not Found ");
        }
        GestionDesClient();

    }

    private static void AjouterunCommande() {
        CommandeDAOImpl commande = new CommandeDAOImpl();
        Scanner scan = new Scanner(System.in);
        System.out.println("Ajouter une commande ");

        System.out.println("Ecrire pttc ");

        String pttc = scan.nextLine();
        System.out.println("Ecrire id client ");
        int id = scan.nextInt();
          Date today = new  Date();
        Commande newC = new Commande(id,pttc,today);
        commande.insert(newC);
        System.out.println("Done 100% success");
        GestionDesClient();
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


    public static void getAllUsers() {

        ClientDAOImpl clientDAO = new ClientDAOImpl();

        for (Client user: clientDAO.getAll()) {
            System.out.println("**********************************************");
            System.out.println("client Name " + user.getNom());
            System.out.println("client Adr " + user.getNom());
            System.out.println("client tel " + user.getTelephone());
            System.out.println("**********************************************");

        }

    }
}
