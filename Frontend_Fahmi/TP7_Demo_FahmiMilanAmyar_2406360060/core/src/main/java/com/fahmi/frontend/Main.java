package com.fahmi.frontend;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends ApplicationAdapter {

    // buat kotak di layar
    ShapeRenderer sr;
    // terus kita simpan di dalam rectangle gitu
    Rectangle kotak;
    // kecepatan gerak kotaknya
    float speed = 300;
    // warna-warna
    Color[] warna = {Color.RED, Color.YELLOW, Color.BLUE};
    int warnaSekarang = 0;

    @Override
    public void create() {
        // kita bikin objek baru buat gambar
        sr = new ShapeRenderer();
        float uk = 50;
        // posisi awal kotak maunya di tengah layar
        float x = Gdx.graphics.getWidth()/2 - uk/2;
        float y = Gdx.graphics.getHeight()/2 - uk/2;
        kotak = new Rectangle(x, y, uk, uk);
    }

    @Override
    public void render() {
        // deltaTime agar gerak kota lebih smooth operator
        float t = Gdx.graphics.getDeltaTime();


        // disini input input keysnya gitu
        if(Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP)){
            kotak.y = kotak.y + speed * t;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            kotak.y = kotak.y - speed * t;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            kotak.x = kotak.x - speed * t;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            kotak.x = kotak.x + speed * t;
        }

        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            warnaSekarang = warnaSekarang + 1;
            if(warnaSekarang >= warna.length){
                warnaSekarang = 0;
            }
            System.out.println("warna: "+warnaSekarang);
        }

        // biar kotak gak keluar dari layar
        if(kotak.x < 0) kotak.x = 0;
        if(kotak.y < 0) kotak.y = 0;
        if(kotak.x + kotak.width > Gdx.graphics.getWidth()) kotak.x = Gdx.graphics.getWidth() - kotak.width;
        if(kotak.y + kotak.height > Gdx.graphics.getHeight()) kotak.y = Gdx.graphics.getHeight() - kotak.height;

        // layar hitamkan
        ScreenUtils.clear(0,0,0,1);

        //gambar kotaknya
        sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.setColor(warna[warnaSekarang]);
        sr.rect(kotak.x, kotak.y, kotak.width, kotak.height);
        sr.end();
    }

    @Override
    public void dispose() {
        // hapuskan biar gak makan memory
        sr.dispose();
    }
}
