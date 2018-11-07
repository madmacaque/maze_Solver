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
   
   public LocationQueue(int s)
   {
        maxSize = s;
        queArray = new Location[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
       
   }
   
   public void insert(Location j)
   {
       if(rear == maxSize-1)         // deal with wraparound
            rear = -1;
        queArray[++rear] = j;         // increment rear and insert
        nItems++; 
   }
   
   public Location remove()         // take item from front of queue
    {
        Location temp;
        temp = queArray[front++]; // get value and incr front
        if(front == maxSize)           // deal with wraparound
            front = 0;
        nItems--;                      // one less item
        return temp;
    }
    
    public boolean isEmpty()    // true if queue is empty
    {
        return (nItems==0);
    }
}
