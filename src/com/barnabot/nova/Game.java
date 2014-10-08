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
import com.barnabot.nova.input.KeyInput;
import com.barnabot.nova.input.MouseInput;
import com.barnabot.nova.libs.Reference;
import com.barnabot.nova.main.Camera;
import com.barnabot.nova.screens.Menu;
import com.barnabot.nova.utils.AudioPlayer;
import com.barnabot.nova.utils.ResourceLoader;
import com.barnabot.nova.world.World;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.io.InvalidClassException;
import org.lwjgl.openal.AL;

/**
 * Project: Cataclysmic
 *
 * @author Henrique Barnabe
 */
public class Game extends Canvas implements Runnable
{

    /**
     * Docs for serialVersionUID came from <code> java.io.Serializable </code>
     * <br><br>
     * The serialization runtime associates with each serializable class a
     * version number, called a serialVersionUID, which is used during
     * deserialization to verify that the sender and receiver of a serialized
     * object have loaded classes for that object that are compatible with
     * respect to serialization. If the receiver has loaded a class for the
     * object that has a different serialVersionUID than that of the
     * corresponding sender's class, then deserialization will result in an
     * {@link InvalidClassException}. A serializable class can declare its own
     * serialVersionUID explicitly by declaring a field named
     * <code>"serialVersionUID"</code> that must be static, final, and of type
     * <code>long</code>:
     * <p>
     *
     * <PRE>
     * ANY-ACCESS-MODIFIER static final long serialVersionUID = 42L;
     * </PRE>
     *     
* If a serializable class does not explicitly declare a serialVersionUID,
     * then the serialization runtime will calculate a default serialVersionUID
     * value for that class based on various aspects of the class, as described
     * in the Java(TM) Object Serialization Specification. However, it is
     * <em>strongly recommended</em> that all serializable classes explicitly
     * declare serialVersionUID values, since the default serialVersionUID
     * computation is highly sensitive to class details that may vary depending
     * on compiler implementations, and can thus result in unexpected
     * <code>InvalidClassException</code>s during deserialization. Therefore, to
     * guarantee a consistent serialVersionUID value across different java
     * compiler implementations, a serializable class must declare an explicit
     * serialVersionUID value. It is also strongly advised that explicit
     * serialVersionUID declarations use the <code>private</code> modifier where
     * possible, since such declarations apply only to the immediately declaring
     * class--serialVersionUID fields are not useful as inherited members. Array
     * classes cannot declare an explicit serialVersionUID, so they always have
     * the default computed value, but the requirement for matching
     * serialVersionUID values is waived for array classes.
     */
    /**
     * Docs for serialVersionUID came from <code> java.io.Serializable </code>
     * <br>
     * <br>
     * The serialization runtime associates with each serializable class a
     * version number, called a serialVersionUID, which is used during
     * deserialization to verify that the sender and receiver of a serialized
     * object have loaded classes for that object that are compatible with
     * respect to serialization. If the receiver has loaded a class for the
     * object that has a different serialVersionUID than that of the
     * corresponding sender's class, then deserialization will result in an
     * {@link InvalidClassException}. A serializable class can declare its own
     * serialVersionUID explicitly by declaring a field named
     * <code>"serialVersionUID"</code> that must be static, final, and of type
     * <code>long</code>:
     * <p>
     *
     * <PRE>
     * ANY-ACCESS-MODIFIER static final long serialVersionUID = 42L;
     * </PRE>
     *     
* If a serializable class does not explicitly declare a serialVersionUID,
     * then the serialization runtime will calculate a default serialVersionUID
     * value for that class based on various aspects of the class, as described
     * in the Java(TM) Object Serialization Specification. However, it is
     * <em>strongly recommended</em> that all serializable classes explicitly
     * declare serialVersionUID values, since the default serialVersionUID
     * computation is highly sensitive to class details that may vary depending
     * on compiler implementations, and can thus result in unexpected
     * <code>InvalidClassException</code>s during deserialization. Therefore, to
     * guarantee a consistent serialVersionUID value across different java
     * compiler implementations, a serializable class must declare an explicit
     * serialVersionUID value. It is also strongly advised that explicit
     * serialVersionUID declarations use the <code>private</code> modifier where
     * possible, since such declarations apply only to the immediately declaring
     * class--serialVersionUID fields are not useful as inherited members. Array
     * classes cannot declare an explicit serialVersionUID, so they always have
     * the default computed value, but the requirement for matching
     * serialVersionUID values is waived for array classes.
     */
    private static final long serialVersionUID = -1890564841829395437L;
    public static final int WIDTH = 640;
    public static final int HEIGHT = WIDTH / 4 * 3; //Creates a nice 4:3 ratio for our window
    public static final String TITLE = "Cataclysmic Battles"; //The title of our game
    public static GameState state = GameState.LOADING; //We start in this game state
    private boolean running = false; //by default, we need this to be false so we do not exit our start method right away
    private Thread thread; //the thread that will control our game loop
    private Camera camera;
    private Menu menu; //our menu object
    private World world;
    private Player player;

