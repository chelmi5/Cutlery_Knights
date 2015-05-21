package Engine;
import java.io.*;

public interface IState extends Serializable
{
    public String getType();
    public AGraphics getGraphics();
    public void Update();
    public void Render();
    public void OnEnter();
    public void OnExit();
}