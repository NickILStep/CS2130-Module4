package cs2130;

// Binary Relation Matrix class
public class MatrixRelation
{
    // Instance variables
    private int matrix[][];
    public int size;

    // Boolean matrix constructors

    public MatrixRelation(int s)
    {
        size = s;
        matrix = new int[size][size];
        // Fill with zeros
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                matrix[row][col] = 0;
            }
        }
    }

    public MatrixRelation(int[][] other)
    {
        size = other.length;
        matrix = new int[size][size];
        // Copy matrix B values into matrix
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                matrix[row][col] = other[row][col];
            }
        }
    }

    // Boolean matrix methods

    public void show()
    {
        // Display matrix
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                System.out.print("  " + matrix[row][col]);
            }
            System.out.println();
        }
        return;
    }

    public boolean isEqual(MatrixRelation other)
    {
        // Check if current matrix equals matrix M2
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                if(this.matrix[row][col] != other.matrix[row][col])
                    return false;
            }
        }
        return true;
    }

    public int arrows()
    {
        // No. of 1's in matrix
        int narrows = 0;
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                narrows = narrows + matrix[row][col];
            }
        }
        return narrows;
    }




    // *********************************
    // TODO: Add your code to the methods below
    // *********************************
    public MatrixRelation join(MatrixRelation other)
    {
        // Join to matrices together by performing a
        // logical OR of current matrix with matrix other
        // Don't modify this matrix "in-place" (i.e. make a copy)
        // TODO: Put code here...
        MatrixRelation result = new MatrixRelation(size);

        for(int row = 0; row < size; row++) {
            for(int col = 0; col < size; col++) {
                if(this.matrix[row][col] == 1 || other.matrix[row][col] == 1) {
                    result.matrix[row][col] = 1;
                }
            }
        }

        return result;
    }

    public MatrixRelation transpose()
    {
        // Transpose of current matrix
        // Switch the rows to columns and the columns to rows
        // Don't modify this matrix "in-place" (i.e. make a copy)
        // TODO: Put code here...
        MatrixRelation result = new MatrixRelation(size);
        
        for(int row = 0; row < size; row++) {
            for(int col = 0; col < size; col++) {
                result.matrix[col][row] = this.matrix[row][col];
            }
        }

        return result;

    }

    public MatrixRelation reflexiveClosure()
    {
        // Reflexive closure of current matrix
        // Add the necessary arrows to make the matrix reflexive
        // TODO: Put code here...
        MatrixRelation result = new MatrixRelation(size);

        for(int row = 0; row < size; row++) {
            for(int col = 0; col < size; col++) {
                result.matrix[row][col] = this.matrix[row][col];
            }
            result.matrix[row][row] = 1;
        }

        return result;
    }

    public MatrixRelation symmetricClosure()
    {
        // Symmetric closure of current matrix
        // Add the necessary arrows to make the matrix symmetric.
        // You may want to consider how the transpose of the matrix could be useful here.
        // TODO: Put code here...
        MatrixRelation result = new MatrixRelation(size);

        for(int row = 0; row < size; row++) {
            for(int col = 0; col < size; col++) {
                result = join(this.transpose());
            }
        }

        return result;
    }

    public int inDegree(int node)
    {
        // Number of arrows INTO node of digraph
        // Nodes are numbered 0,1,2,...,SIZE-1
        // TODO: Put code here...
        int in = 0;

        for(int row = 0; row < size; row++) {
            if(this.matrix[row][node] == 1) {
                in += 1;
            }
        }

        return in;
    }

    public int outDegree(int node)
    {
        // Number of arrows FROM node of digraph
        // Nodes are numbered 0,1,2,...,SIZE-1
        // TODO: Put code here...
        int out = 0;

        for(int col = 0; col < size; col++) {
            if(this.matrix[node][col] == 1) {
                out += 1;
            }
        }

        return out;
    }


    public boolean isRootedTree()
    {
        // Determine if this binary relation could represent a directed rooted tree
        // This means that there is exactly 1 node with in-degree of zero
        // and every other node has an in-degree of 1.
        // TODO: Put code here...
        int temp = 0;

        for(int node = 0; node < size; node++) {
            if(inDegree(node) == 0) {
                temp += 1;
            }
            else if(inDegree(node) != 1) {
                return false;
            }
        }

        if(temp == 1) {
            return true;
        }

        return false;
    }

} // end class
