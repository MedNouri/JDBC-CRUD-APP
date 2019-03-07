import java.sql.*;
import java.util.*;
import java.util.Date;

public class Main {
    private static CommandeDAOImpl commande = new CommandeDAOImpl();
    private static Scanner scan = new Scanner(System.in);
    private static ClientDAOImpl clientDAO = new ClientDAOImpl();
    public static void main(String[] args) throws SQLException {


            functionDisplayMenu();


    }


    public static void functionDisplayMenu(){
        System.out.println("\n---------------------Menu---------------------\n");
        System.out.println("1- Gestion des Clients");
        System.out.println("2- Gestion des Commande");
        System.out.println("3- Quitter le programme");

        int text= scan.nextInt();
        do {
           if (text == 1){
               GestionDesClient();
               return;
           }else if (text == 2) {
               GestionDesCommande();
               return;
           }
           else if (text == 3) {
               closeout();
               return;
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

        System.out.println("9- Afficher Client par id Commande");

        System.out.println("10- Aller au MENU PRINCIPAL");

        int text= scan.nextInt();
        do {
            if (text == 1){
                //Ajouter un Client
                AjouterunClient();
                return;

            }else if (text == 2) {
                //Search un Client
                SearchClient();
                return;
            }
            else if (text == 3) {
                //Search un Client with Name
                ChercherClientNom();
                return;
            }else if (text == 4){
                updateClient();
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
                SuppreimerWithNoCommande();
                return;

            }
            else if (text == 9){
                ShowInfo();
                return;

            }
            else if (text == 10){
                functionDisplayMenu();
                return;

            }


        }while (true);



    }

    private static void ShowInfo() {
       clientDAO.ShowCommandeAndCleint() ;
        functionDisplayMenu();

    }

    private static void SuppreimerWithNoCommande() {
        if (clientDAO.deleteNoCommande() == 1){
            System.out.println("Done 100% success");
        }
        else{
            System.out.println("Sorry Not Found ");
        }
        functionDisplayMenu();
    }

    private static void DisplayClientnbrCommande() {

        for (Client user: clientDAO.getAllParCommande()) {
            user.Display();

        }
        functionDisplayMenu();
    }




    private static void Supprimer() {
        System.out.println("  Supprimer un Client");

        Scanner scan = new Scanner(System.in);
        System.out.println("  Donner ID CLIENT ");

        int id = scan.nextInt();
        if (clientDAO.delete(id) == 1){
            System.out.println("Done 100% success");
        }
        else{
            System.out.println("Sorry Not Found ");
        }
        functionDisplayMenu();
    }

    public static  void updateClient(){
        System.out.println("  Modiffier un Client");
        Scanner scan = new Scanner(System.in);
        System.out.println("  Donner ID CLIENT ");

        int id = scan.nextInt();
        ClientDAOImpl clientDAO = new ClientDAOImpl();
        Client RecivedCleint =  clientDAO.findById(id);

        if (RecivedCleint != null) {
            System.out.println("user was Found");
            RecivedCleint.Display();
            clientDAO.update(RecivedCleint);
        }else{
            System.out.println("Sorry Not Found ");
        }
        System.out.println("Done 100% success");
        functionDisplayMenu();


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


        System.out.println("  Modiffier une Commande");
        Scanner scan = new Scanner(System.in);
        System.out.println("  Donner ID Commande ");

        int id = scan.nextInt();

        Commande c =  commande.findById(id);

        if (c != null) {
            System.out.println("Commande was Found");
            c.Display();
            commande.update(c);
        }else{
            System.out.println("Sorry Not Found ");
        }
        System.out.println("Done 100% success");
        functionDisplayMenu();


    }

    private static void SeachCommandeWithNameClient() {
        System.out.println("   Supprimer Une Commande");
        CommandeDAOImpl commande = new CommandeDAOImpl();
        Scanner scan = new Scanner(System.in);
        System.out.println("Ecrire Nom Client ");
        String name = scan.nextLine();
        Commande Recived = commande.findByName(name);
        System.out.println("*************Result 100% success**************");
        if (Recived  != null) {
            Recived.Display();
        }else{
            System.out.println("Sorry Not Found ");
        }
        functionDisplayMenu();
    }

    private static void SupprimerCommande() {
        System.out.println("   Supprimer Une Commande");

        System.out.println("Ecrire id commande ");
        int id = scan.nextInt();

        if (commande.delete(id) == 1){
            System.out.println("Done 100% success");
        }
        else{
            System.out.println("Sorry Not Found ");
        }

    }

    private static void ShowAllcommandes() {


        for (Commande RecivedCleint: commande.getAll()) {
            RecivedCleint.Display();

        }

    }

    private static void SeachCommandeID() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Chercher Commande   ");

        System.out.println("Ecrire id commande ");
        int id = scan.nextInt();

        Commande RecivedCleint =  commande.findById(id);
        System.out.println("*************Result 100% success**************");
        if (RecivedCleint != null) {
           RecivedCleint.Display();
        }else{
            System.out.println("Sorry Not Found ");
        }
        functionDisplayMenu();

    }

    private static void AjouterunCommande() {

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
        functionDisplayMenu();
    }

    public static  void closeout(){
        System.out.println("Good bye");

        return;

    }

    public static  void AjouterunClient(){

          Scanner scan = new Scanner(System.in);
        System.out.println("Ajouter un Client ");

        System.out.println("Ecrire le nom ");
        String name = scan.nextLine();
        System.out.println("Ecrire adresse ");
        String adresse = scan.nextLine();
        System.out.println("Ecrire telephone ");
        String telephone = scan.nextLine();
        Client newclient = new Client(name,adresse,telephone);
        clientDAO.insert(newclient);
        System.out.println("Done 100% success");
        functionDisplayMenu();
    }


    public static  void SearchClient(){

        Scanner scan = new Scanner(System.in);
        System.out.println("Chercher Client   ");

        System.out.println("Ecrire id ");
        int id = scan.nextInt();

       Client RecivedCleint =  clientDAO.findById(id);
        System.out.println("*************Result 100% success**************");
        if (RecivedCleint != null) {
            RecivedCleint.Display();
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
            RecivedCleint.Display();
        }else{
            System.out.println("Sorry Not Found ");
        }
        GestionDesClient();
    }


    public static void getAllUsers() {

        for (Client user: clientDAO.getAll()) {
         user.Display();

        }

    }



}
