//Min       1259846
//Gurinder
//Rafael

public class Location
{

    int i , j;

    //constructor i as row, and j as col
    public Location(int i, int j)
    {
        this.i = i; //columnNo
        this.j = j; //rowNo
    }

    //checks if the 2 locations are the same
    public boolean equals(Location location){
        return (this.i==location.i && this.j==location.j);
    }
}
