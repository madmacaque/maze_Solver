//Min       1259846
//Gurinder
//Rafael

public class Location
{

    int i , j;

    public Location(int i, int j)
    {
        this.i = i; //columnNo
        this.j = j; //rowNo
    }

    //we might not need these if i and j are public
    public int i()
    {
       return i;
    }
    public int j()
    {
        return j;
    }
    
    /*public Location north()
    {
        return Loaction(i-1, j);
    }
    
    public Location south()
    {
        return Loaction(i+1, j);
    }
    
    public Location ()
    {
        return Loaction(i-1, j);
    }*/
    
}
