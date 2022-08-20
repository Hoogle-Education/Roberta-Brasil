public class App {
    public static void main(String[] args) throws Exception {
       
        Queue queue = new Queue();

        queue.add(new CPUJob("job 1", 0, 4));
        queue.add(new CPUJob("job 2", 1, 2));
        queue.add(new CPUJob("job 3", 3, 6));
        queue.add(new CPUJob("job 4", 8, 3));

        System.out.println("Average time = " + queue.get_average());
        System.out.println("Average time = " + queue.get_averageTurnroundTime());

        queue.print();

    }
}
