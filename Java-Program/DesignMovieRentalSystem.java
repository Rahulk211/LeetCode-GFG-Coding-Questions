import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class DesignMovieRentalSystem {
    public static void main(String[] args) {
        int n = 3;
        int[][] entries = {{0, 1, 5}, {0, 2, 6}, {0, 3, 7}, {1, 1, 4}, {1, 2, 7}, {2, 1, 5}};
        MovieRentingSystem movieRentingSystem = new MovieRentingSystem(n, entries);
        System.out.println(movieRentingSystem.search(1)); // return [1,0,2]
        movieRentingSystem.rent(0, 1); // shop 0 rents movie 1
        movieRentingSystem.rent(1, 2); // shop 1 rents movie
        System.out.println(movieRentingSystem.report()); // return [[0,1],[1,2]]
        movieRentingSystem.drop(1, 2); // shop 1 drops movie
        System.out.println(movieRentingSystem.search(2)); // return [0,1]
        movieRentingSystem.rent(0, 2); // shop 0 rents movie 2
        System.out.println(movieRentingSystem.report()); // return [[0,1],[0,2]]
    }
}

class MovieRentingSystem {

    // PriorityQueue<int[]> mv_queue;
    // PriorityQueue<int[]> rent_queue;

    Map<Integer, TreeSet<int[]>> movieMap;
    TreeSet<int[]> rent_queue;
    Map<String, Integer> rentMap;

    public MovieRentingSystem(int n, int[][] entries) {
        movieMap = new HashMap<>();
        rent_queue = new TreeSet<>((a, b) -> a[2] == b[2] ? (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]) : a[2] - b[2]);
        rentMap = new HashMap<>();

        for(int[] e : entries){
            int movie = e[1];
            int shop = e[0];
            int price = e[2];
            movieMap.putIfAbsent(movie, new TreeSet<>((a, b) -> a[1] == b[1] ?  a[0] - b[0] : a[1] - b[1]));
            movieMap.get(movie).add(new int[]{shop, price});

            rentMap.put(shop + "-" + movie, price);
        }
    }
    
    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        if(movieMap.containsKey(movie)){
            for(int[] cur : movieMap.get(movie)){
                res.add(cur[0]);
                if(res.size() == 5) break;
            }
        }
        return res;
    }
    
    public void rent(int shop, int movie) {
        int price = rentMap.get(shop+"-"+movie);
        movieMap.get(movie).remove(new int[]{shop, price});
        rent_queue.add(new int[]{shop, movie, price});
    }
    
    public void drop(int shop, int movie) {
        int price = rentMap.get(shop+"-"+movie);
        rent_queue.remove(new int[]{shop, movie, price});
        movieMap.get(movie).add(new int[]{shop, price});
    }
    
    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        for(int[] cur : rent_queue){
            List<Integer> temp = new ArrayList<>();
            temp.add(cur[0]);
            temp.add(cur[1]);
            res.add(temp);
        }
        return res;
    }
}
