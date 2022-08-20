public class Buffer {
	
	final int SIZE_OF_QUEUE;
	Object buffer[];
	private int[] age;

	Semaphore isFull;
	Semaphore isEmpty;
	Semaphore useQueue;
	
	int head;
	int tail;

	public Buffer(int size)
	{
		SIZE_OF_QUEUE = size;
		buffer 			= new Object[SIZE_OF_QUEUE];
		age         = new int[SIZE_OF_QUEUE];

		isFull 			= new Semaphore(0);
		isEmpty 		= new Semaphore(SIZE_OF_QUEUE);
		useQueue = new Semaphore(1);

		head=0;
		tail=0;
	}

	public void insert(Object item)
	{
		isEmpty.acquire();
		useQueue.acquire();
		// putItemIntoQueue(item)

		buffer[tail] = item;
		age[tail] = 1;
		tail = (tail + 1) % SIZE_OF_QUEUE ;

		// sorting processes by id (c) to priorize the
		// highest id process
		for(int i=0; i<buffer.length; i++){
			if(buffer[i] == null) continue;
			
			// supose the highest
			int greatestIdIndex = i;

			for(int j=i+1; j<buffer.length;j++){
				if(buffer[j] == null) continue;

				// age * Id criteria to avoid starvation in (d)
				if(getId(buffer[j])*age[j] > getId(buffer[greatestIdIndex])*age[greatestIdIndex]){
					greatestIdIndex = j;
					// update the highest
				}
			}

			// swaping actual position with the highest
			Object tempBuffer = buffer[greatestIdIndex];
			buffer[greatestIdIndex] = buffer[i];
			buffer[i] = tempBuffer;

			// swapping ages in swapped elements
			int tempAge = age[greatestIdIndex];
			age[greatestIdIndex] = age[i];
			age[i] = tempAge;
		}

		// // printing the buffer
		// int pos = -1;
		// for(Object obj : buffer){
		// 	pos++;
		// 	if(obj == null) continue;
		// 	System.out.println("|--- " + obj + " [age :" + age[pos] + "] ---|");
		// } 

		useQueue.release();
		isFull.release();

	}


	public Object remove()
	{
		isFull.acquire();
		useQueue.acquire();

		for (int i = 0; i < buffer.length; i++) {
			if(buffer[i] != null) head = i;
		}

		Object item = buffer[head];
		
		for(int i=0; i<buffer.length; i++){
			if(buffer[i] != null) age[i]++;
		}
		
		useQueue.release();
		isEmpty.release();

		return item;
	}

	// extracting ID from item
	private int getId(Object data){ 
		return Integer.parseInt(
									((String)data).split( "#" )[1]);
	}

}