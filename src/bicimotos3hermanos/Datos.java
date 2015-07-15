/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bicimotos3hermanos;

/**
 *
 * @author Mario
 */
public class Datos {
  private String nombre;
  private String apellidos;
  private String tel;
  private String correo;

  private String ciudad;
    public Datos(String nombre, String apellidos, String tel, String correo, String ciudad, String rfc) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.tel = tel;
        this.correo = correo;
        this.ciudad = ciudad;
        this.rfc = rfc;
    }

private String rfc;
    public Datos() {
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the rfc
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * @param rfc the rfc to set
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    

   public class veiculo {
   private String serie;
   private String motor;
   private String placas;
   private String kilometrage;
   private String Modelo;

        public veiculo() {
        }

        public veiculo(String serie, String motor, String placas, String kilometrage, String Modelo) {
            this.serie = serie;
            this.motor = motor;
            this.placas = placas;
            this.kilometrage = kilometrage;
            this.Modelo = Modelo;
        }

   
        /**
         * @return the serie
         */
        public String getSerie() {
            return serie;
        }

        /**
         * @param serie the serie to set
         */
        public void setSerie(String serie) {
            this.serie = serie;
        }

        /**
         * @return the motor
         */
        public String getMotor() {
            return motor;
        }

        /**
         * @param motor the motor to set
         */
        public void setMotor(String motor) {
            this.motor = motor;
        }

        /**
         * @return the placas
         */
        public String getPlacas() {
            return placas;
        }

        /**
         * @param placas the placas to set
         */
        public void setPlacas(String placas) {
            this.placas = placas;
        }

        /**
         * @return the kilometrage
         */
        public String getKilometrage() {
            return kilometrage;
        }

        /**
         * @param kilometrage the kilometrage to set
         */
        public void setKilometrage(String kilometrage) {
            this.kilometrage = kilometrage;
        }

        /**
         * @return the Modelo
         */
        public String getModelo() {
            return Modelo;
        }

        /**
         * @param Modelo the Modelo to set
         */
        public void setModelo(String Modelo) {
            this.Modelo = Modelo;
        }
   }
    
   
 public class servicio {
 private String servicio;
 private String entrada;
 private String salida;
 private double precio;
 private String observaciones;

        public servicio() {
        }

        public servicio(String servicio, String entrada, String salida, double precio, String observaciones) {
            this.servicio = servicio;
            this.entrada = entrada;
            this.salida = salida;
            this.precio = precio;
            this.observaciones = observaciones;
        }

        /**
         * @return the servicio
         */
        public String getServicio() {
            return servicio;
        }

        /**
         * @param servicio the servicio to set
         */
        public void setServicio(String servicio) {
            this.servicio = servicio;
        }

        /**
         * @return the entrada
         */
        public String getEntrada() {
            return entrada;
        }

        /**
         * @param entrada the entrada to set
         */
        public void setEntrada(String entrada) {
            this.entrada = entrada;
        }

        /**
         * @return the salida
         */
        public String getSalida() {
            return salida;
        }

        /**
         * @param salida the salida to set
         */
        public void setSalida(String salida) {
            this.salida = salida;
        }

        /**
         * @return the precio
         */
        public double getPrecio() {
            return precio;
        }

        /**
         * @param precio the precio to set
         */
        public void setPrecio(double precio) {
            this.precio = precio;
        }

        /**
         * @return the observaciones
         */
        public String getObservaciones() {
            return observaciones;
        }

        /**
         * @param observaciones the observaciones to set
         */
        public void setObservaciones(String observaciones) {
            this.observaciones = observaciones;
        }
 
        
 } 
}
