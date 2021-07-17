import java.util.LinkedList;

public class Path implements PathInterface {
    protected boolean[] marked;
    protected int[] edgeTo;
    protected int source;

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public LinkedList<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = v;
        while (vertex != source){
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        return stack;
    }
}
