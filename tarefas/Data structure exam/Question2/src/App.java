public class App {
    public static void main(String[] args) throws Exception {
       
        BinarySearchTree<FootballTeam> rankTree = new BinarySearchTree<>();

        rankTree.add(new FootballTeam("Flamengo", 1000000.0, 5));
        rankTree.add(new FootballTeam("Botafogo", 104000.0, 8));
        rankTree.add(new FootballTeam("Barcelona", 1000000.0, 4));
        rankTree.add(new FootballTeam("Fluminense", 550000.0, 3));
        rankTree.add(new FootballTeam("Vasco", 1000123.0, 2));
        rankTree.add(new FootballTeam("Machester United", 100.0, 12));
        rankTree.add(new FootballTeam("Sao Paulo FC", 1000000.0, 13));
        rankTree.add(new FootballTeam("Portugal", 1000000.0, 6));
        rankTree.add(new FootballTeam("Argentina", 1000000.0, 23));
        rankTree.add(new FootballTeam("Fortaleza", 1000000.0, 7));
        

        System.out.println("---------------------------------");
        System.out.println("Show if the rank is empty: " + rankTree.isEmpty());
        System.out.println("---------------------------------");
        System.out.println("Total teams in rank: " + rankTree.count());
        System.out.println("---------------------------------");
        System.out.println("The first team in the rank: " + rankTree.min() );
        System.out.println("---------------------------------");
        System.out.println("The last team in the rank: " + rankTree.max() );
        System.out.println("---------------------------------");
        System.out.println(rankTree);
        System.out.println("---------------------------------");        

    }
}
