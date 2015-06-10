/**
 * Created by Chelsea on 4/17/2015.
 */
public class Lights extends TreeDecorator
{
    Tree tree;

    public Lights(Tree t)
    {
        this.tree = t;
    }

    public String getDescription()
    {
        return tree.getDescription() + ", Lights";
    }

    public double cost()
    {
        return 5.0 + tree.cost();
    }
}
