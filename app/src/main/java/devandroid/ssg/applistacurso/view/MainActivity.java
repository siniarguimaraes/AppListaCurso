package devandroid.ssg.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import devandroid.ssg.applistacurso.R;

import devandroid.ssg.applistacurso.controller.CursoController;
import devandroid.ssg.applistacurso.controller.PessoaController;
import devandroid.ssg.applistacurso.model.Curso;
import devandroid.ssg.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {
    PessoaController controller;
    CursoController cursoController;

    Pessoa pessoa;
    List<Curso> listaDeCursos;
    EditText editPrimeioNome;
    EditText editSobreNome;
    EditText editTextNomeCurso;
    EditText editTelefone;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new PessoaController(MainActivity.this);

        cursoController = new CursoController();
        listaDeCursos = cursoController.getListaDeCursos();

        pessoa = new Pessoa();
        controller.buscar(pessoa);

        editPrimeioNome = findViewById(R.id.editPrimeiroNome);
        editSobreNome = findViewById(R.id.editSobreNome);
        editTextNomeCurso = findViewById(R.id.editTextNomeCurso);
        editTelefone = findViewById(R.id.editTelefone);

        editPrimeioNome.setText(pessoa.getPrimeiroNome());
        editSobreNome.setText(pessoa.getSobreNome());
        editTextNomeCurso.setText(pessoa.getCursoDesejado());
        editTelefone.setText(pessoa.getTelefoneContato());

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editPrimeioNome.setText("");
                editSobreNome.setText("");
                editTextNomeCurso.setText("");
                editTelefone.setText("");

                controller.limpar();

            }
        });
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Volte Sempre!", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pessoa.setPrimeiroNome(editPrimeioNome.getText().toString());
                pessoa.setSobreNome(editSobreNome.getText().toString());
                pessoa.setCursoDesejado(editTextNomeCurso.getText().toString());
                pessoa.setTelefoneContato(editTelefone.getText().toString());

                Toast.makeText(MainActivity.this, "Salvo :" + pessoa.toString(), Toast.LENGTH_LONG).show();

                controller.salvar(pessoa);
            }
        });

        Log.i("POOAndroid", "Objeto pessoa: " + pessoa.toString());

    }
}