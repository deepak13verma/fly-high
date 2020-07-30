package com.example.deepa.flyhigh;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import static com.example.deepa.flyhigh.GameView.screenRatioX;
import static com.example.deepa.flyhigh.GameView.screenRatioY;

public class Flight {

    int x,y,width,height,wingcounter=0;
    Bitmap flight1,flight2,shoot1,shoot2,shoot3,shoot4,shoot5,dead;
    public boolean isgoingup =false ;
    int toshoot=0,shootcounter=1;
    private GameView gameView;

    Flight(GameView gameView, int screenY, Resources res)
    {
        this.gameView = this.gameView;
        flight1 = BitmapFactory.decodeResource(res,R.drawable.fly1);
        flight2 = BitmapFactory.decodeResource(res,R.drawable.fly2);

        shoot1 = BitmapFactory.decodeResource(res,R.drawable.shoot1);
        shoot2 = BitmapFactory.decodeResource(res,R.drawable.shoot2);
        shoot3 = BitmapFactory.decodeResource(res,R.drawable.shoot3);
        shoot4 = BitmapFactory.decodeResource(res,R.drawable.shoot4);
        shoot5 = BitmapFactory.decodeResource(res,R.drawable.shoot5);

        dead = BitmapFactory.decodeResource(res,R.drawable.dead);

        width = flight1.getWidth();
        height = flight1.getHeight();

        width /=4;
        height /=4;

        width = (int)(width*screenRatioX);
        height = (int)(height*screenRatioY);

        flight1 = Bitmap.createScaledBitmap(flight1,width,height,false);
        flight2 = Bitmap.createScaledBitmap(flight2,width,height,false);

        shoot1 = Bitmap.createScaledBitmap(shoot1,width,height,false);
        shoot2 = Bitmap.createScaledBitmap(shoot2,width,height,false);
        shoot3 = Bitmap.createScaledBitmap(shoot3,width,height,false);
        shoot4 = Bitmap.createScaledBitmap(shoot4,width,height,false);
        shoot5 = Bitmap.createScaledBitmap(shoot5,width,height,false);

        dead = Bitmap.createScaledBitmap(dead,width,height,false);

        y=screenY/2;
        x = (int)( 64 * screenRatioX);

    }
    Bitmap getFlight(){

        if(toshoot != 0) {

            if(shootcounter == 1){
                shootcounter++;
                return shoot1;
            }
            if(shootcounter == 2){
                shootcounter++;
                return shoot2;
            }
            if(shootcounter == 3){
                shootcounter++;
                return shoot3;
            }
            if(shootcounter == 4) {
                shootcounter++;
                return shoot4;
            }

            shootcounter=1;
            toshoot--;

            gameView.newBullet();

            return  shoot5;
        }

        if(wingcounter == 0) {
            wingcounter++;
            return flight1;
        }

        wingcounter--;
        return flight2;
    }
    Rect getcollisionshape()
    {
        return  new Rect(x,y,x+width,y+height);
    }
    Bitmap getDead(){
        return dead;
    }
}
