import java.sql.Connection;
import java.util.List;
import java.sql.*;


public class ClientDAOImpl implements InterfaceDAO<Client> {

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    @Override
    public List<Client> getAll() {
        return null;
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





        return 0;
    }

    @Override
    public int update(Client c) {
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
            System.out.println();


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
                    String.format("SELECT * FROM client WHERE nom like %s", name);


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
