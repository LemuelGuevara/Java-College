package TextMapCoordinates;

import java.util.*;

class MapCoord
{
    private final int r, c;

    // Constructor that takes in rows and columns
    public MapCoord(int r, int c)
    {
        this.r = r;
        this.c = c;
    }

    // Returns the row
    public int getRow()
    {
        return r;
    }

    // Returns the column
    public int getColumn()
    {
        return c;
    }

    public String toString()
    {
        String rowCoordinate;

        rowCoordinate = "(" + getRow() + "," + getColumn() + ")";

        return rowCoordinate;
    }
}

class TextMap
{
    char[][] characterArray;

    private final int rowCnt, colCnt;
    private final int mapRowSize, mapColumnSize;

    private char characterInput;
    private final char defaultChar;

    public TextMap(int rowCnt, int colCnt, char defaultChar)
    {
        this.rowCnt = rowCnt;
        this.colCnt = colCnt;
        this.defaultChar = defaultChar;

        characterArray = new char[getRowCnt()][getColCnt()];

        mapRowSize = getRowCnt();
        mapColumnSize = getColCnt();

        // Loads the 2D character array
        for (int i = 0; i <= characterArray.length - 1; i++)
            for (int j = 0; j <= characterArray[i].length - 1; j++)
                characterArray[i][j] = defaultChar;
    }

    // Gets row count
    public int getRowCnt()
    {
        return rowCnt;
    }

    // Gets column count
    public int getColCnt()
    {
        return colCnt;
    }

    // Checks if given map coordinate is valid
    public boolean isValidPosition(MapCoord coord)
    {
        boolean isValidCoord = false;
        int rowCoord, columnCoord;

        // Gets the MapCoord row and col given by the user
        rowCoord = coord.getRow();
        columnCoord = coord.getColumn();

        // Checks if given coordinate is within the index of the map
        if (rowCoord >= 0 && columnCoord >= 0)
            if (rowCoord < mapRowSize && columnCoord < mapColumnSize)
                isValidCoord = true;

        return isValidCoord;
    }

    // Checks if the position of the coordinate is valid and if valid it returns the input character
    // if not, it returns the default character
    public char getPos(MapCoord coord)
    {
        if (isValidPosition(coord))
                return characterInput; // Character input is taken from the setPos method (char c)
        else
            characterInput = defaultChar;

        return characterInput;
    }

    // If coordinate is valid, this sets the position of the input character into the given coordinates
    public boolean setPos(MapCoord coord, char c)
    {
        boolean validPos = false;
        int coordRow, coordColumn;

        // Gets the row and cols from the instance of MapCoord
        coordRow = coord.getRow();
        coordColumn = coord.getColumn();

        // Gets the character if coordinate is valid
        characterInput = c;
        characterInput = getPos(coord);

        if (isValidPosition(coord))
        {
            characterArray[coordRow][coordColumn] = characterInput;
            validPos = true;
        }

        return validPos;
    }

    // Prints the map data
    public String toString()
    {
        StringBuilder mapData = new StringBuilder();

        for (char[] rows : characterArray) {
            for (char data : rows)
                mapData.append(data);
            mapData.append("\n");
        }

        return mapData.toString();
    }
}

class MapEditor
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int defaultRows, defaultColumns, rowInput, columnInput;
        char defaultCharacter, characterInput;
        boolean validSetPos;

        System.out.println("\nROWS AND COLUMNS ARE ZERO BASE");

        // Gets the initial map data
        System.out.println("\nEnter rows, columns, and default character:");
        defaultRows = in.nextInt();
        defaultColumns = in.nextInt();
        defaultCharacter = in.next().charAt(0);

        // Creates an instance of TextMap then prints the map data
        TextMap defaultMap = new TextMap(defaultRows, defaultColumns, defaultCharacter);
        System.out.println(defaultMap);

        do
        {
            // Takes in another input from the user
            System.out.println("Enter row, column, and character:");
            rowInput = in.nextInt();
            columnInput = in.nextInt();
            characterInput = in.next().charAt(0);

            // Creates an instance of MapCoord then passes the row and column input
            MapCoord coordinates = new MapCoord(rowInput, columnInput);

            // Checks if position is valid then passes given coordinates and character
            validSetPos = defaultMap.setPos(coordinates, characterInput);

            // Prints the map
            System.out.println(defaultMap);

        } while (validSetPos);
    }
}
