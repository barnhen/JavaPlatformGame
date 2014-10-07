/*
 * Created by Henrique Barnabe. 2014 root.
 * This is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * Unless (of course) you are Enzo Henrique Barnabe.
 * Enjoy.
 */
package com.barnabot.nova;

import com.barnabot.nova.entity.Player;
import com.barnabot.nova.enums.GameState;
import com.barnabot.nova.gfx.Renderer;
import com.barnabot.nova.gfx.Textures;
import com.barnabot.nova.input.KeyInput;
import com.barnabot.nova.input.MouseInput;
import com.barnabot.nova.libs.Audio;
import com.barnabot.nova.libs.Identities;
import com.barnabot.nova.screens.Menu;
import com.barnabot.nova.utils.AudioPlayer;
import com.barnabot.nova.utils.ResourceLoader;
import com.barnabot.nova.world.Level;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import org.lwjgl.openal.AL;

/**
 * Project: Cataclysmic
 *
 * @author Henrique Barnabe
 */
public class Game extends Canvas implements Runnable
{
    private static final long serialVersionUID = 1L;
   
    public static final int WIDTH = 640;
    public static final int HEIGHT = WIDTH / 4 * 3;
    private static final String TITLE = "Cataclysmic Battles";
    private static Game game = new Game();
    public static GameState state = GameState.MENU;

    private boolean running = false;
    private Thread thread;
    private Renderer gfx;
    private Camera camera;
    private Menu menu;
    private Controller controller = new Controller(); //control all the game objects

    private Textures tex;
    public Level levelOne;
    
    public static Game getInstance()
    {
        return game; 
    }
    
    public Menu getMenu()
    {
        return menu;
    }
    
    public Controller getController()
    {
        return controller;
    }
    
    public Textures getTextureHandler()
    {
        return tex;
    }
    
    private void init()
    {
        ResourceLoader.loadImages();
        ResourceLoader.loadFonts();
        ResourceLoader.loadSounds();
        tex = new Textures();
        menu = new Menu();
        gfx = new Renderer();
        MouseInput mouse = new MouseInput();
        this.addMouseListener(mouse);
        this.addMouseMotionListener(mouse);
        
//        int x = 0;
//        //width / 32 = 20
//        for (int k = 0; k < 20; k++)
//        {
//            controller.addObject(new Block(x, HEIGHT - 64, Identities.BLOCK_STONE, tex.blockStone));
////            Controller.addObject(new Block(x, HEIGHT - 250, Identities.BLOCK_METAL,tex,tex.blockMetal));
//            x+=32;
//        }
//        controller.addObject(new Block(400, HEIGHT - 128, Identities.BLOCK_METAL, tex.blockMetal));
//        controller.addObject(new Block(400, HEIGHT - (128 + 32), Identities.BLOCK_METAL, tex.blockMetal));
//        controller.addObject(new Block(300, HEIGHT - 300, Identities.BLOCK_METAL, tex.blockMetal));
        levelOne = new Level(1);
        controller.addObject(new Player(100,HEIGHT - 220,Identities.PLAYER,tex));
        camera = new Camera(0,0);
        this.addKeyListener(new KeyInput());
        
        AudioPlayer.playMusic(Audio.MUSIC_MOON);
    }
    
    public void tick()
    {
        if(state == GameState.GAME)
        {
            controller.tick();
            camera.tick();
        }
    }


    
    public void render()
    {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null)
        {
            createBufferStrategy(3); // creates triple buffering
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        Graphics2D g2D = (Graphics2D) g;
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT); // create the bg for the game here
        
        ////////////////////////////////
        gfx.renderBackground(g);
        g2D.translate(camera.getX(), camera.getY());
        gfx.renderForeground(g);
        g2D.translate(-camera.getX(), -camera.getY());
        ////////////////////////////////
        g.dispose();
        bs.show();
    }
    
    
    @Override
    public void run()
    {
        init();
        long lastTime = System.nanoTime();
        final double numTicks = 60.0; // fps
        double n  = 1000000000 / numTicks;
        double delta = 0;
        int frames = 0;
        int ticks = 0;
        long timer = System.currentTimeMillis();
        
        while(running)
        {
            long currentTime = System.nanoTime();
            delta = delta + (currentTime - lastTime) / n; // regulating fps
            lastTime = currentTime;
            
            if(delta >= 1)
            {
                tick();
                ticks++;
                delta--;
            }
            
            render();
            frames++;
            
            if (System.currentTimeMillis() - timer > 1000)
            {
                timer+=1000;
                System.out.println(ticks + " Ticks, FPS: " + frames);
                
//                frame.setTitle(TITLE + "        Ticks: " + ticks + "    FPS: " + frames); // to uncomment
                Window.setTitle(TITLE + "    FPS: " + frames);
                ticks = 0;
                frames = 0;
            }
        }
        stop();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String args[])
    {        
//        JFrame frame = new JFrame(TITLE);
        Window.initWindow(TITLE);
        Window.addGame(game);
        Window.createWindow();
        
        game.start();
    }
    
    private synchronized void start()
    {
        if (running)
            return;
        else
            running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    private synchronized void stop()
    {
        if (!running)
            return;
        else
            running = false;
        
        cleanUp();        
        System.exit(1);
    }

    private void cleanUp()
    {
        AL.destroy();
    }
    
    public static void exit()
    {
        game.stop();
    }
    
    
    private static class Point extends java.awt.Point
    {

        public Point(int x, int y)
        {
        }
    }
    
    

}
