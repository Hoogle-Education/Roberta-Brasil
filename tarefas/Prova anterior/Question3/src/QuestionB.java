public class QuestionB {
    public static void main(String[] args) throws Exception {
       
        int[] array = {1, 14, 21, 3, 4, 2};

        bubbleSort(array);

    }

    public static void bubbleSort(int[] array){

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(array[i] < array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp; 
                }    
            }

            System.out.println("Step #" + (i+1));
            for(int value : array) System.out.print(value + " ");
            System.out.println("");
            
        }
    }

}
