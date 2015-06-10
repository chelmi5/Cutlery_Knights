/**
 * Created by Chelsea on 4/17/2015.
 */
public class Star extends TreeDecorator
{
    private Tree tree;
    private static Star uniqueInstance;

    private Star(Tree t)
    {
        this.tree = t;
    }

    public static Star getUniqueInstance(Tree t)
    {
        if(uniqueInstance == null)
        {
            uniqueInstance = new Star(t);
        }
        return uniqueInstance;
    }

    public String getDescription()
    {
        return tree.getDescription() + ", Star";
    }

    public double cost()
    {
        return 4.0 + tree.cost();
    }
}
