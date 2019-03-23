public class exam {
    public static int[] flatten(int[][] x) {
        int totalLength = 0;
        for (int[] b : x) {
            totalLength += b.length;
        }
        int[] a = new int[totalLength];
        int aIndex = 0;
        for (int[] b : x) {
            System.arraycopy(b,0, a, aIndex, b.length);
            aIndex += b.length;
        }
        return a;
    }

    public static void main(String[] args){
        int[][] a = {{1,2,3},{},{4,5}};
        int[] b = flatten(a);
    }
}
