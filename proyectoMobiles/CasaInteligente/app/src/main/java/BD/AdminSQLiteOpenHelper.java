package BD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version) {

        super(context, nombre, factory, version);

    }

    @Override

    public void onCreate(SQLiteDatabase db) {
        //aquí creamos la tabla de usuario (dni, nombre, ciudad, numero)
        db.execSQL("create table usuario(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre text, correo text, contrasena text)");

    }

    @Override

    public void onUpgrade(SQLiteDatabase db, int version1, int version2) {

        db.execSQL("drop table if exists usuario");

        db.execSQL("create table usuario(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre text, correo text, contrasena text)");

    }

}