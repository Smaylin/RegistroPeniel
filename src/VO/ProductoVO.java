package VO;

public class ProductoVO {

/*Todo los atributos*/
    int codigo;
    String nombre;
    String telefono;
    String telefonoCon;
    String curso;
    String horario;


  
public ProductoVO(){}

/*Todo los codigos get*/
    public int getCodigo(){
        return codigo;
    }
    public String getNombre(){
        return nombre;
    }
    public String getTelefono(){
        return telefono;
    }
    public String getTelefonoCon(){
        return telefonoCon;
    }
    public String getCurso() {
        return curso;
    }
    public String getHorario() {
        return horario;
    }


/*Todo los codigos set*/
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setTelefono(String precio){
        this.telefono = precio;
    }
    public void setTelefonoCon(String marca){
        this.telefonoCon = marca;
    }
    
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }

}
