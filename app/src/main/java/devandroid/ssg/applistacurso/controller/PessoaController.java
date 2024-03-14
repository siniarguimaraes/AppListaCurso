package devandroid.ssg.applistacurso.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.ssg.applistacurso.database.ListaVipDB;
import devandroid.ssg.applistacurso.model.Pessoa;
import devandroid.ssg.applistacurso.view.MainActivity;

public class PessoaController extends ListaVipDB {

    public static final String NOME_PREFERENCES = "pref_listavip";
    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public PessoaController(MainActivity mainActivity) {
        super(mainActivity);

        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES,0);
        listaVip = preferences.edit();

    }

    @NonNull
    @Override
    public String toString() {

        Log.d("MVC_Controller","Controller Iniciada...");

        return super.toString();
    }

    public void salvar(Pessoa pessoa) {

        ContentValues dados = new ContentValues();


        Log.i("MVC_Controller","Salvo :   "+pessoa.toString());



        listaVip.putString("primeiroNome",pessoa.getPrimeiroNome());
        listaVip.putString("sobreNome",pessoa.getSobreNome());
        listaVip.putString("nomeDoCurso",pessoa.getCursoDesejado());
        listaVip.putString("telefoneContato",pessoa.getTelefoneContato());
        listaVip.apply();

        dados.put("primeiroNome",pessoa.getPrimeiroNome());
        dados.put("sobreNome",pessoa.getSobreNome());
        dados.put("cursoDesejado",pessoa.getCursoDesejado());
        dados.put("telefoneContato",pessoa.getTelefoneContato());

        salvarObjeto("Pessoa",dados);

    }

    public Pessoa buscarSharedPreferences(Pessoa pessoa){

        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", ""));
        pessoa.setSobreNome(preferences.getString("sobreNome", ""));
        pessoa.setCursoDesejado(preferences.getString("nomeDoCurso", ""));
        pessoa.setTelefoneContato(preferences.getString("telefoneContato", ""));

        return pessoa;

    }

    public void alterar(Pessoa pessoa){

        ContentValues dados = new ContentValues();

        dados.put("id",pessoa.getId());
        dados.put("primeiroNome",pessoa.getPrimeiroNome());
        dados.put("sobreNome",pessoa.getSobreNome());
        dados.put("cursoDesejado",pessoa.getCursoDesejado());
        dados.put("telefoneContato",pessoa.getTelefoneContato());

        alterarObjeto("Pessoa",dados);

    }

    public void deletar(int id){

        deletarObjeto("Pessoa", id);

    }


    public void limpar(){
        listaVip.clear();
        listaVip.apply();
    }

}
