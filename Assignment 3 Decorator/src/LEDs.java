/**
 * Created by Chelsea on 4/17/2015.
 */
public class LEDs extends TreeDecorator
{
    Tree tree;

    public LEDs(Tree t)
    {
        this.tree = t;
    }

    public String getDescription()
    {
        return tree.getDescription() + ", LEDs";
    }

    public double cost()
    {
        return 10.0 + tree.cost();
    }
}