    public Game()
    {
        ResourceLoader.loadSounds();
        menu = new Menu();
        world = new World("world.png");
        player = new Player(100, 100, world);
        MouseInput mouse = new MouseInput(); //local mouse input object is used instead of an anonymous inner type so we may have multiple mouse listeners working together better
        this.addMouseListener(mouse); //adds a listener to listen for clicking of mouse buttons
        this.addMouseMotionListener(mouse); //adds a listener to listen for mouse motion
        camera = new Camera(); //this must be initialized AFTER the controller
        this.addKeyListener(new KeyInput());
    }

    private void load()
    {
        ResourceLoader.loadFonts();
        state = GameState.GAME;
        AudioPlayer.playMusic(Reference.MUSIC_MOON); //Plays our music
    }

    /**
     * Updates the objects in the game This also runs the logic in the game
     */
    public void tick()
    {
        if (state == GameState.LOADING)
        {
            load();
        }
        if (state == GameState.GAME)
        {
            if (KeyInput.getKey(KeyEvent.VK_N))
            {
                world = new World("moon.png");
                player = new Player(100, 100, world);
            }
            if (world != null)
            {
                world.tick();
                camera.tick(world.getPlayer());
            }
        }
    }

    /**
     * This renders the graphics for the game This method uses a triple
     * buffering strategy with a default background of a darkish purple
     */
    public void render()
    {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null)
        {
            createBufferStrategy(3); //Creates the buffer strategy if there isn't already one
            return;
        }
        Graphics g = bs.getDrawGraphics(); //We want to use the graphics that comes from our buffer strategy
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(new Color(6, 0, 40));
        g.fillRect(0, 0, WIDTH, HEIGHT); //We are creating a background for our game here
///////////////////////////////////////////////////
        if (state == GameState.LOADING)
        {
            g.fillRect(0, 0, WIDTH, HEIGHT);
        }
//render splashscreen
        else if (world != null)
        {
// renderBackground(g);
            g2d.translate(camera.getX(), camera.getY()); //do this before the foreground and after the background
            world.render(g);
            g2d.translate(-camera.getX(), -camera.getY()); //do this after the foreground
        }
///////////////////////////////////////////////////
        g.dispose(); //Disposes our graphics context (if we did not do this, animations would not work properly, it would also eat up a lot of memory
        bs.show(); //Shows whatever graphics were just disposed of
    }

    @Override
    /**
     * This is our main game loop that we are able to use thanks to the Runnable
     * Interface
     */
    public void run()
    {
        requestFocus();
        long lastTime = System.nanoTime(); //gets the time before the loop
        final double numTicks = 60.0; //We want to have 60 updates per second, too much and we will lag like a mofo, too litle and it will appear as though nothing is happening in the game
        double nanoSeconds = 1000000000 / numTicks;
        double delta = 0; //change over time
        int frames = 0; //frames during that second
        int ticks = 0; //ticks or updates during that second
        long timer = System.currentTimeMillis(); //We will be using this as, well, a timer
        while (running)
        { //we only want to do this stuff if and only if the game is running
            long currentTime = System.nanoTime(); //the current time during the game loop
            delta += (currentTime - lastTime) / nanoSeconds; //because the time is changing, we need to update our delta
            lastTime = currentTime; /* Our last time now needs to be the previous time during the game loop, we do this by storing the current time,
             this is why this goes AFTER the previous two lines */

            if (delta >= 1)
            { //We want to make sure our delta doesn't remain over 1
                tick(); //updates the game
                ticks++; //Adds to the ticks per second
                delta--; //Lowering the delta value for the next run through
            }
            render(); //renders the game
            frames++; //Adds to the frames per second
            if (System.currentTimeMillis() - timer > 1000)
            { //We are going to print our frames and ticks to the console every second
                timer += 1000; //Time must go on!
                System.out.println(ticks + " Ticks, FPS: " + frames); //Prints the TPS and FPS to the console
                Window.setTitle(TITLE + " FPS: " + frames);
                ticks = 0; //If we did not do these 2 lines, we would have 10000000000000000000 ticks and fps at one point, then another 10000000000000000000000000000000000000000 the next second
                frames = 0;
            }
        }
        stop(); //Once exit the loop, stop the game
    }

    public static void main(String args[])
    {
        Game game = new Game();
        Window.createWindow(game, TITLE);
        game.start(); //starts the game
    }

    /**
     * This starts the game thread It is synchronized because we do not want to
     * do anything else until this method is 100% complete
     */
    private synchronized void start()
    {
        if (running)
        {
            return; //if the game is already running, we do not want to run the game again
        }
        running = true;
        thread = new Thread(this); //this thread controls our game
        thread.start(); //starts the thread, and thus the game loop
    }

    /**
     * This stops the game thread It is synchronized because we do not want to
     * do anything else until this method is 100% complete
     */
    private synchronized void stop()
    {
        if (!running)
        {
            return; //if the game has already stopped, why stop it again?
        }
        running = false;
        cleanUp();
        try
        {
            thread.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.exit(1); //exits the game
    }

    /**
     * Cleans up resources used by the system to avoid bugs on exit
     */
    private static void cleanUp()
    {
        AL.destroy(); //properly closes audio devices
    }

    /**
     * Exits the game
     */
    public static void exit()
    {
        cleanUp();
        System.exit(0);
    }
}
