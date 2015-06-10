/**
 * Created by Chelsea on 4/17/2015.
 */
public class BallsSilver extends TreeDecorator
{
    Tree tree;

    public BallsSilver(Tree t)
    {
        this.tree = t;
    }

    public String getDescription()
    {
        return tree.getDescription() + ", Silver Balls";
    }

    public double cost()
    {
        return 3.0 + tree.cost();
    }
}
