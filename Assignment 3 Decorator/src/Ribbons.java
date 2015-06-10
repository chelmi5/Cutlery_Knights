/**
 * Created by Chelsea on 4/17/2015.
 */
public class Ribbons extends TreeDecorator
{
    Tree tree;

    public Ribbons(Tree t)
    {
        this.tree = t;
    }

    public String getDescription()
    {
        return tree.getDescription() + ", Ribbons";
    }

    public double cost()
    {
        return 2.0 + tree.cost();
    }
}
