package gymcoach.musculos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import gymcoach.main.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Musculo extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.musculo);
		
		TextView musculoTitle = (TextView)findViewById(R.id.txtTitleMusculo);
		ImageView musculoImg = (ImageView)findViewById(R.id.imgMusculo);
		TextView musculoDescripcion = (TextView)findViewById(R.id.txtDescripcionMusculo);
		TextView musculoNota = (TextView)findViewById(R.id.txtNotaMusculo);
		
		String musculoStr = getIntent().getExtras().get("musculoSeleccionado").toString();
		int musculoImgId = getResources().getIdentifier(musculoStr, "drawable", getBaseContext().getPackageName());
		int musculoDescripcionId = getResources().getIdentifier(musculoStr, "raw", getBaseContext().getPackageName());
		
		musculoTitle.setText(musculoStr.toUpperCase());
		musculoImg.setImageResource(musculoImgId);
		
		try{
			BufferedReader entrada = new BufferedReader(new InputStreamReader(getResources().openRawResource(musculoDescripcionId), "ISO-8859-1"));
			
			String descripcion = entrada.readLine();
			String nota = entrada.readLine();
			
			musculoDescripcion.setText(descripcion);
			musculoNota.setText(nota);			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		((ImageButton)findViewById(R.id.ibtnIrAMenu)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
}
