/**
 * Created by Chelsea on 4/17/2015.
 */
public class BallsBlue extends TreeDecorator
{
    Tree tree;

    public BallsBlue(Tree t)
    {
        this.tree = t;
    }

    public String getDescription()
    {
        return tree.getDescription() + ", Blue Balls";
    }

    public double cost()
    {
        return 2.0 + tree.cost();
    }
}
