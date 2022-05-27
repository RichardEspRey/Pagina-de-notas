/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoparaya;

/**
 *
 * @author gil_r
 */
public class UsuarioAtributos {
private int id;
private String nombre;
private String apellidos;
private String fecha_Nacimiento;
private String correo;
private String nombreUsuario;
private String contra;
private String fecha_Creacion;
private Boolean eliminado;

public UsuarioAtributos(){
    }

public UsuarioAtributos(int id, String Nombre, String Apellidos, String Fecha_Nacimiento, String Correo, String NombreUsuario, String Contra, String Fecha_Creacion, Boolean Eliminado){
    this.id = id;
    this.nombre = Nombre;
    this.apellidos = Apellidos;
    this.fecha_Nacimiento = Fecha_Nacimiento;
    this.correo = Correo;
    this.nombreUsuario = NombreUsuario;
    this.contra = Contra;
    this.fecha_Creacion = Fecha_Creacion;
    this.eliminado = Eliminado;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    /**
     * @return the Apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param Apellidos the Apellidos to set
     */
    public void setApellidos(String Apellidos) {
        this.apellidos = Apellidos;
    }

    /**
     * @return the Fecha_Nacimiento
     */
    public String getFecha_Nacimiento() {
        return fecha_Nacimiento;
    }

    /**
     * @param Fecha_Nacimiento the Fecha_Nacimiento to set
     */
    public void setFecha_Nacimiento(String Fecha_Nacimiento) {
        this.fecha_Nacimiento = Fecha_Nacimiento;
    }

    /**
     * @return the Correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param Correo the Correo to set
     */
    public void setCorreo(String Correo) {
        this.correo = Correo;
    }

    /**
     * @return the NombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param NombreUsuario the NombreUsuario to set
     */
    public void setNombreUsuario(String NombreUsuario) {
        this.nombreUsuario = NombreUsuario;
    }

    /**
     * @return the Contra
     */
    public String getContra() {
        return contra;
    }

    /**
     * @param Contra the Contra to set
     */
    public void setContra(String Contra) {
        this.contra = Contra;
    }

    /**
     * @return the Fecha_Creacion
     */
    public String getFecha_Creacion() {
        return fecha_Creacion;
    }

    /**
     * @param Fecha_Creacion the Fecha_Creacion to set
     */
    public void setFecha_Creacion(String Fecha_Creacion) {
        this.fecha_Creacion = Fecha_Creacion;
    }

    /**
     * @return the Eliminado
     */
    public Boolean getEliminado() {
        return eliminado;
    }

    /**
     * @param Eliminado the Eliminado to set
     */
    public void setEliminado(Boolean Eliminado) {
        this.eliminado = Eliminado;
    }
}
