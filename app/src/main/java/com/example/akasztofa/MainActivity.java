package com.example.akasztofa;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
	
	private AppCompatButton appCompatButtonAbcVissza, appCompatButtonAbcElore, appCompatButtonTippel;
	private TextView textViewTipp, textViewKitalalandoSzo;
	private ImageView imageViewAkasztofa;
	private ArrayList<String> szavak;
	private Random random;
	private int veletlenSzoIndex;
	private String veletlenSzo;
	private String alahuzasok;
	private String kitalalandoSzo;
	Character[] abcBetui = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	//	Character[] abcBetui = {'A', 'Á', 'B', 'C', 'D', 'E', 'É', 'F', 'G', 'H', 'I', 'Í', 'J', 'K', 'L', 'M', 'N', 'O', 'Ó', 'Ö', 'Ő', 'P', 'Q', 'R', 'S', 'T', 'U', 'Ú', 'Ü', 'Ű', 'V', 'W', 'X', 'Y', 'Z'};
	private int abcIndex;
	private char abcBetu;
	private int tipp;
	private int rosszTipp;
	private ArrayList<Character> tippek;
	private boolean talalat;
	private AlertDialog.Builder builderJatekVege;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		ujJatek();
		
		appCompatButtonAbcVissza.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				abcIndex = abcIndex == 1 ? 26 : abcIndex - 1;
				betuValasztas();
			}
		});
		
		appCompatButtonAbcElore.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				abcIndex = abcIndex == 26 ? 1 : abcIndex + 1;
				betuValasztas();
			}
		});
		
		appCompatButtonTippel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				tippeles();
			}
		});
		
	}
	
	private void betuValasztas() {
		abcBetu = abcBetui[abcIndex - 1];
		if (tippek.contains(abcBetu)) {
			textViewTipp.setTextColor(Color.BLACK);
		} else {
			textViewTipp.setTextColor(Color.RED);
		}
		textViewTipp.setText(String.format("%s", abcBetu));
	}
	
	private void tippeles() {
		if (!tippek.contains(abcBetu)) {
			
			tippek.add(abcBetu);
			betuValasztas();
			if (tipp < abcBetui.length) {
				talalat = false;
				for (int i = 0; i < veletlenSzo.length(); i++) {
					if (i == 0 && veletlenSzo.charAt(i) == abcBetu) {
						talalat = true;
						kitalalandoSzo = abcBetu + " " + kitalalandoSzo.substring((i + 1) * 2);
					} else if (i == veletlenSzo.length() && veletlenSzo.charAt(i) == abcBetu) {
						talalat = true;
						kitalalandoSzo = kitalalandoSzo.substring(0, ((i - 1) * 2)) + abcBetu;
					} else if (veletlenSzo.charAt(i) == abcBetu) {
						talalat = true;
						kitalalandoSzo = kitalalandoSzo.substring(0, (i * 2)) + abcBetu + kitalalandoSzo.substring((i * 2) + 1);
					}
				}
				if (!talalat) {
					rosszTipp++;
					switch (rosszTipp) {
						case 1: {
							imageViewAkasztofa.setImageResource(R.drawable.akasztofa01);
							break;
						}
						case 2: {
							imageViewAkasztofa.setImageResource(R.drawable.akasztofa02);
							break;
						}
						case 3: {
							imageViewAkasztofa.setImageResource(R.drawable.akasztofa03);
							break;
						}
						case 4: {
							imageViewAkasztofa.setImageResource(R.drawable.akasztofa04);
							break;
						}
						case 5: {
							imageViewAkasztofa.setImageResource(R.drawable.akasztofa05);
							break;
						}
						case 6: {
							imageViewAkasztofa.setImageResource(R.drawable.akasztofa06);
							break;
						}
						case 7: {
							imageViewAkasztofa.setImageResource(R.drawable.akasztofa07);
							break;
						}
						case 8: {
							imageViewAkasztofa.setImageResource(R.drawable.akasztofa08);
							break;
						}
						case 9: {
							imageViewAkasztofa.setImageResource(R.drawable.akasztofa09);
							break;
						}
						case 10: {
							imageViewAkasztofa.setImageResource(R.drawable.akasztofa10);
							break;
						}
						case 11: {
							imageViewAkasztofa.setImageResource(R.drawable.akasztofa11);
							break;
						}
						case 12: {
							imageViewAkasztofa.setImageResource(R.drawable.akasztofa12);
							break;
						}
						case 13: {
							imageViewAkasztofa.setImageResource(R.drawable.akasztofa13);
							break;
						}
					}
				}
				textViewKitalalandoSzo.setText(String.format("%s", kitalalandoSzo));
				if (kitalalandoSzo.indexOf('_') == -1) {
					builderJatekVege.setTitle("Helyes megfejtés!").create().show();
				}
				tipp++;
				if (rosszTipp == 13) {
					builderJatekVege.setTitle("Nem sikerült kitalálni!").create().show();
				}
			}
		}
	}
	
	private void ujJatek() {
		abcIndex = 1;
		abcBetu = abcBetui[abcIndex - 1];
		textViewTipp.setTextColor(Color.RED);
		textViewTipp.setText(String.format("%s", abcBetu));
		imageViewAkasztofa.setImageResource(R.drawable.akasztofa00);
		veletlenSzoIndex = random.nextInt(szavak.size());
		veletlenSzo = szavak.get(veletlenSzoIndex);
		kitalalandoSzo = alahuzasok.substring(0, veletlenSzo.length() * 2 - 1);
		textViewKitalalandoSzo.setText(kitalalandoSzo);
		tipp = 0;
		rosszTipp = 0;
		talalat = false;
		tippek.clear();
	}
	
	private void init() {
		appCompatButtonAbcVissza = findViewById(R.id.appCompatButtonAbcVissza);
		textViewTipp = findViewById(R.id.textViewTipp);
		appCompatButtonAbcElore = findViewById(R.id.appCompatButtonAbcElore);
		appCompatButtonTippel = findViewById(R.id.appCompatButtonTippel);
		imageViewAkasztofa = findViewById(R.id.imageViewAkasztofa);
		textViewKitalalandoSzo = findViewById(R.id.textViewKitalalandoSzo);
		szavak = new ArrayList<>();
		szavak.add("AKASZTOFA");
		szavak.add("PROGRAM");
		szavak.add("KITALALTA");
		szavak.add("TIPPELHET");
		szavak.add("ELFOGYOTT");
		szavak.add("ALKALMAZAS");
		szavak.add("INDULAS");
		szavak.add("FELUGRO");
		szavak.add("KORKOROS");
		szavak.add("TEXTVIEW");
		szavak.add("DARAB");
		random = new Random();
		alahuzasok = "_ _ _ _ _ _ _ _ _ _ _ _";
		tippek = new ArrayList<>();
		builderJatekVege = new AlertDialog.Builder(MainActivity.this);
		builderJatekVege.setCancelable(false).setTitle("Helyes megfejtés / Nem sikerült kitalálni").setMessage("Szeretnél új játékot játszani?").setNegativeButton("Nem", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialogInterface, int i) {
				finish();
			}
		}).setPositiveButton("Igen", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialogInterface, int i) {
				ujJatek();
			}
		}).create();
	}
}
