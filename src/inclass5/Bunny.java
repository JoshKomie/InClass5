package bunnyhunt;

public class Bunny extends Animal {

    private int lastSeen = -1;
    public Bunny(Model model, int row, int column) {
        super(model, row, column);
    }
    
    @Override
    int decideMove() {
        for (int i = Model.MIN_DIRECTION; i < Model.MAX_DIRECTION; i++) {
            if (look(i) == Model.WOLF) {
                lastSeen = i;
            }
        }
        
        if (lastSeen != -1)
            return moveOpposite(lastSeen);
        else
            return random(Model.MIN_DIRECTION, Model.MAX_DIRECTION);
    }
    
    private int moveOpposite(int i) {
        int move =  Model.turn(i, 4);
                
        if (canMove(move))
            return move;
        else if (canMove(Model.turn(move, 1)))
            return Model.turn(move, 1);
        else if (canMove(Model.turn(move, -1)))
            return Model.turn(move, -1);
        else if (canMove(Model.turn(move, 2)))
            return Model.turn(move, 2);
        else if (canMove(Model.turn(move, -2)))
            return Model.turn(move, -2);
        else if (canMove(Model.turn(move, 3)))
            return Model.turn(move, 3);
        else if (canMove(Model.turn(move, -3)))
            return Model.turn(move, -3);
         else if (canMove(Model.turn(move, 4)))
            return Model.turn(move, 4);
        else if (canMove(Model.turn(move, -4)))
            return Model.turn(move, -4);
        else return 0;
    }
}


