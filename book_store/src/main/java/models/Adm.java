package models;

public class Adm extends User{

    public Adm(String username, String cpf, String senha, Double saldo) {
        super(username, "0", senha, 0.0);
    }
    
}
