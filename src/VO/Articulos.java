
package VO;


public class Articulos {
      int id_articulo;
    String descripcion;
    String precio_venta;
    String precio_costo;
    
    
    
    public Articulos(){}

    public void setId_articulo(int id_articulo) {
        this.id_articulo = id_articulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio_venta(String precio_venta) {
        this.precio_venta = precio_venta;
    }

    public void setPrecio_costo(String precio_costo) {
        this.precio_costo = precio_costo;
    }

    public int getId_articulo() {
        return id_articulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getPrecio_venta() {
        return precio_venta;
    }

    public String getPrecio_costo() {
        return precio_costo;
    }
    
    
    
    
    
}
