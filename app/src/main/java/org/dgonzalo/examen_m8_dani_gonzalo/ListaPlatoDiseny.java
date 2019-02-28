package org.dgonzalo.examen_m8_dani_gonzalo;

public class ListaPlatoDiseny {
    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " +
            InsertPlato.TABLE_NAME + " (" +
            "_id integer primary key autoincrement," +
            InsertPlato.COLUMNA_1 + " TEXT," +
            InsertPlato.COLUMNA_2 + " TEXT," +
            InsertPlato.COLUMNA_3 + " TEXT)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + InsertPlato.TABLE_NAME;

    private ListaPlatoDiseny(){}

    public static class InsertPlato {

        public static final String TABLE_NAME = "carta";
        public static final String COLUMNA_1 = "nombre";
        public static final String COLUMNA_2 = "ingredientes";
        public static final String COLUMNA_3 = "precio";
    }

}