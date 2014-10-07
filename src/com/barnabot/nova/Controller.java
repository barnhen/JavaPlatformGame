/*
 * Created by Henrique Barnabe. 2014 Henrique Barnabe <barnabot.com>.
 * This is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * Unless (of course) you are Enzo Henrique Barnabe.
 * Enjoy.
 */

package com.barnabot.nova;

import com.barnabot.nova.core.CoreObject;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Henrique Barnabe <barnabot.com>
 */
public class Controller
{
  private ArrayList<CoreObject> objects = new ArrayList<CoreObject>();
  
//  public Conntroller()
//  {
//  
//  }
  
  public void tick()
  {
      //same as for each object in the object array list do this
      for (CoreObject obj : objects)
      {
          obj.tick();
      }
  }
  
  public void render(Graphics g)
  {
      for(CoreObject obj : objects)
      {
          obj.render(g);
      }
  }
  
  public void addObject(CoreObject instance)
  {
      objects.add(instance);
  }
  
  public void removeObject(CoreObject instance)
  {
      objects.remove(instance);
  }
 
  public ArrayList<CoreObject> getObjects()
  {
      return objects;
  }
  
}
