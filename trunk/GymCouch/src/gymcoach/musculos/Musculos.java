package gymcoach.musculos;

import gymcoach.main.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class Musculos extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.musculos);
		
		((ImageButton)findViewById(R.id.ibtnBiceps)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intencion = new Intent(getBaseContext(), Musculo.class);
				intencion.putExtra("musculoSeleccionado", "biceps");
				startActivity(intencion);
				finish();
			}
		});
		
		((ImageButton)findViewById(R.id.ibtnTriceps)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intencion = new Intent(getBaseContext(), Musculo.class);
				intencion.putExtra("musculoSeleccionado", "triceps");
				startActivity(intencion);
				finish();
			}
		});
		
		((ImageButton)findViewById(R.id.ibtnPectorales)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intencion = new Intent(getBaseContext(), Musculo.class);
				intencion.putExtra("musculoSeleccionado", "pectorales");
				startActivity(intencion);
				finish();
			}
		});
		
		((ImageButton)findViewById(R.id.ibtnTrapecio)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intencion = new Intent(getBaseContext(), Musculo.class);
				intencion.putExtra("musculoSeleccionado", "trapecio");
				startActivity(intencion);
				finish();
			}
		});
		
		((ImageButton)findViewById(R.id.ibtnDeltoide)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intencion = new Intent(getBaseContext(), Musculo.class);
				intencion.putExtra("musculoSeleccionado", "deltoide");
				startActivity(intencion);
				finish();
			}
		});
		
		((ImageButton)findViewById(R.id.ibtnAbdomen)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intencion = new Intent(getBaseContext(), Musculo.class);
				intencion.putExtra("musculoSeleccionado", "abdomen");
				startActivity(intencion);
				finish();
			}
		});
		
		((ImageButton)findViewById(R.id.ibtnCuadriceps)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intencion = new Intent(getBaseContext(), Musculo.class);
				intencion.putExtra("musculoSeleccionado", "cuadriceps");
				startActivity(intencion);
				finish();
			}
		});
		
		((ImageButton)findViewById(R.id.ibtnPantorrilla)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intencion = new Intent(getBaseContext(), Musculo.class);
				intencion.putExtra("musculoSeleccionado", "pantorrilla");
				startActivity(intencion);
				finish();
			}
		});
	}
}
