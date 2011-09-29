package gymcouch.musculos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import gymcouch.main.R;
import android.app.Activity;
import android.os.Bundle;
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
		TextView musculoConsejo = (TextView)findViewById(R.id.txtConsejo);
		
		String musculoStr = getIntent().getExtras().get("musculoSeleccionado").toString();
		int musculoImgId = getResources().getIdentifier(musculoStr, "drawable", getBaseContext().getPackageName());
		int musculoDescripcionId = getResources().getIdentifier(musculoStr, "raw", getBaseContext().getPackageName());
		
		musculoTitle.setText(musculoStr.toUpperCase());
		musculoImg.setImageResource(musculoImgId);
		
		try{
			BufferedReader entrada = new BufferedReader(new InputStreamReader(getResources().openRawResource(musculoDescripcionId)));
			
			String descripcion = entrada.readLine();
			String consejo = entrada.readLine();
			
			musculoDescripcion.setText(descripcion);
			musculoConsejo.setText(consejo);			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
