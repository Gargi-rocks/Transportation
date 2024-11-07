package learner;
import java.io.Serializable;
public class Client implements Serializable{
    private static final long serialVersionUID = 2018040801L;
    private String id;
    private String name;
    private String address;
    private String tel;
    private String email;
    private String note;
    private String note1;
    private String note2;
    public Client() {
        super();
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public String getNote1() {
        return note1;
    }
    public void setNote1(String note1) {
        this.note1 = note1;
    }
    public String getNote2() {
        return note2;
    }
    public void setNote2(String note2) {
        this.note2 = note2;
    }
}

