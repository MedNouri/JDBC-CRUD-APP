import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by moham on 05/03/2019.
 */
public class CommandeDAOImpl implements InterfaceDAO<Commande> {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
    @Override
    public List<Commande> getAll() {
        List<Commande> commandes  = new ArrayList<>();
        try {

            con = Connexion.getInstance().getConnection();
            stmt = con.createStatement();
            String query=
                    "SELECT * FROM Commande ";


            rs = stmt.executeQuery(query);


            while (rs.next()) {
                String pttc = rs.getString("pttc");
                java.util.Date date = rs.getTimestamp("date");
                int idclient = rs.getInt("idclient");
                Commande result = new Commande(idclient,pttc,date);
                commandes.add(result);
            }



        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return commandes;
    }

    @Override
    public int insert(Commande c) {

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {

            con = Connexion.getInstance().getConnection();
            String query = "insert into Commande (pttc, date, idclient) values (?,?,?)";
            pstmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, c.getPttc());
            pstmt.setDate(2, convertUtilToSql(c.getDate()));
            pstmt.setInt(3, c.getIdclient());
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
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {

            con = Connexion.getInstance().getConnection();
            stmt = con.createStatement();

            String sql = "DELETE FROM commande WHERE id = "+ id;
            stmt.executeUpdate(sql);

            while (rs.next()) {
                System.out.print("commande deleted");
                return 1;
            }



        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return 0;

    }

    @Override
    public int update(Commande c) {
        return 0;
    }

    @Override
    public Commande findById(int numero) {
        try {

            con = Connexion.getInstance().getConnection();
            stmt = con.createStatement();
            String query=
                    "SELECT * FROM commande WHERE id = "+ numero;


            rs = stmt.executeQuery(query);

            while (rs.next()) {


                String pttc = rs.getString("pttc");
                java.util.Date date = rs.getTimestamp("date");
                int idclient = rs.getInt("idclient");
                Commande result = new Commande(idclient,pttc,date);

                return result;
            }



        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Commande findByName(String name) {
        return null;
    }
}
