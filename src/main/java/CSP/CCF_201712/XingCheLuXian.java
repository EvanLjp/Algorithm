package CSP.CCF_201712;



/*
public class XingCheLuXian {
    public static Edge[][] graph ;
    public static int n;

    public static void main(String[] args) {
        // TODO Auto-generated constructor stub
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        graph=new Edge[n][n];
        for (int i = 0; i < m; i++) {
            boolean flag = sc.nextInt() == 0;
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            graph[from-1][to-1]=new Edge(to-1,weight,flag);
            graph[to-1][from-1]=new Edge(from-1,weight,flag);
        }
        long[] res = new long[n];
        PriorityQueue<Edge> queue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                if (res[o1.to] == res[o2.to]) return o2.to - o1.to;
                else return (int) (res[o1.to]-res[o2.to]);
            }
        });
        queue.offer(new Edge(0,0,true));
        boolean[] visisted = new boolean[n];

        Arrays.fill(res, Long.MAX_VALUE);
        res[0]=0;
        while (!queue.isEmpty()){
            Edge poll = queue.poll();
            if(visisted[poll.to]) continue;
            else visisted[poll.to]=true;
            List<Edge> edges = getNeighbours(poll.to);
            for (Edge edge : edges) {
                if (edge.isAvanue) {
                    if(visisted[edge.to]) continue;
                    long temp = res[poll.to] + edge.length;
                    if (temp > res[edge.to]) continue;
                    res[edge.to] = temp;
                    queue.offer(new Edge( edge.to, 0,true));
                } else {
                    if(visisted[edge.to]) continue;
                    long temp = res[poll.to] - poll.length * poll.length + (edge.length + poll.length) * (edge.length + poll.length);
                    if (temp > res[edge.to]) continue;
                    res[edge.to] = temp;
                    queue.offer(new Edge( edge.to, poll.length + edge.length,false));
                }
            }
        }
        System.out.println(res[n-1]);
    }
    public static List<Edge> getNeighbours(int m){
        List<Edge> edges=new LinkedList<>();
        for (int i = 0; i <n; i++) {
           if(graph[m][i]!=null) edges.add(graph[m][i]);
        }
        return edges;
    }
}



class Edge {
    public int to;
    public long length;
    public boolean isAvanue;

    public Edge(int to, long length, boolean isAvanue) {
        this.to = to;
        this.length = length;
        this.isAvanue = isAvanue;
    }
}
*/




import java.util.*;

public class XingCheLuXian {
    public static HashMap<Integer,List<Edge>> graph;

    public static void main(String[] args) {
        // TODO Auto-generated constructor stub
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
         graph = new HashMap<>();
        for (int i = 0; i < m; i++) {
            boolean flag = sc.nextInt() == 0;
            int from = sc.nextInt()-1;
            int to = sc.nextInt()-1;
            long weight = sc.nextInt();
            List<Edge> edges1 = graph.containsKey(from) ? graph.get(from) : new LinkedList<Edge>();
            List<Edge> edges2 = graph.containsKey(to) ? graph.get(to) : new LinkedList<Edge>();
            edges1.add(new Edge(to,weight,0,flag));
            edges2.add(new Edge(from,weight,0,flag));
            graph.put(from,edges1);
            graph.put(to,edges2);
        }
        PriorityQueue<Edge> queue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                if (o1.cost == o2.cost) return o2.to - o1.to;
                else return (int) (o1.cost - o2.cost);
            }
        });
        queue.offer(new Edge(0, 0,true));
        boolean[] visisted = new boolean[n];
        long[] res = new long[n];
        Arrays.fill(res, Long.MAX_VALUE);
        res[0]=0;
        while (!queue.isEmpty()){
            Edge poll = queue.poll();
            if(visisted[poll.to]) continue;
            else visisted[poll.to]=true;
            List<Edge> edges = graph.get(poll.to);
            for (Edge edge : edges) {
                if (edge.isAvanue) {
                    if(visisted[edge.to]) continue;
                    long temp = res[poll.to] + edge.cost;
                    if (temp > res[edge.to]) continue;
                    res[edge.to] = temp;
                    queue.offer(new Edge( edge.to, temp,true));
                } else {
                    if(visisted[edge.to]) continue;
                    long temp = res[poll.to] - poll.length * poll.length + (poll.length + edge.cost) * (poll.length + edge.cost);
                    if (temp > res[edge.to]) continue;
                    res[edge.to] = temp;
                    queue.offer(new Edge( edge.to, temp, (int) (poll.length + edge.cost),false));
                }
            }
        }
        System.out.println(res[n-1]);
    }
}

class Edge {
    public int to;
    public long cost;
    public int length;
    public boolean isAvanue;

    public Edge(int to, long cost, boolean isAvanue) {
        this.to = to;
        this.cost = cost;
        this.isAvanue = isAvanue;
    }

    public Edge(int to, long cost, int length, boolean isAvanue) {
        this.to = to;
        this.cost = cost;
        this.length = length;
        this.isAvanue = isAvanue;
    }
}



