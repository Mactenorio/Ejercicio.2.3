package com.example.ejercicio23.transacciones;

public class Transacciones {
    public static final String tablaImagenes = "imagenes";
    public static final String id = "id";
    public static final String blobImagen = "blobImagen";
    public static final String descripcion = "descripcion";

    public static final String CreateTableImagenes =
            "CREATE TABLE imagenes(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "blobImagen BLOB, descripcion TEXT)";

    public static final String DropeTableImagenes ="DROPE TABLE IF EXISTS imagenes";
    public static final String NameDataBase = "DBTarea3";
}
