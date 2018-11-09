//Min       1259846
//Gurinder
//Rafael

public class LocationQueue
{
   private int maxSize;
   private Location[] queArray;
   private int front;
   private int rear;
   private int nItems;

   //constructs a queue of size s
   public LocationQueue(int s)
   {
        maxSize = s;
        queArray = new Location[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
   }
   //adds a location to the queue to be visted
   public void insert(Location j)
   {
       if(rear == maxSize-1)         // deal with wraparound
            rear = -1;
        queArray[++rear] = j;         // increment rear and insert
        nItems++; 
   }

   //removes the first location because it's being visited
   public Location remove()
    {
        Location temp;
        temp = queArray[front++]; // get value and incr front
        if(front == maxSize)           // deal with wraparound
            front = 0;
        nItems--;                      // one less item
        return temp;
    }

    // true if queue is empty
    public boolean isEmpty()
    {
        return (nItems==0);
    }
}
