package prog2.model;

public interface InClient {

    public String getNom();

    public String getDni();

    public void setNom(String nom);

    public void setDni(String dni);


}
public int calculAllotjamentsOperatius() {
    int op = 0;
    for (int i = 0; i<getNumAllotjaments(); i++)
        if (llistaAllotjaments.get(i).correcteFuncionament()) op++;
    return op;
}