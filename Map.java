package Assignment1;
import java.nio.channels.FileChannel.MapMode;
import java.util.*;

/**
 * 
 * @author EECS2030 Team
 *
 */

public class Map {
	boolean [][] map; 
	private int row;
	private int column;
	/**
	 * This is the constructor that constructs the city map, 
	 * which is a grid of row by column.
	 * @param row is the number of east-west streets of the city
	 * @param column is the number of north-south streets of the city
	 */
	public Map(int row, int column) {
		// Please implement the constructor
 
		this.row = row;
		this.column = column;
		
	}
	/**
	 * This method checks the correctness of the input parameters. If the preconditions are not met 
	 * an exception is thrown, otherwise depending to the direction, it calls 
	 * one of the four recursive functions of goSouthWest, goSouthEast, goNorthWest and goNorthEast.
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre the integer parameters should be in the range of the city grid.(i.e. [0, N) if N is the number of east-west streets and [0, M) if 
	 * M is the number of north-south streets.) 
	 * @exception IllegalArgumentException if any of the precondition did not meet.
	 */
	
	public String getPath (int startRow, int startCol, int destRow, int destCol , String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		
		if ( startRow < 0 || startRow > row)
			throw new IllegalArgumentException();
		else if ( destRow < 0 || destRow > row)
			throw new IllegalArgumentException();
		else if ( startCol < 0 || startCol > column)
			throw new IllegalArgumentException();
		else if ( destCol < 0 || destCol > column)
			throw new IllegalArgumentException();
		else if ( startRow <= destRow && startCol <= destCol )
			path = goNorthEast(startRow, startCol, destRow, destCol, path);
		else if ( startRow <= destRow && destCol <= startCol )
			path = goNorthWest(startRow, startCol, destRow, destCol, path);
		else if ( destRow <= startRow && startCol <= destCol )
			path = goSouthEast(startRow, startCol, destRow, destCol, path);
		else if ( destRow <= startRow && destCol <= startCol )
			path = goSouthWest(startRow, startCol, destRow, destCol, path);
		return path;
		 
	}
	/**
	 * This method returns a path from the source (startRow, startCol) to the destination (destRow, destCol).
	 * Please note that the returning path does not include the starting point.  
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow >= destRow </code> and <code> startCol >= destCol </code>
	 */
	
	private String goSouthWest (int startRow, int startCol, int destRow, int destCol , String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		 
	        // If destination has been reached return path
	        if (startCol > destCol)
	        {
	            //West
	            path = path + " (" + startRow + "," + (startCol - 1) + ") ";
	            path = goSouthWest(startRow, startCol - 1, destRow, destCol, path);
	        }
	        else  if (startRow > destRow)
	        {
	            //South
	            path = path + " (" + (startRow - 1) + "," + startCol + ") ";
	            path = goSouthWest(startRow - 1, startCol, destRow, destCol, path);
	        }
	        return path;
		
	}
	
	/**
	 * This method returns a path from the source (startRow, startCol) to the destination (destRow, destCol).
	 * Please note that the returning path does not include the starting point. 
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow >= destRow </code> and <code> startCol <= destCol </code>
	 */
	private String goSouthEast (int startRow, int startCol, int destRow, int destCol , String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		if (destRow < startRow)
		{ 
			//South
			path = path + " (" + (startRow - 1) + "," + startCol + ") ";
			path = goSouthEast(startRow - 1, startCol, destRow, destCol, path);
		}
		else if (startCol < destCol)
		{   //East
			path = path + " (" + startRow + "," + (startCol + 1) + ") ";
			path = goSouthEast(startRow, startCol + 1, destRow, destCol, path);
		}
		return path;
	}
	
	/**
	 * This method returns a path from the source (startRow, startCol) to the destination (destRow, destCol).
	 * Please note that the returning path does not include the starting point. 
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow <= destRow </code> and <code> startCol >= destCol </code>
	 */
	private String goNorthEast (int startRow, int startCol, int destRow, int destCol , String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		if (destRow > startRow)
		{   //North
			path = path + " (" + (startRow + 1) + "," + startCol + ") ";
			path = goNorthEast(startRow + 1, startCol, destRow, destCol, path);
		}
		else if (startCol < destCol)
		{   //East
			path = path + " (" + startRow + "," + (startCol + 1) + ") ";
			path = goNorthEast(startRow, startCol + 1, destRow, destCol, path);
		}
		return path;
	}

	/**
	 * This method returns a path from the source (startRow, startCol) to the destination (destRow, destCol).
	 * Please note that the returning path does not include the starting point. 
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow <= destRow </code> and <code> startCol >= destCol </code>
	 */
	private String goNorthWest (int startRow, int startCol, int destRow, int destCol , String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		if (destRow > startRow)
		{   //North
			path = path + " (" + (startRow + 1) + "," + startCol + ") ";
			path = goNorthWest(startRow + 1, startCol, destRow, destCol, path);
		}
		else if (startCol > destCol)
        {   //West
            path = path + " (" + startRow + "," + (startCol - 1) + ") ";
            path = goNorthWest(startRow, startCol - 1, destRow, destCol, path);
        }
		return path;
	}
	
	/**
	 * This method find a path from (startRow, startCol) to a border point of the city. 
	 * Please note that the starting point should be included in the path.
	 * @param startRow is the starting row of the path
	 * @param startCol is the starting column of the path
	 * @return is a path from (starting row, staring col) to a border point of the city. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 */
	
	public String findPath (int startRow, int startCol) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		String path = "(" + startRow + "," + startCol + ")";
		path = getPath(startRow,startCol,0,0,path);
		return path;
	}
	} // end of class
