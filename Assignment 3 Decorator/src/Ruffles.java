/**
 * Created by Chelsea on 4/17/2015.
 */
public class Ruffles extends TreeDecorator
{
    Tree tree;

    public Ruffles(Tree t)
    {
        this.tree = t;
    }

    public String getDescription()
    {
        return tree.getDescription() + ", Ruffles";
    }

    public double cost()
    {
        return 1.0 + tree.cost();
    }
}
