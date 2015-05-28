package Input;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener{

    public boolean click;
    private int count = 0;
    private int mouseX = -1;
    private int mouseY = -1;

    public MouseManager() {
    }

    public void update() {
        click = 0 != count;
    }

    public int getMouseY() {
        return mouseY;
    }

    public int getMouseX() {
        return mouseX;
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();

        System.out.println("MouseX: " + mouseX + "MouseY: "+ mouseY);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() != -1)
            count++;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        click = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }


}
