import java.util.Date;

/**
 * Created by moham on 04/03/2019.
 */
public class Commande {
    //les attributs
    private int id ;
    private int idclient ;
    private String pttc ;
    private Date date ;


    public Commande(int id, int idclient, String pttc, Date date) {
        this.id = id;
        this.idclient = idclient;
        this.pttc = pttc;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public String getPttc() {
        return pttc;
    }

    public void setPttc(String pttc) {
        this.pttc = pttc;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
