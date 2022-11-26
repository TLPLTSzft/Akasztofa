package com.example.akasztofa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.annotation.Repeatable;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
	
	private AppCompatButton appCompatButtonAbcVissza, appCompatButtonAbcElore, appCompatButtonTippel;
	private TextView textViewTipp, textViewKitalalandoSzo;
	private ImageView imageViewAkasztofa;
	private ArrayList<String> szavak;
	private Random random;
	private int veletlenSzo;
	private StringBuilder stringBuilder;
	private String kitalalandoSzo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		ujJatek();
		
	}
	
	private void ujJatek() {
		textViewTipp.setText("A");
		veletlenSzo = random.nextInt(szavak.size());
		for (int i = 0; i < szavak.get(veletlenSzo).length(); i++) {
			stringBuilder.append("_ ");
		}
		kitalalandoSzo = stringBuilder.toString().trim();
		textViewKitalalandoSzo.setText(kitalalandoSzo);
	
	}
	
	private void init() {
		appCompatButtonAbcVissza = findViewById(R.id.appCompatButtonAbcVissza);
		textViewTipp = findViewById(R.id.textViewTipp);
		appCompatButtonAbcElore = findViewById(R.id.appCompatButtonAbcElore);
		appCompatButtonTippel = findViewById(R.id.appCompatButtonTippel);
		imageViewAkasztofa = findViewById(R.id.imageViewAkasztofa);
		textViewKitalalandoSzo = findViewById(R.id.textViewKitalalandoSzo);
		szavak = new ArrayList<>();
		szavak.add("akasztofa");
		szavak.add("program");
		szavak.add("kitalalta");
		szavak.add("tippelhet");
		szavak.add("elfogyott");
		szavak.add("alkalmazas");
		szavak.add("indulas");
		szavak.add("felugro");
		szavak.add("textview");
		szavak.add("korkoros");
		random = new Random();
		stringBuilder = new StringBuilder();
	}
}
