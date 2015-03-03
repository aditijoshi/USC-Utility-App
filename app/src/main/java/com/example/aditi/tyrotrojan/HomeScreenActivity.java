package com.example.aditi.tyrotrojan;

import com.example.tyrotrojan1.R;
import com.example.tyrotrojan1.R.color;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;




public class HomeScreenActivity extends ActionBarActivity {

	RelativeLayout r1;
	TextView expandableTB1;
	TextView dealsView;
	TextView directionView;
	TextView callsView;
	Drawable x;
	//Button callButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        
        expandableTB1 = (TextView)findViewById(R.id.PlaceInfo);
        
        r1 = (RelativeLayout)findViewById(R.id.rlImage);
       dealsView = (TextView)findViewById(R.id.dealsButton);
       directionView = (TextView)findViewById(R.id.directionsButton);
       callsView = (TextView)findViewById(R.id.callButton);
  	   ((TextView) dealsView).setTextColor(color.neongreen); 
  	dealsView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.deals, 0, 0, 0);
        x =getResources().getDrawable(R.drawable.back) ;
        dealsView.setBackground(x);
        callsView.setBackground(x);
        directionView.setBackground(x);
        
        PhoneCallListener phoneCallListener = new PhoneCallListener();
        TelephonyManager telManager = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
        telManager.listen(phoneCallListener, PhoneStateListener.LISTEN_CALL_STATE);

        
        
    

			
		
       
        
    }
    
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
		  v.setBackgroundColor(color.neongreen);
	    	 v.setTextColor(Color.WHITE);
	    	// v.setBackground(x);
	  }
	  
	  else
	  {
		  v.setBackgroundColor(Color.WHITE);
	    	 v.setTextColor(color.neongreen);  
	    	// v.setBackground(x);
	  }
	  
  }
    
    
    
    
    public void expandInfo(View v){
    	
    	if(expandableTB1.getText().toString().equals("Grocery store chain with locations throughout Southern California.Conveniently located close to the university and offers the best deals for affordable groceries. Visit website at www.ralphs.com for Store information, savings and coupons and a shopping list service")){
    		   // slide_up(this, expandableTB1);
    		    expandableTB1.setText("Grocery store chain with locations throughout Southern California.Conveniently located (See More...)");
    		   // expandableTB.setVisibility(View.GONE);
    		  }
    		  else{
    			  //r1.setGravity(65);
    			 // expandableTB.setVisibility(View.VISIBLE);
    			  expandableTB1.setText("Grocery store chain with locations throughout Southern California.Conveniently located close to the university and offers the best deals for affordable groceries. Visit website at www.ralphs.com for Store information, savings and coupons and a shopping list service");

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
   	   ((TextView) dealsView).setTextColor(color.neongreen); 
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
