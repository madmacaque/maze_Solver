// Min Thein
// 1259846
// Queue.java
// demonstrates queue
// to run this program: C>java QueueApp
////////////////////////////////////////////////////////////////
class Queue
{
   private int maxSize;
   private long[] queArray;
   private int front;
   private int rear;
   private int nItems;
//--------------------------------------------------------------
   public Queue(int s)          // constructor
      {
      maxSize = s;
      queArray = new long[maxSize];
      front = 0;
      rear = -1;
      nItems = 0;
      }
//--------------------------------------------------------------
   public void insert(long j)   // put item at rear of queue
      {
      if(rear == maxSize-1)         // deal with wraparound
         rear = -1;
      queArray[++rear] = j;         // increment rear and insert
      nItems++;                     // one more item
      }
//--------------------------------------------------------------
   public long remove()         // take item from front of queue
      {
      long temp = queArray[front++]; // get value and incr front
      if(front == maxSize)           // deal with wraparound
         front = 0;
      nItems--;                      // one less item
      return temp;
      }
//--------------------------------------------------------------
   public long peekFront()      // peek at front of queue
      {
      return queArray[front];
      }
//--------------------------------------------------------------
   public boolean isEmpty()    // true if queue is empty
      {
      return (nItems==0);
      }
//--------------------------------------------------------------
   public boolean isFull()     // true if queue is full
      {
      return (nItems==maxSize);
      }
//--------------------------------------------------------------
   public int size()           // number of items in queue
      {
      return nItems;
      }
//--------------------------------------------------------------
   //returns the second object from front
   //assumes queue has at least 2 elements
   public static Object removeSecond (Queue queue){
      Queue secondArrray=new Queue(queue.nItems);
      long first=queue.remove();
      Object second=queue.remove();
      while(!queue.isEmpty()){
         secondArrray.insert(queue.remove());
      }
      queue.insert(first);
      while(!secondArrray.isEmpty()){
         queue.insert(secondArrray.remove());
      }
      return second;
   }
//--------------------------------------------------------------
   //reverse the order of the queue
   public static void reverse (Queue queue){
      long[] reversed=new long[queue.nItems];
      for (int n=queue.nItems-1;n>=0;n--){
         reversed[n]=queue.remove();
      }

      //put reversed back into queue
      for (int j=0; j<reversed.length; j++){
         queue.insert(reversed[j]);
      }
   }
}  // end class Queue
////////////////////////////////////////////////////////////////
class QueueApp
{
   public static void main(String[] args)
   {

      Queue theQueue = new Queue(5);  // queue holds 5 items
      /*
      theQueue.insert(10);            // insert 4 items
      theQueue.insert(20);
      theQueue.insert(30);
      theQueue.insert(40);

      theQueue.remove();              // remove 3 items
      theQueue.remove();              //    (10, 20, 30)
      theQueue.remove();

      theQueue.insert(50);            // insert 4 more items
      theQueue.insert(60);            //    (wraps around)
      theQueue.insert(70);
      theQueue.insert(80);

      while( !theQueue.isEmpty() )    // remove and display
         {                            //    all items
         long n = theQueue.remove();  // (40, 50, 60, 70, 80)
         System.out.print(n);
         System.out.print(" ");
         }
      System.out.println("");
      */
      //--------------------------------------------------------
      // remove the second item
      System.out.println("Before calling removeSecond(Queue queue)");
      theQueue.insert(50);            // insert 4 more items
      theQueue.insert(60);            //    (wraps around)
      theQueue.insert(70);
      theQueue.insert(80);
      while( !theQueue.isEmpty() )    // remove and display
      {                            //    all items
         long n = theQueue.remove();  // (40, 50, 60, 70, 80)
         System.out.print(n);
         System.out.print(" ");
      }
      System.out.println();
      theQueue.insert(50);            // insert 4 more items
      theQueue.insert(60);            //    (wraps around)
      theQueue.insert(70);
      theQueue.insert(80);
      theQueue.removeSecond(theQueue);
      System.out.println("After calling removeSecond(Queue queue)");
      while( !theQueue.isEmpty() )    // remove and display
      {                            //    all items
         long n = theQueue.remove();  // (40, 50, 60, 70, 80)
         System.out.print(n);
         System.out.print(" ");
      }
      System.out.println();

      //--------------------------------------------------------
      //reverse the order
      theQueue.insert(50);            // insert 4 more items
      theQueue.insert(60);            //    (wraps around)
      theQueue.insert(70);
      theQueue.insert(80);
      System.out.println();
      System.out.println("Before calling reverse(Queue queue)");
      while( !theQueue.isEmpty() )    // remove and display
      {                            //    all items
         long n = theQueue.remove();  // (40, 50, 60, 70, 80)
         System.out.print(n);
         System.out.print(" ");
      }
      System.out.println("");
      theQueue.insert(50);            // insert 4 more items
      theQueue.insert(60);            //    (wraps around)
      theQueue.insert(70);
      theQueue.insert(80);
      theQueue.reverse(theQueue);
      System.out.println("After calling reverse(Queue queue");
      while( !theQueue.isEmpty() )    // remove and display
      {                            //    all items
         long n = theQueue.remove();
         System.out.print(n);
         System.out.print(" ");
      }
      System.out.println("");
      }  // end main()
   }  // end class QueueApp
////////////////////////////////////////////////////////////////
