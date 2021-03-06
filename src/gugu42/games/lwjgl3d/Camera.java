package gugu42.games.lwjgl3d;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class Camera {
	private Vector3f    position    = null;
    private float       yaw         = 0.0f;
    private float       pitch       = 0.0f;
    
    public Camera(float x, float y, float z)
    {
        position = new Vector3f(x, y, z);
    }
    
    public void render(){
    	//todo : Render du player
    }
    
    public void yaw(float amount)
    {
        yaw += amount;
    }
     
    public void pitch(float amount)
    {
        pitch -= amount;
    }
    
    public void walkForward(float distance)
    {
        position.x -= distance * (float)Math.sin(Math.toRadians(yaw));
        position.z += distance * (float)Math.cos(Math.toRadians(yaw));
    }
     
    public void walkBackwards(float distance)
    {
        position.x += distance * (float)Math.sin(Math.toRadians(yaw));
        position.z -= distance * (float)Math.cos(Math.toRadians(yaw));
    }
     
    public void strafeLeft(float distance)
    {
        position.x -= distance * (float)Math.sin(Math.toRadians(yaw-90));
        position.z += distance * (float)Math.cos(Math.toRadians(yaw-90));
    }
     
    public void strafeRight(float distance)
    {
        position.x -= distance * (float)Math.sin(Math.toRadians(yaw+90));
        position.z += distance * (float)Math.cos(Math.toRadians(yaw+90));
    }
    
    public void flyUp(float distance)
    {
        position.y -= distance;
    }
    
    public void flyDown(float distance)
    {
        position.y += distance;
    }
    
    public void lookThrough()
    {
        GL11.glRotatef(pitch, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(yaw, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(position.x, position.y, position.z);
    }
}
