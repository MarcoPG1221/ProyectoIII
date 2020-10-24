
package model;

public class Individual extends Cliente{
    
    private String DPI;

    public Individual(){
        //constructor Vacio
    }
    
    public Individual(String nombres, String apellidos, String direccion, String DPI) {
        super(nombres, apellidos, direccion);
        this.DPI = DPI;
    }

    //Segundo constructor para poder mostrar la informacion almacenada en la base de datos
    public Individual(int id, String nombres, String apellidos, String direccion, String DPI) {
        super(id, nombres, apellidos, direccion);
        this.DPI = DPI;
    }

    //Creamos los metodos getter y setters
    public String getDPI() {
        return DPI;
    }

    public void setDPI(String DPI) {
        this.DPI = DPI;
    }
    
    //Creamos el metodo toString y mandamos llamar los valores de la clase Cliente
    @Override
    public String toString() {
        return super.toString() + "\tDPI: " + DPI;
    }
        
}
