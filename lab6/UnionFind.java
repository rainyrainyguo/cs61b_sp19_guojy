public class UnionFind {

    // TODO - Add instance variables?
    private int[] parents;
    private int num_components;

    /* Creates a UnionFind data structure holding n vertices. Initially, all
       vertices are in disjoint sets. */
    public UnionFind(int n) {
        // TODO
        parents = new int[n];
        for(int i=0; i < n; i++){
            parents[i] = -1;
        }
        num_components = n;
    }

    /* Throws an exception if v1 is not a valid index. */
    private void validate(int vertex) {
        // TODO
        int n = parents.length;
        if(vertex < 0 || vertex >= n){
            throw new IllegalArgumentException("vertex " + vertex + " is not between 0 and " + (n-1));
        }
    }

    /* Returns the size of the set v1 belongs to. */
    public int sizeOf(int v1) {
        // TODO
        validate(v1);
        return Math.abs(parents[v1]);
    }

    /* Returns the parent of v1. If v1 is the root of a tree, returns the
       negative size of the tree for which v1 is the root. */
    public int parent(int v1) {
        // TODO
        validate(v1);
        return parents[v1];
    }

    /* Returns true if nodes v1 and v2 are connected. */
    public boolean connected(int v1, int v2) {
        // TODO
        validate(v1);
        validate(v2);
        return find(v1)==find(v2);
    }

    /* Connects two elements v1 and v2 together. v1 and v2 can be any valid 
       elements, and a union-by-size heuristic is used. If the sizes of the sets
       are equal, tie break by connecting v1's root to v2's root. Unioning a 
       vertex with itself or vertices that are already connected should not 
       change the sets but may alter the internal structure of the data. 这个的意思是会发生path compression?*/
    public void union(int v1, int v2) {
        // TODO
        validate(v1);
        validate(v2);
        int root1 = find(v1);
        int root2 = find(v2);
        int neg_size1 = parents[root1];
        int neg_size2 = parents[root2];
        if(neg_size1 < neg_size2){
            parents[root2] = root1;
            parents[root1] = neg_size1 + neg_size2;
        } else {
            parents[root1] = root2;
            parents[root2] = neg_size1 + neg_size2;
        }
        num_components --;
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. */
    public int find(int vertex) {
        // TODO
        validate(vertex);
        int temp = parents[vertex];
        int root = vertex;
        while(temp>=0){
            root = temp;
            temp = parents[temp];
        }
        temp = parents[vertex];
        while(temp >= 0){
            parents[vertex] = root;
            temp = parents[temp];
        }
        return root;
    }

}
