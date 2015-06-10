/**
 * Created by Chelsea on 4/17/2015.
 */
public class BallsRed extends TreeDecorator
{
    Tree tree;

    public BallsRed(Tree t)
    {
        this.tree = t;
    }

    public String getDescription()
    {
        return tree.getDescription() + ", Red Balls";
    }

    public double cost()
    {
        return 1.0 + tree.cost();
    }
}
