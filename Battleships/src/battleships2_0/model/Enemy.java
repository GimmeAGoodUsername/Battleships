package battleships2_0.model;

public class Enemy extends Arena {

    public Enemy(int row, int column) {
        super(row, column);
        // TODO Auto-generated constructor stub
    }
    
    public void set(int row, int column, boolean hit){
        if(hit){
            this.setValue(row, column, 'X');
        }else{
            this.setValue(row, column, 'O');
        }
    }
    public int numberOfHits(){
        int totalHits =0;
        for(int i = 0; i < 10; i++){
            for(int j = 0; j<10; j++){
                if(this.getGrid()[i][j]=='X')totalHits++;
            }
        }
        return totalHits;
    }
}
