package com.example.aditi.tyrotrojan;


import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static com.example.aditi.tyrotrojan.R.color.neongreen;

public class CafeActivity extends ActionBarActivity {

	RelativeLayout r1;
	TextView expandableTB1;
	TextView dealsView;
	TextView directionView;
	TextView callsView;
	TextView opentimes;
	Drawable x;
	//Button callButton;
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe);
        
        expandableTB1 = (TextView)findViewById(R.id.PlaceInfo);
        opentimes = (TextView)findViewById(R.id.HoursToday);
        r1 = (RelativeLayout)findViewById(R.id.rlImage);
       dealsView = (TextView)findViewById(R.id.dealsButton);
       directionView = (TextView)findViewById(R.id.directionsButton);
       callsView = (TextView)findViewById(R.id.callButton);
  	   ((TextView) dealsView).setTextColor(neongreen);
  	dealsView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.hamburger1, 0, 0, 0);
        x =getResources().getDrawable(R.drawable.back) ;
        dealsView.setBackground(x);
        callsView.setBackground(x);
        directionView.setBackground(x);
        opentimes.setText("Monday � Friday: 11:00AM � 11:00PM \n Saturday & Sunday: 11:00AM � 10:00PM");
        PhoneCallListener phoneCallListener = new PhoneCallListener();
        TelephonyManager telManager = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
        telManager.listen(phoneCallListener, PhoneStateListener.LISTEN_CALL_STATE);

        
        
    

			
		
       
        
    }
    
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void getDeals(View v)
    {
    	if(v.getBackground()==x)
    	{
    	 v.setBackgroundColor(Color.parseColor("#4DBD33"));
	    	 ((TextView) v).setTextColor(Color.WHITE);
	    	 
    	}
    	else
    	{
    		 v.setBackground(x);
    		 ((TextView) v).setTextColor(Color.parseColor("#504A4B"));
    	}
	    	 
	    	 Intent i=new Intent();
	         i.setClass(this,Deals_Activity.class);
	         startActivity(i);
	    
    	
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void getDirections(View v)
    {
    	
    	if(v.getBackground()==x)
    	{
    	 v.setBackgroundColor(Color.parseColor("#4DBD33"));
	    	 ((TextView) v).setTextColor(Color.WHITE);
    	}
    	else
    	{
    		 v.setBackground(x);
    		 ((TextView) v).setTextColor(Color.parseColor("#504A4B"));
    	}
    	
    }
    public void getCalls(View v)
    {
    	
    	if(v.getBackground()==x)
    	{
    	 v.setBackgroundColor(Color.parseColor("#4DBD33"));
	    	 ((TextView) v).setTextColor(Color.WHITE);
	    	 
    	}
    	else
    	{
    		 v.setBackground(x);
    		 ((TextView) v).setTextColor(Color.parseColor("#504A4B"));
    	}
    	
    	Intent callIntent = new Intent(Intent.ACTION_CALL);
		callIntent.setData(Uri.parse("tel:0377778888"));
		startActivity(callIntent);
		v.setBackground(x);
		 ((TextView) v).setTextColor(Color.parseColor("#504A4B"));
    	
    }
    
       
    
    
  public void changeEffect(TextView v,boolean clicked)
  {
	  if(clicked==true)
	  {
		  v.setBackgroundColor(neongreen);
	    	 v.setTextColor(Color.WHITE);
	    	// v.setBackground(x);
	  }
	  
	  else
	  {
		  v.setBackgroundColor(Color.WHITE);
	    	 v.setTextColor(neongreen);
	    	// v.setBackground(x);
	  }
	  
  }
    
    
    
    
    public void expandInfo(View v){
    	
    	String x = "The Science of fun and dining is artfully executed daily at L.A.'s newest gastropub.  Located on Figueroa Blvd. across from USC, The Lab is the perfect place to test your theories on food, beer, and the evolution of good times.";
    	if(expandableTB1.getText().toString().equals(x)){
    		   // slide_up(this, expandableTB1);
    		    expandableTB1.setText("The Science of fun and dining is artfully executed daily at L.A.'s newest gastropub.(See More)...");
    		   // expandableTB.setVisibility(View.GONE);
    		  }
    		  else{
    			  //r1.setGravity(65);
    			 // expandableTB.setVisibility(View.VISIBLE);
    			  expandableTB1.setText(x);

    		    slide_down(this, expandableTB1);
    		  }
    }
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_screen, menu);
        return true;
    }
    
    //CODE TO TOGGLE WITH ANIMATION
    public static void slide_down(Context ctx, View v){

    	  Animation a = AnimationUtils.loadAnimation(ctx, R.anim.slide_down);
    	  if(a != null){
    	     a.reset();
    	     if(v != null){
    	      v.clearAnimation();
    	      v.startAnimation(a);
    	     }
    	  }
    	}
    
    public static void slide_up(Context ctx, View v){

  	  Animation a = AnimationUtils.loadAnimation(ctx, R.anim.slide_up);
  	  if(a != null){
  	     a.reset();
  	     if(v != null){
  	      v.clearAnimation();
  	      v.startAnimation(a);
  	     }
  	  }
  	} 
    

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    
    public void onResume() {
        super.onResume();
        
        r1 = (RelativeLayout)findViewById(R.id.rlImage);
        dealsView = (TextView)findViewById(R.id.dealsButton);
        directionView = (TextView)findViewById(R.id.directionsButton);
        callsView = (TextView)findViewById(R.id.callButton);
        //dealsView.setBackgroundColor(Color.WHITE);
   	   ((TextView) dealsView).setTextColor(neongreen);
   	dealsView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.deals, 0, 0, 0);
         x =getResources().getDrawable(R.drawable.back) ;
         dealsView.setBackground(x);
         callsView.setBackground(x);
         directionView.setBackground(x);
    }
    
    
    
    
    
    class PhoneCallListener extends PhoneStateListener {

        String TAG = "LOGGING PHONE CALL";
        private boolean phoneCalling = false;
        @Override
        public void onCallStateChanged(int state, String incomingNumber) {

            if (TelephonyManager.CALL_STATE_RINGING == state) {
                Log.i(TAG, "RINGING, number: " + incomingNumber);
            }
            if (TelephonyManager.CALL_STATE_OFFHOOK == state) {

                Log.i(TAG, "OFFHOOK");

                phoneCalling = true;

            }


            if (TelephonyManager.CALL_STATE_IDLE == state) {

                Log.i(TAG, "IDLE");

                if (phoneCalling) {
                    Log.i(TAG, "restart app");
                    // restart app
                   // Intent i = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                   // i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                   // startActivity(i);
                    phoneCalling = false;
                }
            }
        }
    }
    
    
    
}
