package gymcoach.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class Splash extends Activity {
   
   
    private Intent i;
    private Handler UICallback = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            startActivity(i);
           
        }
    };
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
       
        i = new Intent(this, GymCoach.class);
       
        Thread splashThread = new Thread() {
             @Override
             public void run() {
                try {
                   int esperado = 0;
                   while (esperado < 3000) {
                      sleep(100);
                      esperado += 100;
                   }
                } catch (InterruptedException e) {
                   // do nothing
                } finally {
                   finish();
                   UICallback.sendEmptyMessage(0); //hipo, aqui puedes poner startActivity(intencion) porque fue hasta despues que la declare como global
                }
             }
          };
          splashThread.start();
       }
   

}
