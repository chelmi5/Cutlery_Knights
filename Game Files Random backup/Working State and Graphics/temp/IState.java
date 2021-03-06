package temp;

import java.io.*;

public interface IState extends Serializable
{
    public String getType();
    public void Update();
    public void Render();
    public void OnEnter();
    public void OnExit();
}