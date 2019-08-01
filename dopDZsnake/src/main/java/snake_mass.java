public class snake_mass {
    private int x=0;
    private int y=-1;
    private int NIiteration=0;
    private int snake_mass[][];
    snake_mass(int x, int y){
        snake_mass=new int[x][y];
        arrayImplementation();
    }

    void arrayImplementation(){

        int vectorX=1;
        int vectorY=1;
        int minWeight=Math.min(snake_mass.length, snake_mass[0].length);
        int way=minWeight;
        for(int i = 0;way>0;i++)
        {
            if(i%2==1) {
                go(vectorX,0,way+(snake_mass.length-minWeight),i);
                vectorX *= -1;
            }
            else {
                go(0,vectorY,way+(snake_mass[0].length-minWeight),i);
                vectorY*=-1;
                way--;
            }
        }
    }
    private void go(int vectorX, int vectorY, int way, int j){
        for(int i=0;i<way;i++) {
            x+=vectorX;
            y+=vectorY;
            snake_mass[x][y]=NIiteration;
            NIiteration++;
        }
    }
    public void showArr() {
        for (int i = 0; i <snake_mass.length; i++) {
            for (int j = 0; j < snake_mass[i].length; j++)
                System.out.printf("%4d", snake_mass[i][j]);
            System.out.println("");
        }
    }
}
