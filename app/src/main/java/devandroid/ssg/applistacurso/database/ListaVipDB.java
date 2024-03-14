package devandroid.ssg.applistacurso.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import devandroid.ssg.applistacurso.model.Pessoa;

public class ListaVipDB extends SQLiteOpenHelper {

    //psfs
    private static final String DB_NAME = "Listavip.db";
    private static final int DB_VERSION = 1;
    Cursor cursor;
    SQLiteDatabase db;
    public ListaVipDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqltabelapessoa
                = "CREATE TABLE Pessoa (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "primeiroNome TEXT, " +
                "sobreNome TEXT, " +
                "cursoDesejado TEXT, " +
                "telefoneContato TEXT)";

        db.execSQL(sqltabelapessoa);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void salvarObjeto(String tabela, ContentValues dados){

        db.insert(tabela,null,dados);

    }

    public List<Pessoa> listarDados(){

        List<Pessoa> lista = new ArrayList<>();

        Pessoa registro;
        String querySQL = "SELECT * FROM Pessoa";
        cursor = db.rawQuery(querySQL,null);

        if(cursor.moveToFirst()){

            do{
                registro = new Pessoa();
                registro.setId(cursor.getInt(0));
                registro.setPrimeiroNome(cursor.getString(1));
                registro.setSobreNome(cursor.getString(2));
                registro.setCursoDesejado(cursor.getString(3));
                registro.setTelefoneContato(cursor.getString(4));

            } while (cursor.moveToNext());

        }else{

        }

        return lista;
    }

    public void alterarObjeto(String tabela, ContentValues dados) {

        int id = dados.getAsInteger("id");
        db.update(tabela, dados, "id=?", new String[]{Integer.toString(id)});
    }

    public void deletarObjeto(String tabela, int id) {

        db.delete(tabela,"id=?", new String[]{Integer.toString(id)});
    }


}
