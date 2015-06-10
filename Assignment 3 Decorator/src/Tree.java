/**
 * Chelsea Davis, CSCD 349, Assignment 3, Decorator
 */
public abstract class Tree
{
    String description = "Unknown Tree";

    public String getDescription()
    {
        return description;
    }

    public abstract double cost();
}
