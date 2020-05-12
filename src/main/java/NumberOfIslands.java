package main.java;

/**
 * 二维数组表示，1代表陆地，0代表还有，有几块岛屿
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        if(grid.length<1){
            return 0;
        }
        int numIsland=0;
        int row=grid.length;
        int column=grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(grid[i][j]=='1'){
                    numIsland++;
                    bfs(grid,i,j,row,column);
                }
            }
        }
        return numIsland;
    }

    public void bfs(char[][] grid,int posX,int posY,int row,int column){
        if(posX<0 || posY<0 || posX >= row || posY>=column||grid[posX][posY]=='0'){
            return;
        }
        grid[posX][posY]='0';

        bfs(grid,posX-1,posY,row,column);
        bfs(grid,posX+1,posY,row,column);
        bfs(grid,posX,posY-1,row,column);
        bfs(grid,posX,posY+1,row,column);
    }


}
