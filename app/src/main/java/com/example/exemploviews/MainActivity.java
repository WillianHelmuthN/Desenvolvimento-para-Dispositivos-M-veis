package com.example.exemploviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtTelefone;
    private Switch swtWhats;
    private RadioGroup rdgPeriodo;
    private RadioButton rdbManha;
    private RadioButton rdbTarde;
    private RadioButton rdbNoite;
    private CheckBox chkInternet;
    private CheckBox chkTelefone;
    private CheckBox chkTv;
    private CheckBox chkStreaming;
    private Button btnLimpar;
    private Button btnConfirmar;
    private LinearLayout lblDados;
    private TextView txtNome;
    private TextView txtEmail;
    private TextView txtTelefone;
    private TextView txtWhats;
    private TextView txtPeriodo;
    private TextView txtPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        edtNome = findViewById(R.id.edtNome);
        edtEmail = findViewById(R.id.edtEmail);
        edtTelefone = findViewById(R.id.edtTelefone);
        swtWhats = findViewById(R.id.swtWhats);
        rdgPeriodo = findViewById(R.id.rdgPeriodo);
        rdbManha = findViewById(R.id.rdbManha);
        rdbTarde = findViewById(R.id.rdbTarde);
        rdbNoite = findViewById(R.id.rdbNoite);
        chkInternet = findViewById(R.id.chkInternet);
        chkTelefone = findViewById(R.id.chkTelefone);
        chkTv = findViewById(R.id.chkTv);
        chkStreaming = findViewById(R.id.chkStreaming);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnConfirmar = findViewById(R.id.btnConfirmar);
        lblDados = findViewById(R.id.lblDados);
        txtNome = findViewById(R.id.txtNome);
        txtEmail = findViewById(R.id.txtEmail);
        txtTelefone = findViewById(R.id.txtTelefone);
        txtWhats = findViewById(R.id.txtWhats);
        txtPeriodo = findViewById(R.id.txtPeriodo);
        txtPref = findViewById(R.id.txtPref);

            btnLimpar.setOnClickListener(this);
        btnConfirmar.setOnClickListener(this);
        
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnLimpar){
            //Toast.makeText(this, "Limpar", Toast.LENGTH_SHORT).show();
            edtNome.setText("");
            edtEmail.setText("");
            edtTelefone.setText("");
            swtWhats.setChecked(false);
            rdgPeriodo.clearCheck();
            chkInternet.setChecked(false);
            chkTelefone.setChecked(false);
            chkTv.setChecked(false);
            chkStreaming.setChecked(false);
            lblDados.setVisibility(View.INVISIBLE);
        }
        else if(v.getId() == R.id.btnConfirmar){
            Toast.makeText(this, "Confirmar", Toast.LENGTH_LONG).show();
            lblDados.setVisibility(View.VISIBLE);
            txtNome.setText("Nome: " + edtNome.getText().toString());
            txtEmail.setText("Email: " + edtEmail.getText().toString());
            txtTelefone.setText("Telefone: " + edtTelefone.getText().toString());
            if(swtWhats.isChecked())
                txtWhats.setText("WhatsApp: " + swtWhats.getTextOn());
            else
                txtWhats.setText("WhatsApp: " + swtWhats.getTextOff());

            int idrdbselecionado = rdgPeriodo.getCheckedRadioButtonId();
            if (idrdbselecionado > 0){
                RadioButton rdbselecionado = findViewById(idrdbselecionado);
                txtPeriodo.setText("Período: " + rdbselecionado.getText().toString());
            }

            String pref="";
            if(chkInternet.isChecked())
                pref = chkInternet.getText().toString();
            if(chkTelefone.isChecked()){
                pref += " ";
                pref += chkTelefone.getText().toString();
            }
            if(chkTv.isChecked()){
                pref += " ";
                pref += chkTv.getText().toString();
            }
            if(chkStreaming.isChecked()){
                pref += " ";
                pref += chkStreaming.getText().toString();
            }
            txtPref.setText("Preferências: " + pref);
        }
    }
}