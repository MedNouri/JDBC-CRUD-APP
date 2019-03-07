import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class ClientDAOImpl implements InterfaceDAO<Client> {

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    @Override
    public List<Client> getAll() {

      List<Client> users  = new ArrayList<>();
        try {

            con = Connexion.getInstance().getConnection();
            stmt = con.createStatement();
            String query=
                    "SELECT * FROM client  ";


            rs = stmt.executeQuery(query);


            while (rs.next()) {
                String name = rs.getString("nom");
                String adresse = rs.getString("adresse");
                String telephone = rs.getString("telephone");
                Client Foundelement = new Client(name,adresse,telephone);
                users.add(Foundelement);
            }



        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return users;

    }
    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
    @Override
    public int insert(Client c) {

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {

            con = Connexion.getInstance().getConnection();
            String query = "insert into client (nom, adresse, telephone) values (?,?,?)";
            pstmt = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, c.getNom());
            pstmt.setString(2, c.getAdresse());
            pstmt.setString(3, c.getTelephone());
            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            if(rs != null && rs.next()){
                System.out.println("Generated Emp Id: "+rs.getInt(1));
            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (Exception ex) {
            }


        }
            return 0;
    }

    @Override
    public int delete(int id) {

        try {

            con = Connexion.getInstance().getConnection();
            stmt = con.createStatement();

            String sql = "DELETE FROM client " +
                    "WHERE id = "+ id;
            stmt.executeUpdate(sql);

            while (rs.next()) {
        System.out.print("Client deleted");
                return 1;
            }



        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return 0;



    }

    @Override
    public int update(Client c) {


        try {

            con = Connexion.getInstance().getConnection();
            stmt = con.createStatement();

            String sql =    "UPDATE client SET nom = 'Lille' ";
            stmt.executeUpdate(sql);
            String query=
                    "SELECT * FROM client ";


            rs = stmt.executeQuery(query);

            while (rs.next()) {
                String name = rs.getString("nom");
                String adresse = rs.getString("adresse");
                String telephone = rs.getString("telephone");
                Client Foundelement = new Client(name,adresse,telephone);

                return 0;
            }



        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return 0;
    }

    @Override
    public Client findById(int numero) {

        try {

            con = Connexion.getInstance().getConnection();
            stmt = con.createStatement();
        String query=
                "SELECT * FROM client WHERE id = "+ numero;


              rs = stmt.executeQuery(query);


            while (rs.next()) {
                String name = rs.getString("nom");
                String adresse = rs.getString("adresse");
                String telephone = rs.getString("telephone");
                Client Foundelement = new Client(name,adresse,telephone);

                return Foundelement;
            }



        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Client findByName(String name) {

        try {

            con = Connexion.getInstance().getConnection();
            stmt = con.createStatement();

            String query=
                    "SELECT * FROM client WHERE nom = "+ name;

            rs = stmt.executeQuery(query);


            while (rs.next()) {

                 String nom = rs.getString("nom");
                 String adresse = rs.getString("adresse");
                 String telephone = rs.getString("telephone");
                Client Foundelement = new Client(nom,adresse,telephone);

                return Foundelement;
            }
            System.out.println();


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
}
